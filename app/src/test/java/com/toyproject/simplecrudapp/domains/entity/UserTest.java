package com.toyproject.simplecrudapp.domains.entity;

import com.toyproject.simplecrudapp._supports.GivenSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName( "Domain Test :: User Entity [POJO]" )
class UserTest {

  private User givenUser;

  @BeforeEach
  void setUp() {
    givenUser = GivenSupport.givenUserFactory();
  }

  @DisplayName("Equal Case :: All fields are same")
  @Test
  void equalCaseTest() {
    User sameUser = User.builder()
                        .id(givenUser.getId())
                        .email( givenUser.getEmail() )
                        .password( givenUser.getPassword() )
                        .nickname( givenUser.getNickname() )
                        .build();

    assertTrue( sameUser.equals( givenUser ));
    assertEquals( sameUser.hashCode(), givenUser.hashCode() );
    assertEquals( sameUser, givenUser );
  }

  @DisplayName("Different Case :: Nothing to same")
  @Test
  void differentCaseTest() {
    User differentUser = User.builder()
                             .id(givenUser.getId() + 1)
                             .email( "diff_".concat( givenUser.getEmail() ) )
                             .password( "diff_".concat( givenUser.getPassword() ) )
                             .nickname( "diff_".concat( givenUser.getNickname() ) )
                             .build();

    assertFalse( differentUser.equals( givenUser ));
    assertNotEquals( differentUser.hashCode(), givenUser.hashCode() );
    assertNotEquals( differentUser, givenUser );
  }
}