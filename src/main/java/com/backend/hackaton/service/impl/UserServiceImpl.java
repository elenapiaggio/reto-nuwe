package com.backend.hackaton.service.impl;

import com.backend.hackaton.entity.User;
import com.backend.hackaton.repository.IUserRepository;
import com.backend.hackaton.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public Optional<User> getUserById(String userId) {
    return userRepository.getUserById(userId);
  }

  @Override
  public Boolean deleteUserById(String userId) {
    return getUserById(userId).map(user -> {
      userRepository.deleteById(userId);
      return true;
    }).orElse(false);
  }

  @Override
  public Boolean update(User user, String userId) {
    return getUserById(userId).map(userToModify -> {
      user.setId(userId);
      userRepository.save(user);
      return true;
    }).orElse(false);
  }

}
