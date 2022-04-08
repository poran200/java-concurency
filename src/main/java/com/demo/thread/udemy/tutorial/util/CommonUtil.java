package com.demo.thread.udemy.tutorial.util;


import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;

import static com.demo.thread.udemy.tutorial.util.LoggerUtil.log;

/**
 * This class is use for common utility functions
 */
public class CommonUtil {
    static Logger logger = Logger.getLogger(CommonUtil.class);
    public static StopWatch stopWatch = new StopWatch();

    public static void delay(int delayMill) {
        try {
            Thread.sleep(delayMill);
        } catch (Exception e) {
            log("Exception is:  " + e.getMessage());
        }
    }

    public static String transFrom(String s) {
        CommonUtil.delay(500);
        return s.toUpperCase();
    }

    public static void startTimer() {
        stopWatch.start();
    }

    public static void timeTaken() {
        stopWatch.stop();
        log("time taken : " + stopWatch.getTime());
    }

    public static void stopWatchReset() {
        stopWatch.reset();
    }

    public static int noOfCore() {
        return Runtime.getRuntime().availableProcessors();
    }

}
