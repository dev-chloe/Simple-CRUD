package com.toyproject.simplecrudapp._supports;

import com.toyproject.simplecrudapp.domains.User;

public class GivenSupport {

  public static User givenUserFactory() {
    return givenUserFactory(1L);
  }

  public static User givenUserFactory(long id) {
    return User.builder()
               .id( id )
               .email( "tester@email.com" )
               .password( "p@ss_W0RD!!" )
               .nickname( "MyTester" )
               .build();
  }
}
