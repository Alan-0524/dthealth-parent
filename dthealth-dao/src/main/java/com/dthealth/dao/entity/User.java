package com.dthealth.dao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String userAccount;
    private String firstName;
    private String middleName;
    private String lastName;
    //0:female, 1:male, 3:other
    private String gender;
    private String dateOfBirth;
    private String password;
    private String roleCode;
    private String address;
    private String telephone;
    private String createTime;
    private String surgeryTime;
    private String symptom;
    private String reexamination;
    //0 normal,1 disable
    private String status;
    /**
     * for format
     */
    private String fullName;
    private String shownGender;
    private String age;
    public User() {
    }

    public User(String id, String userAccount, String firstName, String middleName, String lastName, String gender, String dateOfBirth, String password, String roleCode, String address, String telephone, String createTime, String surgeryTime, String symptom, String reexamination, String status, String fullName, String shownGender) {
        this.id = id;
        this.userAccount = userAccount;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.roleCode = roleCode;
        this.address = address;
        this.telephone = telephone;
        this.createTime = createTime;
        this.surgeryTime = surgeryTime;
        this.symptom = symptom;
        this.reexamination = reexamination;
        this.status = status;
        this.fullName = fullName;
        this.shownGender = shownGender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSurgeryTime() {
        return surgeryTime;
    }

    public void setSurgeryTime(String surgeryTime) {
        this.surgeryTime = surgeryTime;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getReexamination() {
        return reexamination;
    }

    public void setReexamination(String reexamination) {
        this.reexamination = reexamination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShownGender() {
        return shownGender;
    }

    public void setShownGender(String shownGender) {
        this.shownGender = shownGender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
