package my.project.dockerredisproject.controller;

import my.project.dockerredisproject.model.User;
import my.project.dockerredisproject.repository.UserRepository;
import my.project.dockerredisproject.service.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final RedisService redisService;

    public UserController(UserRepository userRepository, RedisService redisService) {
        this.userRepository = userRepository;
        this.redisService = redisService;
    }

    @PostMapping("/user")
    public User createUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/redis")
    public void setRedis(@RequestParam String key, @RequestParam String value) {
        redisService.save(key, value);
    }

    @GetMapping("/redis/{key}")
    public String getRedis(@PathVariable String key) {
        return redisService.get(key);
    }
}
