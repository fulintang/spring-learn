package com.tang.fastjson.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 时间类型
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/8/15 14:07
 */
@Data
public class FastJsonDataWithAnno {

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    // 研究发现@JSONField注解在最新的版本并不好用，在1.2.78版本还行,但是在最新版本中该类变成了时间戳
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

}
