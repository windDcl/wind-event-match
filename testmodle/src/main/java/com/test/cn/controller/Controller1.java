package com.test.cn.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.cluster.ElasticsearchClusterClient;
import co.elastic.clients.elasticsearch.cluster.RemoteInfoResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import com.test.cn.common.entity.Product;
import com.testb.cn.utils.ESUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller1 {
    Log logger = LogFactory.getLog(Controller1.class);


    @Autowired
    private ESUtils esUtils;
    @GetMapping("/hello")
    public String sayHello() {
        return esUtils.sayHello();
    }

    @PostMapping("/testConnection")
    public String testConnection() throws Exception {
        ElasticsearchClient client = esUtils.getClient();

        ElasticsearchClusterClient cluster = client.cluster();
        RemoteInfoResponse remoteInfoResponse = cluster.remoteInfo();
        System.out.println(remoteInfoResponse.toString());

        System.out.println("==============");

        System.out.println(cluster.health());

        System.out.println("===========");

        System.out.println(cluster.state());

        System.out.println("=========");

//        System.out.println(client.healthReport());

        System.out.println("============");

        System.out.println(client.info());

        System.out.println("==========");

//        System.out.println(client.nodes().info());

        return "success";

    }

    @PostMapping("/index")
    public String index() throws Exception {
        ElasticsearchClient client = esUtils.getClient();
        CreateIndexResponse products = client.indices().create(c -> c.index("products"));
        Product product = new Product("bk-1", "City bike", 123.0);

        IndexResponse response = client.index(i -> i
                .index("products")
                .id(product.getSku())
                .document(product)
        );

        logger.info("Indexed with version " + response.version());



        return "success";
    }





}
