package com.tang.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * 订单校验事件
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/18 15:18
 */

@Getter
@Setter
@ToString
public class OrderProductEvent extends ApplicationEvent {

    private String orderId;

    public OrderProductEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }

}
