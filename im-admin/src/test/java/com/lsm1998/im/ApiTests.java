package com.lsm1998.im;

import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.model.ApiConfig;
import org.junit.jupiter.api.Test;

public class ApiTests
{
    @Test
    void buildSmartDoc()
    {
        ApiConfig config = new ApiConfig();
        config.setAuthor("lsm1998");
        config.setStrict(true);
        config.setOutPath("D:\\code\\im-system\\doc");
        config.setServerUrl("http://127.0.0.1:9870/");
        config.setCoverOld(true);
        ApiDocBuilder.buildApiDoc(config);
    }
}
