package com.tang.authentication.service.impl;

import com.tang.authentication.service.CreditService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class InmemoryCreditServiceImpl implements CreditService {

    private static final Map<String, String> CREDIT_MAP = new HashMap<>(1 << 2);

    static {
     	// 这里做测试就直接添加一个appId
        CREDIT_MAP.put("testAppId", "secretTest");
    }

    @Override
    public String getCreditByAppId(String appId) {
        return CREDIT_MAP.get(appId);
    }

    @Override
    public void addSecret(String appId, String secret) {
        if (!StringUtils.hasLength(appId) || !StringUtils.hasLength(secret)) {
            return;
        }
        CREDIT_MAP.put(appId, secret);
    }
}

