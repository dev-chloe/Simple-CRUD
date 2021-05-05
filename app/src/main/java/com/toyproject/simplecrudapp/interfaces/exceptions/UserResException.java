package com.toyproject.simplecrudapp.interfaces.exceptions;

public class UserResException extends RuntimeException {

  private static final String ERR_PREFIX = "UserEntity is invalid. ";

  public static final UserResException ID_NULL = new UserResException( ERR_PREFIX + "'id' is null state." );

  private UserResException(String errorMessage) {
    super(errorMessage);
  }
}
