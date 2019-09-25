package com.example.dataplatform.services.impl;

import com.example.dataplatform.dao.CardSceneDAO;
import com.example.dataplatform.model.CardScene;
import com.example.dataplatform.services.CardSceneService;
import org.attoparser.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import org.thymeleaf.util.TextUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class CardSceneServiceImpl implements CardSceneService {

    @Autowired
    CardSceneDAO cardSceneDAO;
    @PostConstruct
    public List<CardScene> get(){
        List<CardScene> list=cardSceneDAO.get();
        //System.out.println("输出list:"+list);
        if (!list.isEmpty()){
            cardSceneDAO.setallwaitstatus(list);
        }
//        for (CardScene sc :list){
//            cardSceneDAO.setwaitstatus(sc);
//        }
//        List<Long> listid=new ArrayList<>();
//        for (CardScene sc :list){
//            listid.add(sc.getCustomerId());
//        }
//        String s=StringUtils.join(listid,",");
//        System.out.println(s);

        return list;
    }
    public int resultwrite(CardScene cardScene){
        int result =cardSceneDAO.resultwrite(cardScene);
        return result;
    }
}
