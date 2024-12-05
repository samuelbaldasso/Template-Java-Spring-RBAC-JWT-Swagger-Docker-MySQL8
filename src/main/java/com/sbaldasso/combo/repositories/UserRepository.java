package com.sbaldasso.combo.repositories;

import com.sbaldasso.combo.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
