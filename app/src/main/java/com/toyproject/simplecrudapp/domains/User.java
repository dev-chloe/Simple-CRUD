package com.toyproject.simplecrudapp.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
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

}
