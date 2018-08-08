package com.stream;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import javax.xml.bind.util.JAXBSource;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class TestStream {


    @Test
    public void testStream(){

        LocalDateTime localDateTime  = LocalDateTime.now();
        System.out.println(localDateTime.getDayOfWeek().getValue());

//        List<String> words = Arrays.asList("1","2","3");
//        List wordLengths= words.stream().map(word->word.split(""))
//                .flatMap(Arrays::stream)
//                        .distinct().collect(toList());
//
//        System.out.println(JSON.toJSONString(wordLengths));


        List<Integer> ints= Arrays.asList(1,2,3,4,5);

        Optional<Integer> re = ints.stream()
                                .filter(d->d>3)
                                .findAny();
       re.ifPresent(d-> System.out.println(d*d)
        );

    }

    @Test
    public void testIntStream(){

    }
}
