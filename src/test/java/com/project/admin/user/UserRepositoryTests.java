package com.project.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void testCreateUser() {
        User userGurkay = new User();
        userGurkay.setEmail("gunesebak@gmail.com");
        userGurkay.setPassword("gurkay12345");
        userGurkay.setFirstName("Gürkay");
        userGurkay.setLastName("BAŞYİĞİT");

        User savedUser = userRepository.save(userGurkay);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
