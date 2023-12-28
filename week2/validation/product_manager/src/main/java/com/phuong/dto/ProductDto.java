package com.phuong.dto;

import com.phuong.annotation.Author;
import com.phuong.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class ProductDto implements Validator {
    @PositiveOrZero
    private Integer id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 50)
    @Author
    private String name;

    @NotNull
    @PositiveOrZero
    private Double price;

    @NotNull
    private Category category;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (productDto.getPrice() < 1000) {
            errors.rejectValue("price", "", "Price should not be less than 1000!");
        }
    }
}
