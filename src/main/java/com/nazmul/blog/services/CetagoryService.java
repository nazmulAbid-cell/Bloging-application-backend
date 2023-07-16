package com.nazmul.blog.services;

import com.nazmul.blog.dtos.CategoryDto;

import java.util.List;

public interface CetagoryService {
    //create
     CategoryDto createCetagory(CategoryDto categoryDto);

     //update
     CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

     //delete
     void deleteCategory(Integer categoryId);

//    get
     CategoryDto getCategory(Integer categoryId);

//     get all
    List<CategoryDto> getCategories();
}
