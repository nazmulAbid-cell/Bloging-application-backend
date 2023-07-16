package com.nazmul.blog.dtos;

import com.nazmul.blog.entities.Category;
import com.nazmul.blog.entities.User;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private String  title;
    private String content;
    private String imageName;
    private String postedDate;
    private CategoryDto category;
    private UserDto user;

}
