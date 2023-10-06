package com.example.ecommercestore.API.Controller.Auth;

import com.example.ecommercestore.API.DTO.LoginBody;
import com.example.ecommercestore.API.DTO.LoginRespone;
import com.example.ecommercestore.API.DTO.RegistratioBody;
import com.example.ecommercestore.API.Exception.UserAlreadyExitsException;
import com.example.ecommercestore.Service.UserService;
import com.example.ecommercestore.model.LocalUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public ResponseEntity<LocalUser> registerUser(@Valid @RequestBody RegistratioBody registratioBody) throws UserAlreadyExitsException {
        try {
            service.register(registratioBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExitsException e) {

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @PostMapping("/login")
    public ResponseEntity<LoginRespone> loginUser(@Valid @RequestBody LoginBody loginBody){
        String jwt = service.loginUser(loginBody);
        if (jwt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            LoginRespone response = new LoginRespone();
            response.setJwt(jwt);
            System.out.println(response);
            return ResponseEntity.ok(response);
        }
    }
    @GetMapping("/me")
    public  LocalUser getLoginUserProfile(@AuthenticationPrincipal LocalUser user){
        return user ;
    }
}