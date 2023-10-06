package com.example.ecommercestore.Service;

import com.example.ecommercestore.API.DTO.LoginBody;
import com.example.ecommercestore.API.DTO.RegistratioBody;
import com.example.ecommercestore.API.Exception.UserAlreadyExitsException;
import com.example.ecommercestore.Dao.UserDao;
import com.example.ecommercestore.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userRepository;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private JwtService jwtService;


    public LocalUser register(RegistratioBody registratioBody) throws UserAlreadyExitsException {
        if (userRepository.findByEmailIgnoreCase(registratioBody.getEmail()).isPresent()
                || userRepository.findByUsernameIgnoreCase(registratioBody.getUsername()).isPresent()){
            throw new UserAlreadyExitsException();
        }
        LocalUser user = new LocalUser();
        user.setUsername(registratioBody.getUsername());
        user.setFistname(registratioBody.getFistname());
        user.setLastname(registratioBody.getLastname());
        user.setEmail(registratioBody.getEmail());
        user.setPassword(encryptionService.encrypPassword(registratioBody.getPassword()));
        return userRepository.save(user);
    }
    public  String loginUser(LoginBody loginBodybody){
        Optional<LocalUser> optionalUsers =userRepository.findByUsernameIgnoreCase(loginBodybody.getUsername());
        if(optionalUsers.isPresent()){
            LocalUser users = optionalUsers.get();
            if(encryptionService.verifyPassword(loginBodybody.getPassword(),users.getPassword())){
                return jwtService.generateJWT(users);
            }
        }
        return null;
    }

}
