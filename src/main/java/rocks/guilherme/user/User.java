package rocks.guilherme.user;

import lombok.Value;

import java.util.UUID;

@Value
class User {
  private UUID id;
  private String firstName;
  private String lastName;
}
