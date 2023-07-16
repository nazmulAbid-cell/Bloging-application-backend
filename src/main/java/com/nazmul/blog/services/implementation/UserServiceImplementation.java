package com.nazmul.blog.services.implementation;

import com.nazmul.blog.dtos.UserDto;
import com.nazmul.blog.entities.User;
import com.nazmul.blog.exeptions.ResourceNotFoundException;
import com.nazmul.blog.repositories.UserRepo;
import com.nazmul.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User updateUser = this.userRepo.save(user);
        return this.userToDto(updateUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User id",userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(this::userToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User id",userId));
        this.userRepo.delete(user);

    }
    private User dtoToUser(UserDto userDto){
        return this.modelMapper.map(userDto,User.class);
    }

    private UserDto userToDto(User user){
        return this.modelMapper.map(user,UserDto.class);
    }
}



















//package com.nazmul.blog.services.implementation;
//
//import com.nazmul.blog.dtos.UserDto;
//import com.nazmul.blog.entities.User;
//import com.nazmul.blog.exeptions.ResourceNotFoundException;
//import com.nazmul.blog.repositories.UserRepo;
//import com.nazmul.blog.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//@Service
//public class UserServiceImplementation implements UserService {
//    @Autowired
//    private UserRepo userRepo;
//    @Override
//    public UserDto createUser(UserDto userDto) {
//        User user = this.dtoToUser(userDto);
//        User savedUser = this.userRepo.save(user);
//        return this.userToDto(savedUser);
//    }
//
//    @Override
//    public UserDto updateUser(UserDto userDto, Integer userId) {
//        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id",userId));
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        User updateUser = this.userRepo.save(user);
//        return this.userToDto(updateUser);
//    }
//
//    @Override
//    public UserDto getUserById(Integer userId) {
//        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User id",userId));
//        return this.userToDto(user);
//    }
//
//    @Override
//    public List<UserDto> getAllUsers() {
//        List<User> users = this.userRepo.findAll();
//        return users.stream().map(this::userToDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteUser(Integer userId) {
//        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User id",userId));
//        this.userRepo.delete(user);
//
//    }
//
//
////instade of converting DTO to User and Use to DTO manually we will use madle mapper
////    private User dtoToUser(UserDto userDto){
////        User user = new User();
////        user.setId(userDto.getId());
////        user.setName(userDto.getName());
////        user.setEmail(userDto.getEmail());
////        user.setPassword(userDto.getPassword());
////        user.setAbout(userDto.getAbout());
////        return user;
////    }
////
////    private UserDto userToDto(User user){
////        UserDto userDto = new UserDto();
////        userDto.setId(user.getId());
////        userDto.setName(user.getName());
////        userDto.setEmail(user.getEmail());
////        userDto.setPassword(user.getPassword());
////        userDto.setAbout(user.getAbout());
////        return userDto;
////    }
//}
