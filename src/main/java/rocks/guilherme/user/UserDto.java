package rocks.guilherme.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

class UserDto {
  @JsonProperty
  private String firstName;
  @JsonProperty
  private String lastName;

  @JsonCreator
  UserDto(
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  UserDto(User user) {
    firstName = user.getFirstName();
    lastName = user.getLastName();
  }

  User toUser() {
    return new User(
        UUID.randomUUID(),
        firstName,
        lastName
    );
  }
}
