package com.example.dataplatform.services;

import com.example.dataplatform.model.CardScene;

import java.util.List;

public interface CardSceneService {
    public List<CardScene> get();
    public int process();
}
