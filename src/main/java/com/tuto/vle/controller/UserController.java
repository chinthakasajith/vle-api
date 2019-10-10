package com.tuto.vle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.repositories.UserRepository;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  // @GetMapping("/user/me")
  // @PreAuthorize("hasRole('USER')")
  // public User getCurrentUser(UserPrincipal userPrincipal) {
  // return userRepository.findById(userPrincipal.getId())
  // .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
  // }
}
