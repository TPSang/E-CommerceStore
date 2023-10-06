package com.example.ecommercestore.Service;

import com.example.ecommercestore.Dao.ProductDao;
import com.example.ecommercestore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public List<Product> getProduct(){
        return productDao.findAll();
    }
}
