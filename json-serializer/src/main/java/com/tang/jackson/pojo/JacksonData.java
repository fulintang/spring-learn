package com.tang.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author tangfulin
 * @version V3.0
 * @since 2022/8/15 15:19
 */
@Data
public class JacksonData {
    
    private Date date;
    
    private LocalDateTime localDateTime;

}
