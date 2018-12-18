package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", "/product-list"})
    public String listProduct(Model model) {
        model.addAttribute("listProduct", productService.findAll());
        return "product-list";
    }

    @RequestMapping("/product-save")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-save";
    }

    @RequestMapping("/product-update/{id}")
    public String updateProduct(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product-update";
    }

    @RequestMapping("/saveProduct")
    public String doSaveProduct(@ModelAttribute("Product") Product product, Model model) {
        productService.save(product);
        model.addAttribute("listProduct", productService.findAll());
        return "redirect:product-list";
    }

    @RequestMapping("/updateProduct")
    public String doUpdateCustomer(@ModelAttribute("Customer") Product product, Model model) {
        productService.update(product);
        model.addAttribute("listCustomer", productService.findAll());
        return "redirect:product-list";
    }

    @RequestMapping("/productDelete/{id}")
    public String doDeleteProduct(@PathVariable int id, Model model) {
        productService.delete(id);
        model.addAttribute("listProduct", productService.findAll());
        return "redirect:/product-list";
    }
}
