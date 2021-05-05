package com.toyproject.simplecrudapp.interfaces.exceptions;

public class UserInternalException extends RuntimeException {

  private static final String ENTITY = "UserEntity is invalid. ";

  public static final UserInternalException ENTITY_ID_NULL =
      new UserInternalException( ENTITY, "'id' is null state." );

  private UserInternalException( String prefix, String errorMessage ) { super( prefix + errorMessage ); }
}
