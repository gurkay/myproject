package com.project.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.project.admin.entity.User;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("test5@gmail.com");
        user.setPassword("gurkay12345");
        user.setFirstName("test5");
        user.setLastName("test5");

        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    // READ
    @Test
    public void testReadUser(){
        Integer userId = 1;

        Optional<User> findById = userRepository.findById(userId);

        assertThat(findById).isPresent();

        User user = findById.get();
        System.out.println(user);
    }

    // UPDATE
    @Test
    public void testUpdateUser(){
        Integer userId = 1;
        String lastName = "YİĞİT";

        User user = userRepository.findById(userId).get();

        user.setLastName(lastName);

        User updatedUser = userRepository.save(user);

        assertThat(updatedUser.getLastName()).isEqualTo(lastName);
    }

    // DELETE
    @Test
    public void testDeleteUser(){
        Integer userId = 1;

        userRepository.deleteById(userId);

        Optional<User> findById = userRepository.findById(userId);

        assertThat(findById).isPresent();
    }
}
