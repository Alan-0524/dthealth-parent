package com.dthealth.dao.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String userAccount;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String roleCode;
    private String address;
    private String telephone;
    //0 normal,1 disable
    private String status;

    public User() {
    }

    public User(String id, String userAccount, String firstName, String middleName, String lastName, String password, String roleCode, String address, String telephone, String status) {
        this.id = id;
        this.userAccount = userAccount;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.roleCode = roleCode;
        this.address = address;
        this.telephone = telephone;
        this.status = status;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
