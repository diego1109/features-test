package com.yang.security.infrastructure.mybatis.query;

import com.yang.security.application.data.UserData;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
@Component
public interface UserReadService {
  UserData findById(@Param("id") String id);
}
