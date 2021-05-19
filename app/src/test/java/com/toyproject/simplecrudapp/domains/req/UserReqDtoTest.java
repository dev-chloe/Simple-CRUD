package com.toyproject.simplecrudapp.domains.req;

import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.supports.GivenSupport;
import com.toyproject.simplecrudapp.utils.encrypt.HashTool;
import com.toyproject.simplecrudapp.utils.encrypt.HmacSHA256HashTool;
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

  @DisplayName("toEntity Test :: Password Encrypt")
  @Test
  void passwordEncryptTest() {
    UserReqDto userReqDto = UserReqDto.builder()
                                .email( givenUser.getEmail() )
                                .password( givenUser.getPassword() )
                                .nickname( givenUser.getNickname() )
                                .build();
    User pwEncUser = userReqDto.toEntity();
    assertNotEquals( userReqDto.getPassword(), pwEncUser.getPassword() );

    HashTool hmacSHA256 = HmacSHA256HashTool.getInstance();
    final String encPw = hmacSHA256.hash( userReqDto.getPassword() );
    assertEquals( encPw,  pwEncUser.getPassword() );
  }
}