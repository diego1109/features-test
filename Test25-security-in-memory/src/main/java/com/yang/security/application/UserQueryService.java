package com.yang.security.application;

import com.yang.security.application.data.UserData;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface UserQueryService {

  Optional<UserData> findById(String id);

  Optional<UserData> findByUsername(String userName);
}
