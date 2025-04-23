package iuh.fit.productservice.mapper;

import iuh.fit.productservice.dto.response.ProductResponse;
import iuh.fit.productservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductResponse toProductResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setProductId(product.getProductId());
        response.setProductName(product.getProductName());
        response.setDescription(product.getDescription());
        response.setOriginalPrice(product.getOriginalPrice());
        response.setQuantityInStock(product.getQuantityInStock());
        response.setSalePrice(product.getSalePrice());
        response.setCategoryId(product.getCategoryId());
        return response;
    }



    public List<ProductResponse> toProductResponseList(List<Product> products) {
        return products.stream()
                .map(this::toProductResponse)
                .collect(Collectors.toList());
    }


}