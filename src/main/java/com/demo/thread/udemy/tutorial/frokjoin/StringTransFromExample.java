package com.demo.thread.udemy.tutorial.frokjoin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.demo.thread.udemy.tutorial.util.CommonUtil.delay;
import static com.demo.thread.udemy.tutorial.util.CommonUtil.stopWatch;
import static com.demo.thread.udemy.tutorial.util.LoggerUtil.log;

public class StringTransFromExample {

    public static void main(String[] args) {
        stopWatch.start();
        List<String> nameList = Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");
        List<String> nameWithLengthList = nameList.stream()
                .map(StringTransFromExample::addNameLengthTransFrom)
                .collect(Collectors.toList());
        stopWatch.stop();
        log("Final Result: " + nameWithLengthList);
        log("Total time take: " + stopWatch.getTime());
    }

    private static String addNameLengthTransFrom(String s) {
        delay(500);
        log("transFrom preform: " + s);
        return s.length() + "-" + s;
    }
}
