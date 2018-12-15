package com.shawn.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.shawn.model.entity.AuthEntity;
import com.shawn.repository.AuthRepository;

/**
 * @author Xiaoyue Xiao
 */
@Mapper
public interface AuthMapper extends AuthRepository {

    AuthEntity selectByToken(String token);

}
