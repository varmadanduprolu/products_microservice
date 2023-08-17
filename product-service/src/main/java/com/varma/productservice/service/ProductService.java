package com.varma.productservice.service;

import com.varma.productservice.dto.ProductRequest;
import com.varma.productservice.dto.ProductResponse;
import com.varma.productservice.entity.Product;
import com.varma.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product= Product.builder()
                        .name(productRequest.name())
                        .description(productRequest.description())
                         .price(productRequest.price())
                        .build();
        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> productList=productRepository.findAll();
        return productList.stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(), product.getName(), product.getDescription(), product.getPrice()
        );
    }

    public ProductResponse getProductById(Integer id) {
        Product product = productRepository.findById(id).get();
       return mapToProductResponse(product);
    }
}
