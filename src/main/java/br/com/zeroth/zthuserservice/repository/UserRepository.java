package br.com.zeroth.zthuserservice.repository;

import br.com.zeroth.zthuserservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
