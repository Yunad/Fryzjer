package com.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BcryptGeneratorTest {

    final private String PASSWORD = "password";
    private String hashedPassword;

    @BeforeClass
    public void encodePassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        hashedPassword = passwordEncoder.encode(PASSWORD);
    }

    @Test
    public void validatePasswordEncryption() {
        Assert.assertNotEquals(PASSWORD,hashedPassword,"Passwords were the same. Test failure");
    }

}