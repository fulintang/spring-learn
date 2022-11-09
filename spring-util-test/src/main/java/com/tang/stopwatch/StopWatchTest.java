package com.tang.stopwatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * 测试任务耗时工具StopWatch
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/11/9 10:14
 */
@Slf4j
public class StopWatchTest {
    
    public void doStopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch("任务耗时测试");
        stopWatch.start("我是第一个任务");
        // 在这里执行第一个任务啊
        Thread.sleep(500);
        stopWatch.stop();
        
        stopWatch.start("我是第二个任务");
        // 在这里执行第二个任务啊
        Thread.sleep(2000);
        stopWatch.stop();

        stopWatch.start("我是第三个任务");
        // 在这里执行第三个任务啊
        Thread.sleep(1000);
        stopWatch.stop();
        
        log.info(stopWatch.prettyPrint());

    }
    
}
