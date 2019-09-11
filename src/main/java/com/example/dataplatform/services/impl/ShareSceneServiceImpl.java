package com.example.dataplatform.services.impl;

import com.example.dataplatform.dao.SharesSceneDAO;
import com.example.dataplatform.model.SharesScene;
import com.example.dataplatform.services.SharesSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareSceneServiceImpl implements SharesSceneService {
    @Autowired
    SharesSceneDAO sharesSceneDAO;
    public List<SharesScene> get(){
        List<SharesScene> list=sharesSceneDAO.get();
        return list;
    }
}

