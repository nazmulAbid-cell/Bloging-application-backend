package com.nazmul.blog.repositories;

import com.nazmul.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CetagoryRepo extends JpaRepository<Category, Integer> {


}
