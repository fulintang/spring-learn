package com.tang.springasync;

import com.tang.springasync.dto.UserBehaviorDataDTO;
import com.tang.springasync.future.MyFutureTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class SpringAsyncApplicationTests {
    
    @Autowired
    private MyFutureTask myFutureTask;

    @Test
    void contextLoads() {
        UserBehaviorDataDTO userAggregatedResult = myFutureTask.getUserAggregatedResult(4L);
        log.info("{}", userAggregatedResult);
    }

}
