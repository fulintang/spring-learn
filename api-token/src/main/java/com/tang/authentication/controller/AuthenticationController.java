package com.tang.authentication.controller;

import com.tang.authentication.bean.AuthToken;
import com.tang.authentication.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
public class AuthenticationController {

    private final CreditService creditService;

    public AuthenticationController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/auth")
    public String auth(@RequestParam Map<String, String> params, HttpServletRequest request) {
        final String appId = params.get("appId");
        if (!StringUtils.hasLength(appId)) {
            return "authentication failed";
        }
        final String secret = creditService.getCreditByAppId(appId);
        final long createTime = Long.parseLong(params.get("createTime"));
        final String baseurl = request.getRequestURI();
        final String token = params.get("token");
        params.remove("token");
        //params.put("secret", secret);
        AuthToken authToken = AuthToken.createToken(appId, secret, createTime, baseurl, params);
        log.info(authToken.toString());
        if (!authToken.isExpired()) {
            return "authentication failed";
        }
        if (!ObjectUtils.nullSafeEquals(token, authToken.getToken())) {
            return "authentication failed";
        }
        // 执行具体业务逻辑
        params.forEach((k, v) -> log.info("{} = {}", k, v));
        return "success";
    }
    
    @GetMapping("/getToken")
    public AuthToken getToken(@RequestParam Map<String, String> parameterMap, HttpServletRequest request) {
        String baseUrl = "/auth";
        String appId = parameterMap.get("appId");
        long createTime = Long.parseLong(parameterMap.get("createTime"));
        log.info("{}", createTime);
        String secret = parameterMap.get("secret");
        AuthToken authToken = AuthToken.createToken(appId, secret, createTime, baseUrl, parameterMap);
        log.info("{}", authToken.isExpired());
        return authToken;
    }
    
}

