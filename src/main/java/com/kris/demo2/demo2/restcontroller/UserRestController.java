package com.kris.demo2.demo2.restcontroller;


import com.kris.demo2.demo2.model.AuthUser;
import com.kris.demo2.demo2.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    final
    UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    private List<AuthUser> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/create")
    private long createAuthUser(@RequestBody AuthUser user) {
//    private long createAuthUser(HttpEntity<String> httpEntity) throws JsonProcessingException {
//        System.out.println(httpEntity.getBody());
//        AuthUser user = new ObjectMapper().readerFor(AuthUser.class).readValue(httpEntity.getBody());
        if(userRepository.findByUserName(user.getUserName()).isEmpty()){
            userRepository.save(user);
            return user.getId();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already Exists!!!");
    }

    @DeleteMapping("/delete/{userName}")
    private void deleteAuthUser(@PathVariable("userName") String userName){
        AuthUser user = userRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        userRepository.delete(user);
    }

}