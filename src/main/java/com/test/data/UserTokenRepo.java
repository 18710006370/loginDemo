package com.test.data;

import com.test.domain.UserToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Luo_xuri on 2017/9/30.
 */
@Repository
public interface UserTokenRepo extends CrudRepository<UserToken, String> {
}
