package com.rakesh.Ecommerce_using_SpringBoot.Repo;

import com.rakesh.Ecommerce_using_SpringBoot.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
