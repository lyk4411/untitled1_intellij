package com.cfets.sms.rest;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {  
    public RestApplication() {  

     //服务类所在的包路径  
     packages("com.cfets.sms.rest.resource");  
     //packages("com.cfets.rest.resource.test");  
     //注册 JSON 转换器  
     register(MoxyJsonFeature.class);

    }  
}  
