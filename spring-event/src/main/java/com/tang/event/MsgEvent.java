package com.tang.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 发送消息事件
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/18 15:41
 */
@Data
@AllArgsConstructor
public class MsgEvent {

    private String orderId;

}
