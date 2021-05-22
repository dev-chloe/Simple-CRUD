package com.toyproject.simplecrudapp.domains;

import com.toyproject.simplecrudapp._supports.GivenSupport;
import com.toyproject.simplecrudapp._supports.RepositoryTestSupport;
import com.toyproject.simplecrudapp.domains.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName( "Domain Test :: User Repository" )
class UserRepositoryTest implements RepositoryTestSupport {

  @Autowired private UserRepository userRepository;

  private User givenUser;

  @BeforeEach
  void setUp() {
    givenUser = GivenSupport.givenUserFactory();
  }

  @AfterEach
  void cleanUp() { userRepository.deleteAll(); }

  @DisplayName( "CREATE :: Save the User" )
  @Test
  void saveTest() {
    // When
    User savedUser = userRepository.save( givenUser );
    // Then
    User expectedUser = GivenSupport.givenUserFactory(savedUser.getId());
    commonThen_userCompareTest(expectedUser, savedUser);
  }

  @DisplayName( "READ :: Find the User by Email" )
  @Test
  void findByEmailTest() {
    // When > Then
    Optional<User> notExistUser = userRepository.findByEmail( givenUser.getEmail() );
    assertFalse( notExistUser.isPresent(), "User must not be exist before the save action." );

    // When > Then
    User savedUser = userRepository.save( givenUser );
    Optional<User> foundUser = userRepository.findByEmail( savedUser.getEmail() );
    assertTrue( foundUser.isPresent(), "User must be found after the save action." );
  }

  private void commonThen_userCompareTest(User expectedUser, User targetUser) {
    // Prevent to compare itself
    assertNotSame( expectedUser, targetUser );
    // Field Variables
    assertEquals( expectedUser.getId(), targetUser.getId() );
    assertEquals( expectedUser.getEmail(), targetUser.getEmail() );
    assertEquals( expectedUser.getPassword(), targetUser.getPassword() );
    assertEquals( expectedUser.getNickname(), targetUser.getNickname() );
    // Method
    assertEquals( expectedUser.toString(), targetUser.toString() );
  }
}