package com.rakesh.Ecommerce_using_SpringBoot.Controller;

import com.rakesh.Ecommerce_using_SpringBoot.Model.Product;
import com.rakesh.Ecommerce_using_SpringBoot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = service.getProductById(id);
        if(product != null) return new ResponseEntity<>(product, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addPoduct(@RequestPart Product product,
                                       @RequestPart MultipartFile imageFile) {
        try {
            Product fproduct = service.addProduct(product, imageFile);
            return new ResponseEntity<>(fproduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int productId) {

        Product product = service.getProductById(productId);
        byte[] imageFile = product.getImageDate();

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

    @PutMapping("/product/{pid}")
    public ResponseEntity<String> updateProduct(@PathVariable int pid, @RequestPart Product product,
                                                @RequestPart MultipartFile imageFile) throws IOException {

        Product p = service.updateProduct(pid, product, imageFile);

        if(p != null) return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        else return new ResponseEntity<>("Couldn't Updated", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/product/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable int pid) {

        Product p = service.getProductById(pid);

        if(p != null)
        {
            service.deleteProduct(pid);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Product Not Fount",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {

        List<Product> p = service.searchProducts(keyword);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
