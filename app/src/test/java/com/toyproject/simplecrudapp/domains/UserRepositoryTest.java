package com.toyproject.simplecrudapp.domains;

import com.toyproject.simplecrudapp._supports.GivenSupport;
import com.toyproject.simplecrudapp._supports.RepositoryTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName( "Domain Test :: User Repository" )
class UserRepositoryTest implements RepositoryTestSupport {

  @Autowired private UserRepository userRepository;

  private User givenUser;

  @BeforeEach
  void setUp() {
    givenUser = GivenSupport.givenUserFactory();
  }

  @DisplayName( "CREATE :: Save the User" )
  @Test
  void saveTest() {
    // When
    User savedUser = userRepository.save( givenUser );
    User expectedUser = GivenSupport.givenUserFactory(savedUser.getId());
    // Then
    commonThen_userCompareTest(expectedUser, savedUser);
  }

  @DisplayName( "READ :: Find the User by Email" )
  @Test
  void findByEmailTest() {
    fail("Fix me!");
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