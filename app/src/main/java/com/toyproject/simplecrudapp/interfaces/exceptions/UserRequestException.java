package com.toyproject.simplecrudapp.interfaces.exceptions;

public class UserRequestException extends RuntimeException {

  public static final UserRequestException DUPLICATED_EMAIL =
      new UserRequestException( "'email' is duplicated." );

  private UserRequestException( String errorMessage ) { super( errorMessage ); }
}
