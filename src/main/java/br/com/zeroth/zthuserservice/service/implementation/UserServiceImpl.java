package br.com.zeroth.zthuserservice.service.implementation;

import br.com.zeroth.zthuserservice.config.PasswordConfig;
import br.com.zeroth.zthuserservice.domain.User;
import br.com.zeroth.zthuserservice.exception.UserException;
import br.com.zeroth.zthuserservice.repository.UserRepository;
import br.com.zeroth.zthuserservice.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        log.info("method=getAll");
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {

        log.info("method=getUser, id={}", id);
        return userRepository.getReferenceById(id);
    }

    @Override
    public User create(User user) {
        log.info("create user  {} ", user);
        return userRepository.save(user);
    }

    @Override
    @SneakyThrows
    public User update(User user, Long id) {

        log.info("update user  {} with id {}", user, id);
        User findUser = userRepository.findById(id).orElseThrow(() -> new UserException("User not found"));

        findUser.setName(user.getName());
        findUser.setLatitude(user.getLatitude());
        findUser.setLongitude(user.getLongitude());
        findUser.setPassword(new PasswordConfig().encoder().encode(user.getPassword()));
        return userRepository.save(findUser);
    }

    @Override
    @SneakyThrows
    public void delete(Long id) {
        log.info("delete user with id {}", id);
        User findUser = userRepository.findById(id).orElseThrow(() -> new UserException("User not found"));
        userRepository.delete(findUser);
    }
}
