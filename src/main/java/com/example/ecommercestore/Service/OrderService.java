package com.example.ecommercestore.Service;

import com.example.ecommercestore.Dao.WebOrderDao;
import com.example.ecommercestore.model.LocalUser;
import com.example.ecommercestore.model.WebOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    WebOrderDao webOrderDao;

    public List<WebOrder> getOrder(LocalUser user){
        return  webOrderDao.findByUser(user);
    }

}
