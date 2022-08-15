package com.tang.fastjson.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class FastJsonData {
    
    private Date date;
    
    private LocalDateTime localDateTime;

}
