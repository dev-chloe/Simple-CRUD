package com.toyproject.simplecrudapp.interfaces;

import com.toyproject.simplecrudapp._supports.MockMvcSupport;
import com.toyproject.simplecrudapp._supports.MockitoSupport;
import com.toyproject.simplecrudapp._supports.SpringTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName( "Interface Test :: RootController" )
@ExtendWith( MockitoSupport.class )
@WebMvcTest( RootController.class )
class RootControllerTest extends MockMvcSupport implements SpringTestSupport {

  @DisplayName("Root > Health check :: [200] ok")
  @Test
  void healthCheckTest() throws Exception {
    this.mockMvc.perform(get("/health-check"))
        .andDo(print())
        .andExpect(status().is( HttpStatus.OK.value()))
        .andExpect(content().contentType( "text/plain;charset=UTF-8" ))
        .andExpect(content().string( "API Server is ready." ));
  }

}