package com.tang.stopwatch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 测试咯
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/9 10:22
 */
@Slf4j
public class ApiTest {
    
    @Test
    public void test() throws InterruptedException {
        StopWatchTest stopWatchTest = new StopWatchTest();
        stopWatchTest.doStopWatch();
    }
    
}
