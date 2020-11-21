package com.soft1851.files;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: GridConfig
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/21 18:43:23 
 * @Version: V1.0
 **/
@Component
public class GridConfig {
    @Value("${spring.data.mongodb.database}")
    private  String mongodb;

    @Bean
    public GridFSBucket gridFSBucket(MongoClient mongoClient){
        MongoDatabase mongoDatabase =mongoClient.getDatabase(mongodb);
        return GridFSBuckets.create(mongoDatabase);
    }
}
