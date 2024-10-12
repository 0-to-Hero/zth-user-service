package br.com.zeroth.zthuserservice.service.implementation;

import br.com.zeroth.zthuserservice.domain.User;
import br.com.zeroth.zthuserservice.exception.UserException;
import br.com.zeroth.zthuserservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setLatitude("12.34");
        user.setLongitude("56.78");
        user.setPassword("password");
    }

    @Test
    public void testGetAll() {
        List<User> users = Arrays.asList(user);
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAll();

        assertThat(result).isEqualTo(users);
        verify(userRepository).findAll();
    }

    @Test
    public void testGetUser() {
        when(userRepository.getReferenceById(1L)).thenReturn(user);

        User result = userService.getUser(1L);

        assertThat(result).isEqualTo(user);
        verify(userRepository).getReferenceById(1L);
    }

    @Test
    public void testCreate() {
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.create(user);

        assertThat(result).isEqualTo(user);
        verify(userRepository).save(user);
    }

    @Test
    public void testUpdate() throws UserException {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        User updatedUser = new User();
        updatedUser.setName("Jane Doe");
        updatedUser.setLatitude("98.76");
        updatedUser.setLongitude("54.32");
        updatedUser.setPassword("newpassword");

        User result = userService.update(updatedUser, 1L);

        assertThat(result.getName()).isEqualTo(updatedUser.getName());
        verify(userRepository).findById(1L);
        verify(userRepository).save(user);
    }

    @Test
    public void testDelete() throws UserException {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        doNothing().when(userRepository).delete(user);

        userService.delete(1L);

        verify(userRepository).findById(1L);
        verify(userRepository).delete(user);
    }


}