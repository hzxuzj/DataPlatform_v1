package com.example.dataplatform.services;


import com.example.dataplatform.model.SharesScene;

import java.util.List;

public interface SharesSceneService {
    public List<SharesScene> get();
    public int resultwrite(SharesScene sharesScene);
}
