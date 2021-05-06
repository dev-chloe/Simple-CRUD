package com.toyproject.simplecrudapp.interfaces;

import com.toyproject.simplecrudapp.applications.UserSignService;
import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.domains.UserRepository;
import com.toyproject.simplecrudapp.domains.req.UserReqDto;
import com.toyproject.simplecrudapp.domains.res.UserResDto;
import com.toyproject.simplecrudapp.supports.SpringMockMvcTestSupport;
import com.toyproject.simplecrudapp.supports.SpringMockitoSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith( SpringMockitoSupport.class )
class UserControllerTest extends SpringMockMvcTestSupport  {

  @Mock
  private UserSignService userSignService;

  private User givenUser;

  /*
    ????
    https://effectivesquid.tistory.com/entry/Spring-Boot-starter-test-%EC%99%80-Junit5%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%ED%85%8C%EC%8A%A4%ED%8A%B8
   */

  @BeforeEach
  void setUp() {
    givenUser = User.builder()
                    .id( (long) 1 )
                    .email( "tester@email.com" )
                    .password( "p@ss_W0RD!!" )
                    .nickname( "MyTester" )
                    .build();
  }

  @DisplayName("User > Sign-up :: [201] created")
  @Transactional
  @Test
  void signUpTest() throws Exception {
    // Given-When-Then
    UserReqDto givenUserReqDto = UserReqDto.builder()
                                     .email( givenUser.getEmail() )
                                     .password( givenUser.getPassword() )
                                     .nickname( givenUser.getNickname() )
                                     .build();
    when(userSignService.signUp( givenUserReqDto ))
        .thenReturn( UserResDto.factory( givenUser ) );

    // Payload
    MultiValueMap<String, String> payload = new LinkedMultiValueMap<>();
    payload.add("email", givenUser.getEmail());
    payload.add("password", givenUser.getPassword());
    payload.add("nickname", givenUser.getNickname());

    // Mocking Test
    this.mockMvc
        .perform( post("/users")
                      .contentType( MediaType.APPLICATION_JSON )
                      .params( payload ))
        .andDo(print())
        .andExpect( status().is( HttpStatus.CREATED.value() ) )
        .andExpect( content().contentType( MediaType.APPLICATION_JSON ) )
        .andExpect( jsonPath( "$.id" ).exists() ) // FIXME :: Prevent to increase PK
        .andExpect( jsonPath( "$.email" ).value( givenUser.getEmail() ) )
        .andExpect( jsonPath( "$.nickname" ).value( givenUser.getNickname() ) )
        .andExpect( jsonPath( "$.password" ).doesNotExist() );
  }
}