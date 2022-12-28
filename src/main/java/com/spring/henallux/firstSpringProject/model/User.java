package com.spring.henallux.firstSpringProject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

    private String username;
    private String password;
    //
    private String lastName;
    private String firstName;
    private String email;
    private Integer phoneNumber;
    private String address;
    private String birthDate;
    private Integer tvaNumber;
    //
    private String authorities;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;

    public User(String username, String password, String lastName, String firstName, String birthDate, String email, Integer phoneNumber, String address, Integer tvaNumber, String authorities, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled) {
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



    public User() {
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (authorities != null && !authorities.isEmpty()) {
            String[] authoritiesAsArray = authorities.split(",");

            for (String authority : authoritiesAsArray) {
               if (authority != null && !authority.isEmpty()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }

        return grantedAuthorities;
    }

    //
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public Integer getTvaNumber() {
        return tvaNumber;
    }
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }




    public void setUsername(String username) {
        this.username = username;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setTvaNumber(Integer tvaNumber) {
        this.tvaNumber = tvaNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    //
}
