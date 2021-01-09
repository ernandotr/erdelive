package com.rezende.erdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rezende.erdeliver.dto.ProductDTO;
import com.rezende.erdeliver.entities.Product;
import com.rezende.erdeliver.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = productRepository.findAllByOrderByNameAsc();
		return list.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
	}
}
