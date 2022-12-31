package com.spring.henallux.firstSpringProject.dataAccess.entity;


import static org.springframework.util.StringUtils.isEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name= "first_name")
    private String firstName;
    //
    @Column(name= "last_name")
    private String lastName;
    @Column(name= "email")
    private String email;
    @Column(name= "phone_number")
    private Integer phoneNumber;
    @Column(name= "address")
    private String address;
    @Column(name= "birth_date")
    private String birthDate;
    @Column(name= "tvaNumber")
    private String tvaNumber;
    @Column(name = "authorities")
    private String authorities;

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    private Boolean enabled;

    public UserEntity(String username, String password, String lastName, String firstName, String birthDate, String email, Integer phoneNumber, String address, String tvaNumber, String authorities, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled) {
        setUsername(username);
        setPassword(password);
        setLastName(lastName);
        setFirstName(firstName);
        setBirthDate(birthDate);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setTvaNumber(tvaNumber);


        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }


    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public String getEmail() {
        return email;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public String getTvaNumber() {
        return tvaNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setTvaNumber(String tvaNumber) {
        this.tvaNumber = tvaNumber;
    }

    @Override
    public String toString() {
        String output = "";
        output += getUsername() + "\n";
        output += getPassword() + "\n";
        output += getLastName() + "\n";
        output += getFirstName() + "\n";
        output += getBirthDate() + "\n";
        output += getEmail() + "\n";
        output += getPhoneNumber() + "\n";
        output += getAddress() + "\n";
        output += getTvaNumber() + "\n";
        output += getAuthorities() + "\n";
        output += getAccountNonExpired() + "\n";
        output += getAccountNonLocked() + "\n";
        output += getCredentialsNonExpired() + "\n";
        output += getEnabled() + "\n";
        return output;
    }
}
