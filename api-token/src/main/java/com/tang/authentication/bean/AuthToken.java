package com.tang.authentication.bean;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import lombok.Getter;
import lombok.ToString;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@ToString
public class AuthToken {

    // 默认超时时间 3 分钟
    private static final long DEFAULT_EXPIRE_TIME_INTERVAL = 3 * 60 * 1000;

    @Getter
    private final String token;

    private final long createTime;

    @Getter
    private long expiredTimeInterval = DEFAULT_EXPIRE_TIME_INTERVAL;

    private static final Digester MD5 = new Digester(DigestAlgorithm.MD5);

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken createToken(String appId, String secret, long createTime, String baseUrl, Map<String, String> params) {
        String original = appId + secret + baseUrl + MapUtil.sortJoin(params, "&", "=", true) + createTime;
        String token = MD5.digestHex(original, StandardCharsets.UTF_8);
        return new AuthToken(token, createTime);
    }

    public boolean isExpired() {
        long now = System.currentTimeMillis();
        long expiredTime = this.createTime + DEFAULT_EXPIRE_TIME_INTERVAL;
        return now < expiredTime;
    }
    
}

