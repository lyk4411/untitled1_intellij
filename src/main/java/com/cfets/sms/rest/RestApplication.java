package com.cfets.sms.rest;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {  
    public RestApplication() {  

     //���������ڵİ�·��  
     packages("com.cfets.sms.rest.resource");  
     //packages("com.cfets.rest.resource.test");  
     //ע�� JSON ת����  
     register(MoxyJsonFeature.class);

    }  
}  
