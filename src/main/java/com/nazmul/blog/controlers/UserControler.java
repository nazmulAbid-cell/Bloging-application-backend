package com.nazmul.blog.controlers;

import com.nazmul.blog.dtos.UserDto;
import com.nazmul.blog.services.UserService;
import com.nazmul.blog.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserControler {
    @Autowired
    private  UserService userService;
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

//    PUT - update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
        UserDto updatedUser = this.userService.updateUser(userDto,uid);
        return  ResponseEntity.ok(updatedUser);

    }

    // DELETE - delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid) {
        this.userService.deleteUser(uid);
//        return new ResponseEntity<>(Map.of("message", "user deleted successfully"), HttpStatus.OK);
        return  new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted",true),HttpStatus.OK);
    }

//    GET - get all user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List <UserDto> userDtos = this.userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer uid){
        UserDto userDto = this.userService.getUserById(uid);
        return ResponseEntity.ok(userDto);
    }


}
