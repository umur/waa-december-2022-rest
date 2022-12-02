package edu.miu.restdemo.dto;

import edu.miu.restdemo.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private int id;

    private String name;

    private int price;

    public Product toEntity(ProductDto dto){
        Product p = new Product();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        return p;
    }

    public ProductDto toDto(Product p){
        ProductDto dto = new ProductDto();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setPrice(p.getPrice());
        return dto;
    }

}
