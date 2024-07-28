package org.example.springdemo.controller;

import org.example.springdemo.model.Product;
import org.example.springdemo.repository.SizeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.example.springdemo.repository.ProductRepo;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    SizeRepo sizeRepo;
    @PostMapping("/viewProduct")
    public String viewProduct(Model model) {
        List<Product> products = productRepo.findAll();
        for (Product product : products) {
            System.out.println("Productcontroller");
            System.out.println(product);
        }
        model.addAttribute("products", products);
        String profile = "profile";
        return profile;
    }
}
