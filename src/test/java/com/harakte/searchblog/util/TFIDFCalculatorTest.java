package com.harakte.searchblog.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Slf4j
public class TFIDFCalculatorTest {


    @Test
    public void getTF_test(){
        String term = "hello";
        List<String> list1 = Arrays.asList("hello", "1111", "sfsdf", "1234");
        double tf = TFIDFCalculator.tf(list1, term);
        log.info(String.valueOf(tf));
    }
}
