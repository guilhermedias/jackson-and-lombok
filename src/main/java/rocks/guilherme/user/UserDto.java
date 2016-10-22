package rocks.guilherme.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Value
class UserDto {
  private String firstName;
  private String lastName;

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
