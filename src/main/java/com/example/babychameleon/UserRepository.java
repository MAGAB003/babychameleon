package com.example.babychameleon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public interface UserRepository extends CrudRepository<User, Long> { // JpaRepository???
    User findByUsername(String username);
}

