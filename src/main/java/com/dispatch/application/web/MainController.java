package com.dispatch.application.web;

import com.dispatch.application.configuration.SecurityUtility;
import com.dispatch.application.entities.*;
import com.dispatch.application.model.*;
import com.dispatch.application.repository.*;
import com.dispatch.application.service.BidService;
import com.dispatch.application.service.CompanyService;
import com.dispatch.application.service.QuoteService;

import com.dispatch.application.util.DateFormatter;
import com.dispatch.application.util.FileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("/survey/resource")
@RestController
public class MainController {

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

	@Autowired
	CompanyService companyService;
	@Autowired
	BankDetailsRepo bankDetailsRepo;
	@Autowired
	OwnerDetailRepo ownerDetailRepo;
	@Autowired
	CompanyCompRepository companyCompRepository;
	@Autowired
	TruckTypeRepository truckTypeRepository;

	@Autowired
	BidRepository bidRepository;

	@Autowired
	BidService bidService;
	@Autowired
	QuoteService quoteService;
	@Autowired
	UserRepository userRepository;

	@GetMapping

	public String getResources() {
		return "hello";
	}

	@GetMapping("/endpoint")

	public String getResources1() {
		return "hello1";
	}


	@GetMapping("/secured")
	public String getSecuredResources() {
		return "secured data";
	}


	@RequestMapping(value = "/registerCompany", method = RequestMethod.POST)
	public ResponseEntity registerComp(
			@Valid @RequestBody Company company
	) throws Exception {

		LOG.info("Company {}", company);


		// check username exists
		if (companyService.findByCompanyLoginName(company.getCompanyLoginName(),company.getType()) != null) {


			return new ResponseEntity<String>("Fail -> Company Login is already taken!",
					HttpStatus.BAD_REQUEST);
		}
		// check username exists
		if (companyService.findByCompanyname(company.getCompanyName()) != null) {


			return new ResponseEntity<String>("Fail -> Company Name is already taken!",
					HttpStatus.BAD_REQUEST);
		}

//        check email address exists
		if (companyService.findByEmail(company.getEmail()) != null) {


			return new ResponseEntity<String>("Fail -> Company Email is already taken!",
					HttpStatus.BAD_REQUEST);
		}


		Company companyToSave = new Company();

		companyToSave.setCompanyName(company.getCompanyName());
		companyToSave.setCompanyLoginName(company.getCompanyLoginName());
		companyToSave.setAuthPerson(company.getAuthPerson());
		companyToSave.setMobile(company.getMobile());
		companyToSave.setEmail(company.getEmail());
		companyToSave.setCompAddress(company.getCompAddress());
		company.setBranch(company.getBranch());


		String encryptedPassword = SecurityUtility.passwordEncoder().encode(company.getPassword());
		company.setPassword(encryptedPassword);
		companyService.save(company);

		return new ResponseEntity("Company Added Successfully!", HttpStatus.OK);


	}

	@RequestMapping(value = "/completeCompanyReg", method = RequestMethod.POST)
	@Transactional
	public ResponseEntity compCompanyReg(
			 @RequestBody Company company
	) throws Exception {

		LOG.info("Company {}", company);
		Set<CompanyCompliance> companyComplianceHashSet = new HashSet<CompanyCompliance>();
		Set<Users> staffList = new HashSet<Users>();

		Company companyDB = companyService.findByCompanyLoginName(company.getCompanyLoginName());
		if(companyDB!=null) {

			if ( companyDB.getOwnerDetails() != null) {
				ownerDetailRepo.removeByOwnerDetailsId(companyDB.getOwnerDetails().getId()+1);
			}
			if (companyDB.getBankDetails() != null) {
				bankDetailsRepo.removeBybankDetailsId(companyDB.getBankDetails().getId()+1);
			}
			if(companyDB.getCompanyComplianceList().size()>0){
				companyCompRepository.removeBycompId(companyDB.getId());
			}

		}
		companyDB.setBankDetails(company.getBankDetails());
		companyDB.setOwnerDetails(company.getOwnerDetails());

		for (CompanyCompliance companyCompliance: company.getCompanyComplianceList()) {
			CompanyCompliance compcompliance = new CompanyCompliance();
			compcompliance = companyCompliance;
			compcompliance.setCompany(companyDB);
			companyComplianceHashSet.add(compcompliance);

		}

		for (Users user: company.getStaffList()) {

			user.setCompany(companyDB);
			staffList.add(user);

		}

		companyDB.setCompanyComplianceList(companyComplianceHashSet);
		companyDB.setStaffList(staffList);

		companyService.save(companyDB);
		//companyReq = company;

		return new ResponseEntity("Company Registration completed Successfully!", HttpStatus.OK);


	}

	@RequestMapping(value = "/add/companycomp/image/{companyId}/{filename}", method = RequestMethod.POST)
	public String upload(
			@RequestParam("picture") MultipartFile multipartFile1, @PathVariable("companyId") Long companyId,
			@PathVariable("filename") String filename,
			HttpServletResponse response, HttpServletRequest request
	) throws IOException {
		//String blobExtension = StringUtils.cleanPath(multipartFile1.getOriginalFilename().split(".")[1]);

		String blobExtension = "png";//multipartFile1.getOriginalFilename().split("\\.")[1];


		String uploadDir = "uploads/company/" + companyId+"/";

		FileUploadUtil.saveFile(uploadDir, filename+"."+blobExtension, multipartFile1);


		return "Upload Success";

	}

	@RequestMapping(value = "/add/usercomp/image/{companyId}/{filename}", method = RequestMethod.POST)
	public String uploadUserComp(
			@RequestParam("picture") MultipartFile multipartFile1, @PathVariable("companyId") Long companyId,
			@PathVariable("filename") String filename,
			HttpServletResponse response, HttpServletRequest request
	) throws IOException {
		//String blobExtension = StringUtils.cleanPath(multipartFile1.getOriginalFilename().split(".")[1]);

		String blobExtension = "png";//multipartFile1.getOriginalFilename().split("\\.")[1];


		String uploadDir = "uploads/company/" + companyId+"/staff_compliance/";

		FileUploadUtil.saveFile(uploadDir, filename+"."+blobExtension, multipartFile1);


		return "Upload Success";

	}



	@RequestMapping(value = "/getCompanyCompliceDocImage/{compId}/{imageName}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getComplianceDocImage(@PathVariable("imageName") String imageName, @PathVariable("compId") Long compId) throws IOException {



		File img = new File("uploads/company/"+compId+"/"+imageName+".png");
		return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));

	}
	@GetMapping("/getComplianceDocPdf")
	public ResponseEntity<byte[]> what() throws IOException{
		File file = new File("uploads/company/6/doc.pdf");
		return ResponseEntity.ok()
				.header("Content-Disposition", "attachment; filename=" +file.getName())
				.contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(file)))
				.body(Files.readAllBytes(file.toPath()));
	}

	@GetMapping("/getCompanyCompliceDocList/{compId}")
	public Set<CompanyCompliance> getCompanyCompliceDocList(@PathVariable("compId") Long compId){

		Company company = companyService.findByCompanyById(compId);


		return company.getCompanyComplianceList();

	}
	@PostMapping("/createBid")
	public ResponseEntity createBid(@RequestBody BidRequest bidRequest){

		bidService.createBid(bidRequest);
		return new ResponseEntity("Bid Created Successfully!", HttpStatus.OK);
	}

	@PostMapping("/negotiateBid")
	public ResponseEntity negotiateBid(@RequestBody NegotiateQuoteReq negotiateQuoteReq){

		Quote quote = quoteService.getQuoteById(negotiateQuoteReq.getQuoteId());
		quote.setNegotiatePrice(negotiateQuoteReq.getNegotiatePrice());
		quoteService.save(quote);
		return new ResponseEntity("Bid Negotiated Successfully!", HttpStatus.OK);
	}
	@GetMapping("rejectQuoteById/{quoteId}")

	public String rejectQuoteById(@PathVariable("quoteId") int quoteId){
		Quote quote = quoteService.getQuoteById(quoteId);
		quote.setQuoteStatus("Rejected");
		quote.setRemark("Not Applicable");
		quoteService.save(quote);

		return "Quote Rejection suucessful";

	}

	@GetMapping("checkQuoteByCompanyId/{compId}")

		public List<Quote> checkQuoteByCompanyId(@PathVariable("compId") Long compId){

			List<Quote> quoteList = quoteService.quoteList().stream()
							.filter(x->x.getQuoteById()==compId).collect(Collectors.toList());

			return quoteList;

		}



	@GetMapping("/receiveQuotes/{compId}")
	public ResponseEntity receiveQuotes(@PathVariable("compId") Long compId){

		Company company1 = new Company();
		company1.setId(2l);
		Company company2 = new Company();
		company2.setId(3l);
		Company company3 = new Company();
		company3.setId(4l);
		Company company4 = new Company();
		company4.setId(5l);
		Company company5 = new Company();
		company4.setId(6l);
		List<Quote> quoteArrayList = Arrays.asList(new Quote(1,  new BigDecimal(12000.0), 1l),
				new Quote(2, new BigDecimal(9500.0), 1l),
				new Quote(3,  new BigDecimal(9000.0), 2l),
				new Quote(4, new BigDecimal(8000.0), 3l),
		new Quote(5, new BigDecimal(18000.0), 4l))
				;



		Comparator<Quote> comparator = Comparator.comparing( Quote::getQuotePrice );


		quoteArrayList.sort(Comparator.comparing(Quote::getQuotePrice));

		quoteArrayList.forEach(System.out::println);

		List<Quote> firstThreeQuotesWithMinQuotePrice = quoteArrayList.stream().limit(3).collect(Collectors.toList());
		//Collections.sort(quoteArrayList, (c1, c2) -> c2.getQuotePrice().compareTo(c1.getQuotePrice()));
		System.out.println("Three quotes with min price = " + firstThreeQuotesWithMinQuotePrice);
		return new ResponseEntity("Bid Created Successfully!", HttpStatus.OK);
	}

	@GetMapping("/receiveBids/{compId}")
	public List<BidMaster> receiveBids(@PathVariable("compId") Long compId){

		Company company = companyService.findByCompanyById(compId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<BidMaster> bidMasterList = new ArrayList();
		if(company.getType().getId() == 2){
			LOG.info("Company is Transporter");


		} else{
			LOG.error("To receive bids you must be transporter");
			BidMaster bidMaster = new BidMaster();
			bidMaster.setComment("To receive bids you must be transporter");
			bidMasterList.add(bidMaster);
			 return  bidMasterList;
		}

		 bidMasterList = bidService.getBidList().stream().
				filter(x-> !x.getStatus().equals("Accepted") &&
						DateFormatter.isDateInBetweenIncludingEndPoints(
								x.getBidStartDate(),
									x.getBidCloseDate(),
								new Date()
								)

				).collect(Collectors.toList());
		if(bidMasterList.size()==0){
			LOG.error("Sorry No active bids, or you are late");
			BidMaster bidMaster = new BidMaster();
			bidMaster.setComment("Sorry No active bids, or you are late");
			bidMasterList.add(bidMaster);

		}
		return bidMasterList;


	}

	@GetMapping("/getTruckType")
	public List<TruckType> getTruckType(){

		return truckTypeRepository.findAll();

	}

	@PostMapping("/createQuote")

	public ResponseEntity createQuote(@RequestBody QuoteRequest quoteRequest ){

		List<BidMaster> bidMasterList = bidService.getBidList();

		bidMasterList = bidMasterList.stream().
				filter(bidmast->bidmast.getId()==quoteRequest.getBidId()).
				collect(Collectors.toList());
		BidMaster bidMaster = bidMasterList.get(0);
		List<Quote> quoteList = new ArrayList<>();
		Quote quote = new Quote();
		Company bidBy = new Company();
		bidBy.setId(quoteRequest.getBidFromId());
		Company quoteBy = new Company();
		quoteBy.setId(quoteRequest.getQuoteById());
		quote.setQuotePrice(quoteRequest.getQuotePrice());
		quote.setQuoteById(quoteRequest.getQuoteById());
		quote.setQuotePrice(quoteRequest.getQuotePrice());
		quote.setTripAssigned(bidMaster.getTripAssigned());
		quote.setQuoteStatus("Quoted");

		quote.setBidMaster(bidMaster);
		quoteList.add(quote);

		bidMaster.setQuoteList(quoteList);

		bidRepository.save(bidMaster);

		return new ResponseEntity("Quote Created Successfully! for bidId "+quoteRequest.getBidId()+" with Price "+quoteRequest.getQuotePrice(), HttpStatus.OK);

	}

	@GetMapping("/getQuotes/{companyId}/{bidId}")

	public BidMaster getQuotes(@PathVariable("companyId") Long companyId ,@PathVariable("bidId") Long bidId){

		List<BidMaster> bidMasterList = bidService.getBidList();

		bidMasterList = bidMasterList.stream().filter(x->x.getBidBy().getId()== companyId && x.getId() == bidId ).collect(Collectors.toList());

		BidMaster bidMaster = bidMasterList.get(0);
		List<Quote> quoteArrayList = bidMaster.getQuoteList();
		Comparator<Quote> comparator = Comparator.comparing( Quote::getQuotePrice );


		quoteArrayList.sort(Comparator.comparing(Quote::getQuotePrice));

		quoteArrayList.forEach(System.out::println);

		List<Quote> firstThreeQuotesWithMinQuotePrice = quoteArrayList.stream().limit(3).collect(Collectors.toList());

		BidMaster resultBidMaster = new BidMaster();
		resultBidMaster.setId(bidMaster.getId());

		resultBidMaster.setShipFrom(bidMaster.getShipFrom());
		resultBidMaster.setShipTo(bidMaster.getShipTo());
		resultBidMaster.setTargetPrice(bidMaster.getTargetPrice());
		resultBidMaster.setShipFromZoneId(bidMaster.getShipFromZoneId());
		resultBidMaster.setShipToZoneId(bidMaster.getShipToZoneId());
		resultBidMaster.setTripAssigned(bidMaster.getTripAssigned());
		resultBidMaster.setTruckType(bidMaster.getTruckType());
		resultBidMaster.setDropLocation(bidMaster.isDropReq()?bidMaster.getDropLocation():null);
		resultBidMaster.setQuoteList(firstThreeQuotesWithMinQuotePrice);

		return resultBidMaster;

	}

	@PostMapping("/addTrucks")

	public String  addTrucks(@RequestBody TruckRequest truckRequest){

		Company company = companyService.findByCompanyById(truckRequest.getCompanyId());

		if(company.getType().getEntityName().equals("SHIPPER")){
			return "SHIPPER Cant add Truck";

		}

		Truck truck = new Truck();
		Set<Truck> truckList = company.getTruckSet().size()>0?company.getTruckSet():new HashSet<>();

		truck.setCompany(company);
		truck.setTruckTypeId(truckRequest.getTruckTypeId());
		truck.setRegNumber(truckRequest.getTruckRegNumber());
		truckList.add(truck);
		company.setTruckSet(truckList);

		companyService.save(company);

		return "Truck added successfully";

	}

	@PostMapping("/addStaffs")

	public String  addStaffs(@RequestBody StaffRequest staffRequest){

		Company company = companyService.findByCompanyById(staffRequest.getCompId());

		Users user = new Users();
		Set<Users> staffList = company.getStaffList().size()>0?company.getStaffList():new HashSet<>();
		List<UserCompliance> userComplianceList = new ArrayList<>();
		user.setUserPersonalDetails(staffRequest.getUserPersonalDetails());
		user.setUserBankDetails(staffRequest.getUserBankDetails());
		//user.setUserComplainceList(staffRequest.getUserComplianceList());
		for(UserCompliance userCompliance:staffRequest.getUserComplianceList()){
			UserCompliance userCompliance1 = userCompliance;
			userCompliance1.setUser(user);
			userComplianceList.add(userCompliance1);
		}
		user.setUserComplainceList(userComplianceList);
		user.setRole(staffRequest.getRoleName());
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(staffRequest.getPassword());
		user.setPassword(encryptedPassword);
		user.setCompany(company);
		staffList.add(user);
		company.setStaffList(staffList);

		companyService.save(company);

		return "Employee added successfully";

	}
	
	


	@GetMapping("/acceptQuote/{compId}/{bidId}/{quoteId}")

	public BidMaster acceptQuote(@PathVariable("compId") Long companyId ,@PathVariable("bidId") Long bidId,@PathVariable("quoteId") Long quoteId){

		BidMaster bidMaster = bidRepository.findById(bidId.intValue()).get();
		List<Quote> quoteList = bidMaster.getQuoteList();

		//quoteList = quoteList.stream().filter(x->x.getQuoteById() == quoteId).collect(Collectors.toList());
		Quote quote = quoteList.get(0);
		List<Quote> resultQuoteList = new ArrayList<>();
		for(Quote quote1 :quoteList ){

			if(quote1.getQuoteById() == quoteId){
				quote1.setQuoteStatus("Accepted");
				resultQuoteList.add(quote1);
			}else{
				resultQuoteList.add(quote1);
			}
		}
		quote.setQuoteStatus("Accepted");
		bidMaster.setStatus("Accepted");
		bidMaster.setQuoteList(resultQuoteList);

		BidMaster resultBidMaster = bidRepository.save(bidMaster);

		return resultBidMaster;

	}
	
	@PostMapping(value="/addBranch/{compId}")
	public Company addBranchToCompany(@PathVariable("compId") Long compId , @RequestBody  BranchRequest branchRequest  ) {

		Company company = companyService.findByCompanyById(compId);

		Set<Branch> branches = company.getBranch().size()>0?company.getBranch():new HashSet();
		Branch branch = new Branch();
		branch.setBranchName(branchRequest.getBranchName());
		branch.setCompany(company);
		branch.setBranchLocation(branchRequest.getLocation());
		branch.setBranchAddress(branchRequest.getAddress());
		branch.setPincode(branchRequest.getPincode());
		branch.setHeadOffice(branchRequest.isHeadOff());
		branch.setZoneId(branchRequest.getZoneId());
		branches.add(branch);
		company.setBranch(branches);

		companyService.save(company);

		return company;
	}
	
	@GetMapping(value="/getCompanyNotifications/{compId}")

	public List<Notification> getCompanyNotifications(@PathVariable("compId") Long compId) throws ParseException {

		Company company = companyService.findByCompanyById(compId);

		Set<CompanyCompliance> companyComplianceList = company.getCompanyComplianceList();
		List<Notification> notificationList = new ArrayList<>();
		for(CompanyCompliance companyCompliance:companyComplianceList){
			Notification notification = new Notification();
				if(DateFormatter.isExpiredDocument(new Date(),companyCompliance.getValidTo())){
					notification.setMessage("Renewal Required for "+companyCompliance.getDocumentName());
				}
				if(DateFormatter.remindSevenDaysBeforeExpiry(new Date(),companyCompliance.getValidTo())){
					notification.setMessage("Kindly Renew your "+companyCompliance.getDocumentName()+" it is about to expiry on "+companyCompliance.getValidTo());
				}
				if(notification.getMessage()!=null) {
					notificationList.add(notification);
				}
		}
return notificationList;
	}

	@GetMapping(value="/getEmployeeNotifications/{userId}")

	public List<Notification> getEmployeeNotifications(@PathVariable("userId") Long userId) throws ParseException {

		List<Users> users =userRepository.findAll().stream().filter(x->x.getId()==userId).collect(Collectors.toList());

		List<UserCompliance> userComplianceList = users.get(0).getUserComplainceList();
		List<Notification> notificationList = new ArrayList<>();
		for(UserCompliance userCompliance:userComplianceList){
			Notification notification = new Notification();
			if(DateFormatter.isExpiredDocument(new Date(),userCompliance.getValidTo())){
				notification.setMessage("Renewal Required for "+userCompliance.getDocumentName());
			}
			if(DateFormatter.remindSevenDaysBeforeExpiry(new Date(),userCompliance.getValidTo())){
				notification.setMessage("Kindly Renew your "+userCompliance.getDocumentName()+" it is about to expiry on "+userCompliance.getValidTo());
			}
			if(notification.getMessage()!=null) {
				notificationList.add(notification);
			}
		}
		return notificationList;
	}

}