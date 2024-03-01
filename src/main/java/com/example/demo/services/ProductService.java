package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addNewProduct (Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct (String productId) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() ->  new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

    public Product updateProduct(String productId, Product product) {
        Product updateProduct = productRepository
                .findById(productId)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());
        return productRepository.save(updateProduct);
    }

    public Product getProductById (String productId) {
        return productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
