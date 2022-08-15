package com.tang;

import com.alibaba.fastjson.JSON;
import com.tang.fastjson.pojo.FastJsonData;
import com.tang.fastjson.pojo.FastJsonDataWithAnno;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * fastJson序列化和反序列化测试
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/8/15 14:10
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FastJsonTest {

    @Test
    public void data2String() {
        FastJsonData fastJsonData = new FastJsonData();
        fastJsonData.setDate(new Date());
        fastJsonData.setLocalDateTime(LocalDateTime.now());
        String data = JSON.toJSONString(fastJsonData);
        String dataWithFormat = JSON.toJSONStringWithDateFormat(fastJsonData, "yyyy-MM-dd HH:mm:ss");
        log.info("{}", data);
        log.info("{}", dataWithFormat);

        FastJsonDataWithAnno fastJsonDataWithAnno = new FastJsonDataWithAnno();
        fastJsonDataWithAnno.setDate(fastJsonData.getDate());
        fastJsonDataWithAnno.setLocalDateTime(fastJsonData.getLocalDateTime());
        String dataWithAnnoFormat = JSON.toJSONString(fastJsonDataWithAnno);
        log.info("{}", dataWithAnnoFormat);
    }


    @Test
    public void String2Data() {

        //language=JSON
        String json = "{\n" +
                "  \"date\": \"2022-01-01 08:08:08\",\n" +
                "  \"localDateTime\": \"2022-01-01 08:08:08\"\n" +
                "}";

        FastJsonData fastJsonData = JSON.parseObject(json, FastJsonData.class);
        log.info("{}", fastJsonData);

        String json2 = "{\"date\":\"2022-08-15 15:28:53\",\"localDateTime\":1660548533176}";
        FastJsonData fastJsonDataTimeStamp = JSON.parseObject(json2, FastJsonData.class);
        log.info("{}", fastJsonDataTimeStamp);
    }

}
