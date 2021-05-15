package com.toyproject.simplecrudapp.domains.req;

import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.supports.GivenSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName( "Domain Test :: User Request DTO [POJO]" )
class UserReqDtoTest {

  private User givenUser;

  @BeforeEach
  void setUp() {
    givenUser = GivenSupport.givenUserFactory();
  }

  @DisplayName("Equal Case :: All fields are same")
  @Test
  void equalCaseTest() {
    UserReqDto userReqDto = UserReqDto.builder()
                                      .email( givenUser.getEmail() )
                                      .password( givenUser.getPassword() )
                                      .nickname( givenUser.getNickname() )
                                      .build();
    UserReqDto sameUserReqDto = UserReqDto.builder()
                                          .email( userReqDto.getEmail() )
                                          .password( userReqDto.getPassword() )
                                          .nickname( userReqDto.getNickname() )
                                          .build();

    assertEquals( userReqDto.toString(), sameUserReqDto.toString());
    assertEquals( userReqDto.toString(), String.format( "UserReqDto > email: '%s', nickname: '%s', password: (hidden)",
                                                        givenUser.getEmail(),
                                                        givenUser.getNickname()) );
    assertTrue( userReqDto.equals( sameUserReqDto ));
    assertEquals( userReqDto.hashCode(), sameUserReqDto.hashCode() );
    assertEquals( userReqDto, sameUserReqDto );
  }

  @DisplayName("Different Case :: Nothing to same")
  @Test
  void differentCaseTest() {
    UserReqDto userReqDto = UserReqDto.builder()
                                      .email( givenUser.getEmail() )
                                      .password( givenUser.getPassword() )
                                      .nickname( givenUser.getNickname() )
                                      .build();
    UserReqDto diffUserReqDto = UserReqDto.builder()
                                          .email( "diff_".concat( userReqDto.getEmail() ) )
                                          .password( "diff_".concat( userReqDto.getPassword() ) )
                                          .nickname( "diff_".concat( userReqDto.getNickname() ) )
                                          .build();

    assertFalse( userReqDto.equals( diffUserReqDto ));
    assertNotEquals( userReqDto.hashCode(), diffUserReqDto.hashCode() );
    assertNotEquals( userReqDto, diffUserReqDto );
  }
}