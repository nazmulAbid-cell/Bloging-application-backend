package com.nazmul.blog.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private  Integer categoryId;

    @NotEmpty
    @Size(min = 4, message = "Min size of category title is 4")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10,message = "Min size of category description is 10")
    private  String categoryDescription;
}
