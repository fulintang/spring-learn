package com.tang.authentication.service;

public interface CreditService {

    /**
     * 根据 appId 获取对应的 secret
     *
     * @param appId
     * @return
     */
    String getCreditByAppId(String appId);

    /**
     * 添加appId、secret
     * @param appId
     * @param secret
     */
    void addSecret(String appId,String secret);
    
}

