package com.sokchoys.domain.user.repository;

import com.sokchoys.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Short> {

    User findByUsername(String username);

}
