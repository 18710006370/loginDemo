package com.test.data;

import com.test.domain.UserToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anonymity
 */
@Repository
public interface UserTokenRepo extends CrudRepository<UserToken, String> {
}
