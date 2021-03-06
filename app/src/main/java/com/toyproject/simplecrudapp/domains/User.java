package com.toyproject.simplecrudapp.domains;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Getter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @NotBlank
  private final String email;

  @NotBlank
  private final String password;

  @NotBlank
  private final String nickname;

  @Override
  public String toString() {
    return String.format( "User > id: '%d', email: '%s', nickname: '%s'", id, email, nickname);
  }
}
