package com.toyproject.simplecrudapp.domains;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

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

  @Override
  public boolean equals( Object o ) {
    if ( Objects.isNull( o )) {
      return false;
    }
    if ( this == o ) {
      return true;
    }
    if ( !(o instanceof User) ) {
      return false;
    }
    User user = (User) o;
    return id == user.id
        && email.equals( user.email )
        && password.equals( user.password )
        && nickname.equals( user.nickname );
  }

  @Override
  public int hashCode() {
    return Objects.hash( id, email, password, nickname );
  }
}
