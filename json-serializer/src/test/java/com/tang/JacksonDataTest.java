package com.tang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.tang.jackson.pojo.JacksonData;
import com.tang.jackson.pojo.JacksonDataWithAnno;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author tangfulin
 * @version V3.0
 * @since 2022/8/15 15:31
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JacksonDataTest {

    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void testData2String() throws JsonProcessingException {
        JacksonData jacksonData = new JacksonData();
        jacksonData.setDate(new Date());
        jacksonData.setLocalDateTime(LocalDateTime.now());
        JacksonDataWithAnno jacksonDataWithAnno = new JacksonDataWithAnno();
        BeanUtils.copyProperties(jacksonData, jacksonDataWithAnno);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String jsonData = mapper.writeValueAsString(jacksonData);
        String jsonDataWithAnno = mapper.writeValueAsString(jacksonDataWithAnno);
        log.info("{}", jsonData);
        log.info("{}", jsonDataWithAnno);
    }

    @Test
    public void testString2Data() throws JsonProcessingException {
        String json = "{\"date\":\"2022-08-15 15:51:25\",\"localDateTime\":\"2022-08-15 15:51:25\"}";
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        SimpleModule simpleModule = new SimpleModule()
                .addDeserializer(Date.class, new DateDeserializers.DateDeserializer(DateDeserializers.DateDeserializer.instance
                        , new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT), DEFAULT_DATE_TIME_FORMAT))
                .addSerializer(Date.class, new DateSerializer(false, new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT)));
        simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);

        mapper.registerModule(simpleModule);

        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        mapper.registerModule(javaTimeModule);
        JacksonData jacksonData = mapper.readValue(json, JacksonData.class);
        log.info("{}", jacksonData);
    }

    @Test
    public void testString2DataAnno() throws JsonProcessingException {
        String json = "{\"date\":\"2022-08-15 15:51:25\",\"localDateTime\":\"2022-08-15 15:51:25\"}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        JacksonDataWithAnno jacksonDataWithAnno = mapper.readValue(json, JacksonDataWithAnno.class);
        log.info("{}", jacksonDataWithAnno);
    }

}
