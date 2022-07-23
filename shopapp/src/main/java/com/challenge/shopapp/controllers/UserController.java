package com.challenge.shopapp.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.challenge.shopapp.domain.User;
import com.challenge.shopapp.dto.CreateUserDto;
import com.challenge.shopapp.dto.UserDto;
import com.challenge.shopapp.mappers.UserMapper;
import com.challenge.shopapp.mappers.UserMapperImpl;
import com.challenge.shopapp.services.ProductService;
import com.challenge.shopapp.services.UserService;

@RestController
@Validated
public class UserController {
  //private final ProductService productService;
  private final UserService userService;
  private final UserMapper userMapper = new UserMapperImpl();

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/users")
  public Set<UserDto> getAllProducts() {
    return userMapper.toDto(userService.findAll());
  }

  @GetMapping(value = "/users/{id}")
  public UserDto getUser(@PathVariable("id") Long id) {
    User user = userService.find(id);
    return userMapper.toDto(user);
  }
  
  @PostMapping("/users")
  public UserDto addProduct(@Valid @RequestBody CreateUserDto dto) {
    User newUser = userService.create(dto.getFirstName(), 
        dto.getLastName(), dto.getAmountOfMoney());
    return userMapper.toDto(newUser);
  }

  @DeleteMapping(value = "/user/{id}")
  public void removeUser(@PathVariable("id") Long id) {
    userService.delete(id);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }
}
