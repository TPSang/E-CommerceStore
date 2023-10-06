package com.example.ecommercestore.Dao;

import com.example.ecommercestore.model.LocalUser;
import com.example.ecommercestore.model.WebOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebOrderDao extends JpaRepository<WebOrder,Long> {
    List<WebOrder> findByUser(LocalUser user);
}
