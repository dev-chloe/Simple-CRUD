package com.toyproject.simplecrudapp.utils.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class HmacSHA256HashTool extends HashTool {

  private static final HashTool INSTANCE = new HmacSHA256HashTool();

  private final Logger logger = LoggerFactory.getLogger( HmacSHA256HashTool.class );

  private final String HASH_TYPE = "HmacSHA256";

  private final Mac hmacSHA256;


  private HmacSHA256HashTool() {
    String key = "local-key"; // FIXME :: INIT PARAMETER
    SecretKey secretKey = generateSecretKey(key);
    this.hmacSHA256 = initMacWithSecretKey(secretKey);
  }

  private SecretKey generateSecretKey(final String key) {
    // Validate
    try {
      if ( Objects.isNull(key) || key.isBlank() )
        throw new RuntimeException();
    } catch ( RuntimeException e ) {
      logger.error( HASH_TYPE + " :: Invalid 'key' has been detected. Fail to init HashTool..." );
      throw new RuntimeException("invalid 'key' for " + HASH_TYPE + " (Cannot be null or blank)");
    }

    // Secret Key from Original Key
    logger.info( HASH_TYPE + " :: Hash Tool has received the key." );
    return new SecretKeySpec( key.getBytes( StandardCharsets.UTF_8 ), HASH_TYPE );
  }

  private Mac initMacWithSecretKey(final SecretKey secretKey) {
    try {
      Mac hmacSHA256 = Mac.getInstance( HASH_TYPE );
      hmacSHA256.init(secretKey);
      return hmacSHA256;
    }
    catch ( NoSuchAlgorithmException e ) {
      logger.error( HASH_TYPE + " :: Invalid 'Algorithm' has been detected. Fail to init HashTool..." );
      throw new RuntimeException("invalid 'Algorithm' for " + HASH_TYPE);
    }
    catch ( InvalidKeyException e ) {
      logger.error( HASH_TYPE + " :: Invalid 'SecretKey' has been detected. Fail to init HashTool..." );
      throw new RuntimeException("invalid 'SecretKey' for " + HASH_TYPE);
    }
  }

  public static HashTool getInstance() { return INSTANCE; }

  @Override
  protected String hash( String orgStr ) {
    byte[] hashedBytes = hmacSHA256.doFinal(orgStr.getBytes( StandardCharsets.UTF_8 ));
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < hashedBytes.length; i++) {
      int d = hashedBytes[i];
      d += (d < 0) ? 256 : 0;
      if (d < 16) buffer.append( "0" );
      buffer.append( Integer.toString( d, 16 ) );
    }
    return buffer.toString();
  }

}
