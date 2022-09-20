package com.harakte.searchblog.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Slf4j
public class SplitTest {

    @Test
    public void test(){
        String doc = "[대표작품]4代王朝 ?. {King} = - <b>Khafre</b> seated";

        String match = "[\"'\\{\\}\\[\\]/?.,;:|\\)\\(*~`!^\\-_+<>@#%^\\=]";
        String str = doc.replaceAll(match," ");
        String[] strs = str.split("\\s+");

        assertEquals("대표작품", strs[1]);
        assertEquals("4代王朝", strs[2]);
    }
}
