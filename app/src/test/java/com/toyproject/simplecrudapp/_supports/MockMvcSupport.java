package com.toyproject.simplecrudapp._supports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public abstract class MockMvcSupport {

  @Autowired
  protected MockMvc mockMvc;

}
