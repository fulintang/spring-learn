package com.tang.listener;

import com.tang.event.OrderProductEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听器，监听订单校验事件
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/18 15:24
 */
@Slf4j
@Component
public class OrderProductListener implements ApplicationListener<OrderProductEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderProductEvent event) {
        String orderId = event.getOrderId();
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        log.info("{}: 校验订单商品价格耗时：（{}）毫秒", orderId, (end - start));
    }

}
