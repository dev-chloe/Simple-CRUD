package com.toyproject.simplecrudapp.supports;

import com.toyproject.simplecrudapp.domains.User;

public abstract class UserMockSupport extends MockMvcSupport {

  protected User giveUser() {
    return User.builder()
               .id( 1L )
               .email( "tester@email.com" )
               .password( "p@ss_W0RD!!" )
               .nickname( "MyTester" )
               .build();
  }
}
