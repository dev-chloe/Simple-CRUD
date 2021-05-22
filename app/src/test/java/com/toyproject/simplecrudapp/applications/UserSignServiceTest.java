package com.toyproject.simplecrudapp.applications;

import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.domains.UserRepository;
import com.toyproject.simplecrudapp.domains.req.UserReqDto;
import com.toyproject.simplecrudapp.domains.res.UserResDto;
import com.toyproject.simplecrudapp.interfaces.exceptions.UserRequestException;
import com.toyproject.simplecrudapp._supports.GivenSupport;
import com.toyproject.simplecrudapp._supports.MockMvcSupport;
import com.toyproject.simplecrudapp._supports.MockitoSupport;
import com.toyproject.simplecrudapp._supports.SpringTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName( "Application Test :: UserSignService" )
@ExtendWith( MockitoSupport.class )
class UserSignServiceTest extends MockMvcSupport implements SpringTestSupport {

  private UserSignService userSignService;

  @MockBean
  private UserRepository mockUserRepository;

  private User givenUser;

  @BeforeEach
  void setUp() {
    givenUser = GivenSupport.givenUserFactory();
    userSignService = new UserSignService(mockUserRepository);
  }

  @DisplayName("Sign-up :: Unique Email > Success")
  @Test
  void signUpTestWhenUniqueEmail() {
    // Given-When-Then
    UserReqDto givenUserReqDto = UserReqDto.builder()
                                     .email( givenUser.getEmail() )
                                     .password( givenUser.getPassword() )
                                     .nickname( givenUser.getNickname() )
                                     .build();
    // Unique
    when( mockUserRepository.findByEmail( givenUser.getEmail() ) )
        .thenReturn( Optional.empty() );

    when( mockUserRepository.save( givenUserReqDto.toEntity() ) )
        .thenReturn( givenUser );

    // Test
    UserResDto resultUserResDto = userSignService.signUp( givenUserReqDto );
    assertEquals(resultUserResDto.getId(), givenUser.getId());
    assertEquals(resultUserResDto.getEmail(), givenUser.getEmail());
    assertEquals(resultUserResDto.getNickname(), givenUser.getNickname());
  }

  @DisplayName("Sign-up :: Duplicated Email > Exception")
  @Test
  void signUpTestWhenDuplicatedEmail () {
    // Given-When-Then
    UserReqDto givenUserReqDto = UserReqDto.builder()
                                     .email( givenUser.getEmail() )
                                     .password( givenUser.getPassword() )
                                     .nickname( givenUser.getNickname() )
                                     .build();
    // Duplicated
    when( mockUserRepository.findByEmail( givenUser.getEmail() ) )
        .thenReturn( Optional.of(givenUser) );

    try {
      userSignService.signUp( givenUserReqDto );
    } catch ( UserRequestException e ) {
      assertEquals( e.getMessage(), "'email' is duplicated." );
    }
  }

  @DisplayName("Email-Check :: duplicated (true)")
  @Test
  void hasAlreadyDuplicatedEmailWhenItDoes() {
    // Duplicated
    when( mockUserRepository.findByEmail( givenUser.getEmail() ) )
        .thenReturn( Optional.of(givenUser) );

    assertTrue( userSignService.hasAlreadyDuplicatedEmail( givenUser ));
  }

  @DisplayName("Email-Check :: Unique (false)")
  @Test
  void hasAlreadyDuplicatedEmailWhenUnique() {
    // Unique
    when( mockUserRepository.findByEmail( givenUser.getEmail() ) )
        .thenReturn( Optional.empty() );

    assertFalse( userSignService.hasAlreadyDuplicatedEmail( givenUser ));
  }
}
