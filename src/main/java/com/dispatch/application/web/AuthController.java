package com.dispatch.application.web;


import com.dispatch.application.configuration.SecurityUtility;
import com.dispatch.application.entities.Audit;
import com.dispatch.application.entities.Company;
import com.dispatch.application.entities.Entities;
import com.dispatch.application.model.LoginRequest;
import com.dispatch.application.model.Users;
import com.dispatch.application.repository.AuditRepository;
import com.dispatch.application.service.CompanyService;
import com.dispatch.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@RequestMapping("/rest/auth")
@RestController

public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Autowired
    AuditRepository auditRepository;




    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity newUser(
                                 @Valid @RequestBody Users userrequest
    ) throws Exception {

        LOG.info("user {}", userrequest);


       // check username exists
        if (userService.findByUsername(userrequest.getUsername()) != null) {


            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

//        check email address exists
        if (userService.findByEmail(userrequest.getUserPersonalDetails().getEmail()) != null) {


            return new ResponseEntity<String>("Fail -> Email is already taken!",
                    HttpStatus.BAD_REQUEST);
        }


        Users user = new Users();
        user.setUsername(userrequest.getUsername());
        user.setUserPersonalDetails(userrequest.getUserPersonalDetails());

        user.setPassword(userrequest.getPassword());
        user.setRole(userrequest.getRole());


        // String password = SecurityUtility.randomPassword();

        String encryptedPassword = SecurityUtility.passwordEncoder().encode(userrequest.getPassword());
        user.setPassword(encryptedPassword);
        userService.save(user);

        return new ResponseEntity("User Added Successfully!", HttpStatus.OK);
    }


   /* @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ResponseEntity changePassword(@RequestBody PassChange passChange){

        User user = userService.findOne(passChange.getUserId());
        if(passChange.getPassword()!=null) {
            String encryptedPassword = SecurityUtility.passwordEncoder().encode(passChange.getPassword());
            user.setPassword(encryptedPassword);
        }

        user.setShowStatus(passChange.isShowStatus());

        userService.save(user);

        return new ResponseEntity("Password Changed Successfully!", HttpStatus.OK);
    }
*/

    @RequestMapping(value="login", method = RequestMethod.POST)
    public ResponseEntity loginPost(@Valid @RequestBody LoginRequest loginRequest) throws
            ServletException {


        if(loginRequest.getLoginAs().equalsIgnoreCase("SHIPPER")){

            return loginAsEntity(loginRequest.getUsername(),loginRequest.getPassword(),1);


        }else if (loginRequest.getLoginAs().equalsIgnoreCase("TRANSPORTER")){

            return loginAsEntity(loginRequest.getUsername(),loginRequest.getPassword(),2);

        } else{


            String message = null;
            if (loginRequest.getUsername() == null || loginRequest.getPassword() == null) {
                return new ResponseEntity<String>("Fail -> Username and password are required!",
                        HttpStatus.BAD_REQUEST);
            }

            String username = loginRequest.getUsername();//json.get("username");
            String password = loginRequest.getPassword();//json.get("password");

            Users user = userService.findByUsername(username);
            if (user == null) {
                //throw new ServletException("User name not found.");
                message = "User Not Found ";
                return new ResponseEntity<String>("User Not Found",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                // String encodePassword = SecurityUtility.passwordEncoder().encode("password");

                BCryptPasswordEncoder encoder = SecurityUtility.passwordEncoder();
                encoder.matches(password, user.getPassword());
                String pwd = user.getPassword();

                Map loginObject = new HashMap();

                if (!encoder.matches(password, user.getPassword())) {
                    return new ResponseEntity<String>("Fail -> password invalid",
                            HttpStatus.INTERNAL_SERVER_ERROR);

                } else {
                    message = "login success :";

                    Audit addAudit = new Audit();
                    Date date = new Date();
                    addAudit.setAudit_event("Login Event");
                    addAudit.setUserId(user.getId());
                    addAudit.setDate_created(new Date());
                    addAudit.setTime_created(new Date());
                    auditRepository.save(addAudit);

                }

            }
            // request.getSession(false).setMaxInactiveInterval(1);
        }
            return new ResponseEntity(true, HttpStatus.OK);

    }

    private ResponseEntity loginAsEntity(String username, String password, int typeId) {

        String message = null;
        Entities entities = new Entities();

        if (username == null || password == null) {
            return new ResponseEntity<String>("Fail -> company name and password are required!",
                    HttpStatus.BAD_REQUEST);
        }


        entities.setId(typeId);
        Company company = companyService.findByCompanyLoginName(username,entities);
        if (company == null) {
            //throw new ServletException("User name not found.");
            message = "Company login Not Found ";
            return new ResponseEntity<String>("Company login Not Found",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            // String encodePassword = SecurityUtility.passwordEncoder().encode("password");

            BCryptPasswordEncoder encoder = SecurityUtility.passwordEncoder();
            encoder.matches(password, company.getPassword());

            Map loginObject = new HashMap();

            if (!encoder.matches(password, company.getPassword())) {
                return new ResponseEntity<String>("Fail -> password invalid",
                        HttpStatus.INTERNAL_SERVER_ERROR);

            } else {
                message = "login success :";

                Audit addAudit = new Audit();
                Date date = new Date();
                addAudit.setAudit_event("Login Event for company");
                addAudit.setUserId(company.getId());
                addAudit.setDate_created(new Date());
                addAudit.setTime_created(new Date());
                auditRepository.save(addAudit);

            }

        }
        // request.getSession(false).setMaxInactiveInterval(1);

            return new ResponseEntity(true, HttpStatus.OK);

    }


    @RequestMapping(value = "/user/logout/{userId}", method = RequestMethod.POST)
    public String logout(HttpServletRequest request,@PathVariable("userId") Long userId) {
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
        Audit addAudit =new Audit();
        Date date = new Date();
        addAudit.setAudit_event("Logout Event");
        addAudit.setUserId(userId);
        addAudit.setDate_created(new Date());
        addAudit.setTime_created(new Date());
        auditRepository.save(addAudit);


        LOG.info("Logged out successful");
        return "logout success.";
    }
}
