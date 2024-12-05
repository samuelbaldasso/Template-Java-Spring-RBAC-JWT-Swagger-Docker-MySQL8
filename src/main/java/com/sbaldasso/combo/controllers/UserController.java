package com.sbaldasso.combo.controllers;

import com.sbaldasso.combo.domains.User;
import com.sbaldasso.combo.dto.UserDTO;
import com.sbaldasso.combo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  public UserService userService;

  @GetMapping("/{id}")
  public User getById(@PathVariable Long id) throws Exception {
    return userService.findById(id);
  }

  @PostMapping
  public User create(@RequestBody UserDTO userDTO) throws Exception {
      return userService.createUser(userDTO);
  }

  @PutMapping("/{id}")
  public User putUser(@PathVariable Long id, @RequestBody UserDTO userDTO) throws Exception {
    return userService.updateUser(userDTO, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) throws Exception {
    userService.delete(id);
  }

}
