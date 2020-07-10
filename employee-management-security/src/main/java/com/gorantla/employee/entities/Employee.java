package com.gorantla.employee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@SuppressWarnings("serial")
@Entity
@Table(name = "SPRINGBOOT_EMPLOYEE")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Eno")
	private Integer  eno;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String emailId;
	@Column(name = "MOBILE")
	private String mobile;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String emailId, String mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobile = mobile;
	}
	
	

	public Employee(Integer eno, String firstName, String lastName, String emailId, String mobile) {
		super();
		this.eno = eno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobile = mobile;
	}

	/**
	 * @return the eno
	 */
	public Integer getEno() {
		return eno;
	}

	/**
	 * @param eno the eno to set
	 */
	public void setEno(Integer eno) {
		this.eno = eno;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", mobile=" + mobile + "]";
	}
	
	


}
