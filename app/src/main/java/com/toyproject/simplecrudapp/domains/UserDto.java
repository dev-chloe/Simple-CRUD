package com.toyproject.simplecrudapp.domains;

import com.toyproject.simplecrudapp.utils.fixed.RegExp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor
public class UserDto implements IDto<User> {

  @NonNull
  @Pattern(regexp = RegExp.Email ,message = "'email' is invalid")
  private final String email;

  @NonNull
  @Size(min = 8, message = "'password' must be longer than 8 words" )
  private final String password;

  @NonNull
  @Size(min = 2, message = "'nickname' must be longer than 2 words" )
  private final String nickname;

  @Override
  public User toEntity() {
    return User.builder()
               .email(email)
               .password(password) // TODO Password Encrypt
               .nickname(nickname)
               .build();
  }
}
