package com.example.dataplatform.dao;

import com.example.dataplatform.model.SharesScene;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * SharesSceneDAO继承基类
 */
@Repository
@Mapper
public interface SharesSceneDAO extends MyBatisBaseDao<SharesScene, String> {

}