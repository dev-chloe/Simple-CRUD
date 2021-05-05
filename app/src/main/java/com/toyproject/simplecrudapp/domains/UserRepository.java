package com.toyproject.simplecrudapp.domains;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {

  // Create
  User save(User newUser);

  // Read

  // Update

  // Delete

}
