package com.practice.spring_security6.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private record Product(Integer productId,String productName,double price){

    }

    List<Product> products=new ArrayList<>(List.of(  new Product(1, "Laptop", 850.50),
            new Product(2, "Smartphone", 499.99),
            new Product(3, "Headphones", 89.95)));

    @GetMapping
    public  List<Product> getProducts(){
        return  products;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
      products.add(product)  ;
      return  product;
    }
}
