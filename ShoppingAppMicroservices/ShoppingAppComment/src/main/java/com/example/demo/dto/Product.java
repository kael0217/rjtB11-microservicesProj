package com.example.demo.dto;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.ui.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Builder.Default;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Document
public class Product {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	@Default
	private String colortype = "default color/type";
	@Default
	private String model = "default model";
	@Default
	private String brand = "no brand info";
	@Default
	private float price =100f;
	@Default
	private String description = "no description.";
	@ElementCollection
	private List<Category> categories;
	
	
}
