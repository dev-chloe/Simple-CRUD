package com.toyproject.simplecrudapp.domains;

import com.toyproject.simplecrudapp.domains.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository< User, Long> {

  // Create
  User save(User newUser);

  // Read
  Optional<User> findByEmail(String email);

  // Update

  // Delete

}
