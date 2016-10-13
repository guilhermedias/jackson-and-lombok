package rocks.guilherme.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
// Spring managed bean
@SuppressWarnings("unused")
class UserController {
  private UserRepository userRepository;

  @Autowired
  UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping(path = "/", method = RequestMethod.GET)
  Collection<UserDto> getAllUsers() {
    Collection<User> allUsers = userRepository.findAll();

    ArrayList<UserDto> userDtos = new ArrayList<>();
    allUsers.forEach(user ->
        userDtos.add(new UserDto(user)));

    return userDtos;
  }

  @RequestMapping(path = "/", method = RequestMethod.POST)
  void postUser(@RequestBody UserDto userDto) {
    User user = userDto.toUser();

    userRepository.save(user);
  }

  @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
  UserDto getUserById(@PathVariable UUID userId) {
    Optional<User> userOptional = userRepository.findById(userId);
    User user = userOptional.get();
    return new UserDto(user);
  }

}
