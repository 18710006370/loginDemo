package com.test.data;

import com.test.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author anonymity
 */
@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    Optional<User> findByName(String userName);

    Optional<User> findByNameAndPassword(String userName, String password);
}
