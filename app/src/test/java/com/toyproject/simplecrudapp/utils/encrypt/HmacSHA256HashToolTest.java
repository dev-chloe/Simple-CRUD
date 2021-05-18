package com.toyproject.simplecrudapp.utils.encrypt;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName( "Util Test :: HmacSHA256 Hash Tool [POJO]" )
class HmacSHA256HashToolTest {

  private static HashTool hmacSha256HashTool;

  @BeforeAll
  static void setup() {
    hmacSha256HashTool = HmacSHA256HashTool.getInstance();
  }

  @DisplayName( "Hash Test :: Success to hash" )
  @Test
  void hashTest() {
    assertEquals( "d2c02e252f80f88528ad1a0033b77763688ff1e3961bb555e18b997263c346ac",
                  hmacSha256HashTool.hash( "Ex_P4SSW0RD" ) );
  }

}
