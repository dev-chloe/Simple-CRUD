package com.toyproject.simplecrudapp.domains;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

  @NotBlank
  @Pattern(regexp = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$")
  private String email;

  @NotBlank
  @Size(min = 8)
  private String password;

  @NotBlank
  @Size(min = 2, max = 30)
  private String nickname;

  public User toEntity() {
    return User.builder()
               .email(email)
               .password(password) // TODO Password Encrypt
               .nickname(nickname)
               .build();
  }
}
