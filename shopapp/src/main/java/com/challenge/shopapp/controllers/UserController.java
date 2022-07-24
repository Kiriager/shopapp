package com.challenge.shopapp.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
  public Set<UserDto> getAllUsers() {
    return userMapper.toDto(userService.findAll());
  }

  @GetMapping(value = "/users/{id}")
  public UserDto getUser(@PathVariable("id") Long id) {
    User user = userService.find(id);
    return userMapper.toDto(user);
  }
  
  @PostMapping("/users")
  public UserDto addUser(@Valid @RequestBody CreateUserDto dto) {
    System.out.println(dto.toString());
    User newUser = userService.create(dto.getFirstName(), 
        dto.getLastName(), dto.getAmountOfMoney());
    return userMapper.toDto(newUser);
  }

  @PutMapping("/users/{userId}/buy-product")
  public UserDto buyProduct(@PathVariable("userId") Long userId, 
      @NotNull(message = "Product id is mandatory") 
      @RequestParam("productId") Long productId) {
    User updatedUser = userService.buyProduct(userId, productId);
    return userMapper.toDto(updatedUser);
  }

  @DeleteMapping(value = "/users/{id}")
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
