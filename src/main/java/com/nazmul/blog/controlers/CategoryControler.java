package com.nazmul.blog.controlers;

import com.nazmul.blog.dtos.CategoryDto;
import com.nazmul.blog.services.CetagoryService;
import com.nazmul.blog.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryControler {
    @Autowired
    private CetagoryService cetagoryService;
//    create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory = this.cetagoryService.createCetagory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }
//    update
@PutMapping("/{catId}")
public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
    CategoryDto updatedCategory = this.cetagoryService.updateCategory(categoryDto,catId);
    return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
}


//    delete
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        this.cetagoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully",true), HttpStatus.OK);
    }

//    get
@GetMapping("/{catId}")
public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
    CategoryDto categoryDto= this.cetagoryService.getCategory(catId);
    return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
}

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> catDtos= this.cetagoryService.getCategories();
        return new ResponseEntity< List<CategoryDto>>(catDtos, HttpStatus.OK);
    }

}