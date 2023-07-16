package com.nazmul.blog.services.implementation;

import com.nazmul.blog.dtos.CategoryDto;
import com.nazmul.blog.entities.Category;
import com.nazmul.blog.exeptions.ResourceNotFoundException;
import com.nazmul.blog.repositories.CetagoryRepo;
import com.nazmul.blog.services.CetagoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CetagoryServiceImpl implements CetagoryService {

    @Autowired
    private CetagoryRepo cetagoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCetagory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.cetagoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.cetagoryRepo.findById(categoryId).orElseThrow(() ->new ResourceNotFoundException("Category ","Category id",categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updateCategory = this.cetagoryRepo.save(cat);
        return this.modelMapper.map(updateCategory,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.cetagoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
        this.cetagoryRepo.delete(cat);

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = this.cetagoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","Category id",categoryId));

        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.cetagoryRepo.findAll();
       List<CategoryDto> catDtos  = categories.stream().map(cat -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }
}
