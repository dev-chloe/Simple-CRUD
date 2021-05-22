package com.toyproject.simplecrudapp.domains.res;

import com.toyproject.simplecrudapp.domains.entity.User;
import com.toyproject.simplecrudapp._supports.GivenSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName( "Domain Test :: User Response DTO [POJO]" )
class UserResDtoTest {

  private User givenUser;

  @BeforeEach
  void setUp() {
    givenUser = GivenSupport.givenUserFactory();
  }

  @DisplayName("Equal Case :: All fields are same")
  @Test
  void equalCaseTest() {
    UserResDto userResDto = UserResDto.factory( givenUser );
    UserResDto sameUserResDto = UserResDto.factory( givenUser );

    assertEquals( userResDto.toString(), sameUserResDto.toString());
    assertEquals( userResDto.toString(), String.format( "UserResDto > id: '%d', email: '%s', nickname: '%s'",
                                                        givenUser.getId(),
                                                        givenUser.getEmail(),
                                                        givenUser.getNickname()) );
    assertTrue( userResDto.equals( sameUserResDto ));
    assertEquals( userResDto.hashCode(), sameUserResDto.hashCode() );
    assertEquals( userResDto, sameUserResDto );
  }

  @DisplayName("Different Case :: Nothing to same")
  @Test
  void differentCaseTest() {
    UserResDto userResDto = UserResDto.factory( givenUser );
    UserResDto diffUserResDto = UserResDto.factory(
        User.builder()
            .id(givenUser.getId() + 1)
            .email( "diff_".concat( givenUser.getEmail() ) )
            .nickname( "diff_".concat( givenUser.getNickname() ) )
            .password( "diff_".concat( givenUser.getPassword() ) )
            .build()
    );

    assertFalse( userResDto.equals( diffUserResDto ));
    assertNotEquals( userResDto.hashCode(), diffUserResDto.hashCode() );
    assertNotEquals( userResDto, diffUserResDto );
  }

  /*
   * TODO Password Encrypt Test
   */
}