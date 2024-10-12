package br.com.zeroth.zthuserservice.service;

import br.com.zeroth.zthuserservice.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getUser(Long id);
    User create(User user);
    User update(User user, Long id);
    void delete(Long id);
}
