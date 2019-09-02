package com.yang.security.domain;


import java.util.Optional;
import org.hibernate.validator.constraints.pl.REGON.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
  void save(User user);

  Optional<User> findById(String id);

  Optional<User> findByUsername(String username);
}
