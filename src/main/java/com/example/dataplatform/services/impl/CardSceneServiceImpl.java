package com.example.dataplatform.services.impl;

import com.example.dataplatform.dao.CardSceneDAO;
import com.example.dataplatform.model.CardScene;
import com.example.dataplatform.services.CardSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class CardSceneServiceImpl implements CardSceneService {

    @Autowired
    CardSceneDAO cardSceneDAO;
    @PostConstruct
    public List<CardScene> get(){
        List<CardScene> list=cardSceneDAO.get();
        return list;
    }
    public int process(){
        List<CardScene> list=cardSceneDAO.get();
        return 0;
    }
}
