package com.toyproject.simplecrudapp.utils.encrypt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Objects;

public class SHA256HashTool extends HashTool {

  private static final HashTool INSTANCE = new SHA256HashTool();

  private final String HASH_TYPE = "SHA-256";

  private SHA256HashTool() {}
  public static HashTool getInstance() { return INSTANCE; }

  @Override
  public String hash( String orgStr ) {
    try {
      // Validate
      if ( Objects.isNull(orgStr) || orgStr.isBlank() )
        throw new RuntimeException( "SHA-256 Hash Tool Error: invalid 'orgStr' (Cannot be null or blank)" );

      // Prepare Secure Hash Algorithm
      MessageDigest msgDig = MessageDigest.getInstance( this.HASH_TYPE );
      byte[] hash = msgDig.digest(orgStr.getBytes( StandardCharsets.UTF_8 ));

      // Hash
      StringBuffer hexStrBuff = new StringBuffer();
      for ( int i = 0; i < hash.length; i++ )  {
        String hex = Integer.toHexString( 0xff & hash[i] );
        if ( hex.length() == 1 ) hexStrBuff.append( '0' );
        hexStrBuff.append( hex );
      }
      return hexStrBuff.toString();
    }
    catch ( Exception e ) {
      throw new RuntimeException(e);
    }
  }
}
