package com.springboot.dto.model;

public class ProductMapper {

	//convert dto to entity
	public static Product toEntity(ProductDto dto) {
		Product p = new Product();
		p.setId(dto.getId());
		p.setName(dto.getName());
		p.setPrice(dto.getPrice());
		return p;
	}
	
	//convert entity to dto
	public static ProductDto toDto(Product prod) {
		ProductDto dto = new ProductDto();
		dto.setId(prod.getId());
		dto.setName(prod.getName());
		dto.setPrice(prod.getPrice());
		return dto;
	}
}
