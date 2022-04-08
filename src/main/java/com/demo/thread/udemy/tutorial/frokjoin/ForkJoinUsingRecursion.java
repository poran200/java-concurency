package com.demo.thread.udemy.tutorial.frokjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static com.demo.thread.udemy.tutorial.util.CommonUtil.delay;
import static com.demo.thread.udemy.tutorial.util.CommonUtil.stopWatch;
import static com.demo.thread.udemy.tutorial.util.LoggerUtil.log;

public class ForkJoinUsingRecursion extends RecursiveTask<List<String>> {
    private List<String> inputList;

    public ForkJoinUsingRecursion(List<String> inputList) {
        this.inputList = inputList;
    }

    public static void main(String[] args) {
        stopWatch.start();
        List<String> nameList = Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinUsingRecursion forkJoinUsingRecursion = new ForkJoinUsingRecursion(nameList);
        List<String> nameWithLengthList = forkJoinPool.invoke(forkJoinUsingRecursion);
        stopWatch.stop();
        log("Final Result: " + nameWithLengthList);
        log("Total time take: " + stopWatch.getTime());
    }

    private static String addNameLengthTransFrom(String s) {
        delay(500);
        log("transFrom preform: " + s);
        return s.length() + "-" + s;
    }

    @Override
    protected List<String> compute() {

        if (inputList.size() <= 1) {
            ArrayList<String> resultList = new ArrayList<>();
            for (String s : inputList) {
                resultList.add(addNameLengthTransFrom(s));
            }
            return resultList;
        }
        int midPoint = inputList.size() / 2;
        ForkJoinTask<List<String>> leftInputList = new ForkJoinUsingRecursion(inputList.subList(0, midPoint)).fork();
        inputList = inputList.subList(midPoint, inputList.size());
        List<String> rightResult = compute();
        List<String> leftResult = leftInputList.join();
        leftResult.addAll(rightResult);
        return leftResult;
    }
}
