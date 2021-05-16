package com.toyproject.simplecrudapp.utils.encrypt;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName( "Util Test :: SHA-256 Hash Tool [POJO]" )
class SHA256HashToolTest {

  private static HashTool sha256HashTool;

  @BeforeAll
  static void setup() {
    sha256HashTool = SHA256HashTool.getInstance();
  }

  @DisplayName( "Hash Test :: Success to hash" )
  @Test
  void hashTest() {
    assertEquals( "bb43ff37e2871d84d0d93d28d3ef9dc8a78dffb2e03b5f3df5508ec245d9683d",
                  sha256HashTool.hash( "Ex_P4SSW0RD" ) );
  }

  @DisplayName( "Hash Test :: Invalid String > Exception occurred" )
  @Test
  void hashTestWhenInvalidString() {
    String[] invalidStrArr = new String[3];
    invalidStrArr[0] = null;
    invalidStrArr[1] = "";
    invalidStrArr[2] = " ";

    for ( String invalidStr : invalidStrArr ) {
      try {
        sha256HashTool.hash(invalidStr);
      } catch ( RuntimeException e ) {
        assertEquals("SHA-256 Hash Tool Error: invalid 'orgStr' (Cannot be null or blank)",
                     e.getCause().getMessage());
      }
    }
  }
}