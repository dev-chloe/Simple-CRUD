package com.toyproject.simplecrudapp.interfaces.exceptions;

public class UserResException extends RuntimeException {

  private static final String ERR_PREFIX = "UserEntity is invalid. - ";

  public static final UserResException ID_CANNOT_BE_NULL = new UserResException( ERR_PREFIX + "'id' cannot be null" );

  private UserResException(String errorMessage) {
    super(errorMessage);
  }
}
