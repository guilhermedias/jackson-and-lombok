package rocks.guilherme.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
class UserRepository {
  private Collection<User> users;

  UserRepository() {
    users = new ArrayList<>();

    User user = new User(
        UUID.fromString("9e9692fc-a48d-4703-b0cc-691029a74981"),
        "Aaron",
        "Smith"
    );

    users.add(user);
  }

  Collection<User> findAll() {
    return new ArrayList<>(users);
  }

  Optional<User> findById(UUID idToFind) {
    return
        users.stream()
            .filter(user -> user.getId().compareTo(idToFind) == 0)
            .findFirst();
  }

  void save(User userToSave) {
    User user = new User(
        userToSave.getId(),
        userToSave.getFirstName(),
        userToSave.getLastName());

    users.add(user);
  }
}
