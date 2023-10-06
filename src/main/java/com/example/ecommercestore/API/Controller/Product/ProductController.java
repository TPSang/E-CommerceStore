package com.example.ecommercestore.API.Controller.Product;

import com.example.ecommercestore.Service.ProductService;
import com.example.ecommercestore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProduct(){
        return productService.getProduct();
    }


}
