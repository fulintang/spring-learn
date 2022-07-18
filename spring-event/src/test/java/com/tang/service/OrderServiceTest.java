package com.tang.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/18 15:36
 */
@SpringBootTest
public class OrderServiceTest {
    
    @Autowired
    private OrderService orderService;
    
    @Test
    public void buyOrderTest() {
        String info = orderService.buyOrder("947677661");
        System.out.println(info);
    }
    
}
