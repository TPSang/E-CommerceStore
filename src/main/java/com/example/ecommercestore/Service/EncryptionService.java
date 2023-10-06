package com.example.ecommercestore.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.security.Security;

@Service
public class EncryptionService {
    // Set value cho ma hoa value cang lon ma hoa cang manh
    @Value("${encryption.salt.rounds}")

    // luu value da tao
    private int saltRounds;

    //bien tao values
    private String salt;

    //tao ra ma hoa

    @PostConstruct
    public void postConstruct(){
        salt = BCrypt.gensalt(saltRounds);
    }


    //mã hoa mat khau
    public String encrypPassword(String password){
        return BCrypt.hashpw(password,salt);
    }
    // gia mai mat khau
    public boolean verifyPassword(String password , String hash){
        return BCrypt.checkpw(password, hash);
    }
}
