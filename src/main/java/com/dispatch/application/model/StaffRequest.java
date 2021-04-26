package com.dispatch.application.model;

import com.dispatch.application.entities.Branch;
import com.dispatch.application.entities.UserBankDetails;
import com.dispatch.application.entities.UserCompliance;
import com.dispatch.application.entities.UserPersonalDetails;

import java.util.List;

public class StaffRequest {

    private Long compId;

    public Long getBranchID() {
        return branchID;
    }

    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }

    private Long branchID;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    private Branch branch;

    private String roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private List<UserCompliance> userComplianceList;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserCompliance> getUserComplianceList() {
        return userComplianceList;
    }

    public void setUserComplianceList(List<UserCompliance> userComplianceList) {
        this.userComplianceList = userComplianceList;
    }

    public UserPersonalDetails getUserPersonalDetails() {
        return userPersonalDetails;
    }

    public void setUserPersonalDetails(UserPersonalDetails userPersonalDetails) {
        this.userPersonalDetails = userPersonalDetails;
    }

    public UserBankDetails getUserBankDetails() {
        return userBankDetails;
    }

    public void setUserBankDetails(UserBankDetails userBankDetails) {
        this.userBankDetails = userBankDetails;
    }

    private UserPersonalDetails userPersonalDetails;

    private UserBankDetails userBankDetails;



}
