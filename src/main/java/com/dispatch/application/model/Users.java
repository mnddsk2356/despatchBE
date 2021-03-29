package com.dispatch.application.model;


/*******************************************************************************
 * 2017, this is the user entity class ,
 * this class implements users details of the spring security framework
 *******************************************************************************/

import com.dispatch.application.entities.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Users")
@Scope("session")
public  class Users implements UserDetails {




	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id ;
	/**
	 * Description of the property username.
	 */
	@Column(unique = true)
	private String username ;
	/**
	 * Description of the property password.
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank
	//@Size(min=0, max = 8)
	private String password ;
	/**
	 * Description of the property role , to grant authority to the user .
	 */
    private String  role;


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	private boolean enabled;



	public void setId(Long id) {
		this.id = id;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public List<UserCompliance> getUserComplainceList() {
		return userComplainceList;
	}

	public void setUserComplainceList(List<UserCompliance> userComplainceList) {
		this.userComplainceList = userComplainceList;
	}






	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	private String status;

	public UserBankDetails getUserBankDetails() {
		return userBankDetails;
	}

	public void setUserBankDetails(UserBankDetails userBankDetails) {
		this.userBankDetails = userBankDetails;
	}

	@OneToOne(cascade = CascadeType.ALL)
	private UserBankDetails userBankDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private UserPersonalDetails userPersonalDetails;

	public UserPersonalDetails getUserPersonalDetails() {
		return userPersonalDetails;
	}

	public void setUserPersonalDetails(UserPersonalDetails userPersonalDetails) {
		this.userPersonalDetails = userPersonalDetails;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinColumn(name = "company_id")

	private Company company;


	@OneToMany(mappedBy = "user" ,fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JsonManagedReference

	private List<UserCompliance> userComplainceList;




    public Users(){
    	
    }
    
    public Users(String username, String password, String fullName){
    	this.username=username;
    	this.password= password;

    }
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role +
				 ",]";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Long getId() {
		return id;
	}
	
	
	
}
