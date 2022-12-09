package com.spring.henallux.firstSpringProject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptPasswordTemp {
    public static void main(String[] args) {

        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
        System.out.println(crypt.encode("salut"));
    }
}
