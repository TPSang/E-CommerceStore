package com.example.ecommercestore.API.Controller.Oder;

import com.example.ecommercestore.Service.OrderService;
import com.example.ecommercestore.model.LocalUser;
import com.example.ecommercestore.model.WebOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<WebOrder> getOrder(@AuthenticationPrincipal LocalUser user) {
        return orderService.getOrder(user);
    }
}
