package com.toyproject.simplecrudapp.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toyproject.simplecrudapp.applications.UserSignService;
import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.domains.req.UserReqDto;
import com.toyproject.simplecrudapp.domains.res.UserResDto;
import com.toyproject.simplecrudapp.supports.UserMockSupport;
import com.toyproject.simplecrudapp.supports.MockitoSupport;
import com.toyproject.simplecrudapp.supports.SpringTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName( "Interface Test :: UserController" )
@ExtendWith( MockitoSupport.class )
@WebMvcTest( UserController.class )
class UserControllerTest extends UserMockSupport implements SpringTestSupport {

  @MockBean
  private UserSignService mockUserSignService;

  private User givenUser;

  @BeforeEach
  void setUp() {
    givenUser = giveUser();
  }

  @DisplayName("Sign-up :: [201] created")
  @Test
  void signUpTest() throws Exception {
    // Given-When-Then
    UserReqDto givenUserReqDto = UserReqDto.builder()
                                           .email( givenUser.getEmail() )
                                           .password( givenUser.getPassword() )
                                           .nickname( givenUser.getNickname() )
                                           .build();
    UserResDto thenUserResDto = UserResDto.factory( givenUser );

    when( mockUserSignService.signUp( givenUserReqDto ))
        .thenReturn( thenUserResDto );

    // Payload
    Map<String, String> payload = new HashMap<>();
    payload.put("email", givenUser.getEmail());
    payload.put("password", givenUser.getPassword());
    payload.put("nickname", givenUser.getNickname());

    // Mocking Test
    this.mockMvc
        .perform( post("/users")
                      .contentType( MediaType.APPLICATION_JSON )
                      .content( new ObjectMapper().writeValueAsString( payload ) ))
        .andDo( print() )
        .andExpect( status().is( HttpStatus.CREATED.value() ) )
        .andExpect( content().contentType( MediaType.APPLICATION_JSON ) )
        .andExpect( jsonPath( "$.id" ).exists() )
        .andExpect( jsonPath( "$.email" ).value( givenUser.getEmail() ) )
        .andExpect( jsonPath( "$.nickname" ).value( givenUser.getNickname() ) )
        .andExpect( jsonPath( "$.password" ).doesNotExist() );
  }
}