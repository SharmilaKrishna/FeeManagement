package com.fees.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Student {
	
	@Getter @Setter
    private Long id;
    
    @Getter @Setter
    @JsonProperty("name")
    private String name;
    
    @Getter @Setter
    @JsonProperty("studentId")
    private String studentId;
    
    @Getter @Setter
    @JsonProperty("grade")
    private String grade;
    
    @Getter @Setter
    @JsonProperty("mobileNumber") 
    private String mobileNumber;
    
    @Getter @Setter
    @JsonProperty("studentName") 
    private String studentName;
    
    @Getter @Setter
    @JsonProperty("schoolName")
    private String schoolName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
    

}
