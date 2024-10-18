package org.manfung.weatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.manfung.weatherapp.models.User;
import org.manfung.weatherapp.repositories.UserRepository;
import org.manfung.weatherapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Start the entire application context for testing
@ActiveProfiles("test")  // Using a test profile with H2 database for testing
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        // Clear the repository and set up initial data before each test
        userRepository.deleteAll();

        // Create and save initial users
        User user1 = new User();
        user1.setUsername("john_doe");
        user1.setPassword("password123");
        user1.setRole("USER");

        User user2 = new User();
        user2.setUsername("jane_doe");
        user2.setPassword("password456");
        user2.setRole("ADMIN");

        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Test
    public void testFindUserByUsername() {
        // Test finding a user by username
        User foundUser = userService.findUserByUsername("john_doe");
        assertNotNull(foundUser);
        assertEquals("john_doe", foundUser.getUsername());
        assertEquals("USER", foundUser.getRole());
    }

    @Test
    public void testCreateUser() {
        // Create a new user and save it
        User newUser = new User();
        newUser.setUsername("mike_doe");
        newUser.setPassword("password789");
        newUser.setRole("USER");

        User savedUser = userService.createUser(newUser);  // Assuming you have a createUser method
        assertNotNull(savedUser);
        assertEquals("mike_doe", savedUser.getUsername());
        assertEquals("USER", savedUser.getRole());
    }

    @Test
    public void testDeleteUser() {
        // Delete a user by username
        userService.deleteUserByUsername("john_doe");  // Assuming you have a deleteUserByUsername method
        User deletedUser = userService.findUserByUsername("john_doe");
        assertNull(deletedUser);  // The user should no longer exist
    }

    @Test
    public void testUpdateUser() {
        // Update an existing user's role
        User existingUser = userService.findUserByUsername("jane_doe");
        assertNotNull(existingUser);

        existingUser.setRole("SUPER_ADMIN");
        User updatedUser = userService.updateUser(existingUser);  // Assuming you have an updateUser method

        assertNotNull(updatedUser);
        assertEquals("SUPER_ADMIN", updatedUser.getRole());
    }
}

