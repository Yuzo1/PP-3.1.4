package com.example.demo.service;
import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();
    User getUserById(long id);
    void saveUser(User user);
    void updateUser(User updateUser);
    void deleteUserById(long id);
    User findByEmail(String email);
    public UserDetails loadUserByUsername(String email);


}
