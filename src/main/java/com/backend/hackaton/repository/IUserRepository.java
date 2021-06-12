package com.backend.hackaton.repository;

import com.backend.hackaton.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends MongoRepository<User, String>{
  User save(User user);
  Optional<User> getUserById(String userId);
  void deleteById(String userId);
}
