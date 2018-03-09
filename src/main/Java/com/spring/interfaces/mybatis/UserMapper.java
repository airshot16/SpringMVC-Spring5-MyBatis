package com.spring.interfaces.mybatis;

import com.spring.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Mybatis基于接口的sql仓库类
 * sql可以写在注解中 也可以写在mapper.xml中，实现复杂sql的构建
 */
@MapperScan
public interface UserMapper {
    @Select("SELECT id FROM user_account Where Id = #{id}")
    UserEntity getUserById(String id);

    List<UserEntity> getAllUser();

    @Select("SELECT count(*) FROM user_account Where userName = #{userName} AND password = #{password}")
    int login(@Param("userName") String userName, @Param("password") String password);
}
