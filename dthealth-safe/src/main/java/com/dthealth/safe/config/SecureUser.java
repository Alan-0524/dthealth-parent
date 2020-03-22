package com.dthealth.safe.config;

import com.dthealth.dao.entity.User;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class SecureUser implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String id;
    private String userAccount;
    private String username;
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
    private Collection<? extends GrantedAuthority> authorities;

    public SecureUser(User user) {
        this.id = user.getId();
        this.userAccount = user.getUserAccount();
        this.username = user.getUserAccount();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.middleName = user.getMiddleName();
        this.lastName = user.getLastName();
        this.roleCode = user.getRoleCode();
        this.gender = user.getGender();
        this.dateOfBirth = user.getDateOfBirth();
        this.address = user.getAddress();
        this.telephone = user.getTelephone();
        this.createTime = user.getCreateTime();
        this.surgeryTime = user.getSurgeryTime();
        this.symptom = user.getSymptom();
        this.reexamination = user.getReexamination();
        this.status = user.getStatus();
        this.fullName = user.getFullName();
        this.shownGender = user.getShownGender();
        this.age = user.getAge();
        this.authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRoleCode()));;
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

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "SecureUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
