package com.example.dataplatform.dao;

import com.example.dataplatform.model.CardScene;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * CardSceneDAO继承基类
 */
@Repository
@Mapper
public interface CardSceneDAO extends MyBatisBaseDao<CardScene, Long> {
}