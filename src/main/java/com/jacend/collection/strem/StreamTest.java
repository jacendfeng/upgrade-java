package com.jacend.collection.strem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream有以下特性及优点：
 *
 * 无存储。Stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等。
 *
 * 为函数式编程而生。对Stream的任何修改都不会修改背后的数据源，比如对Stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新Stream。
 *
 * 惰式执行。Stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
 *
 * 可消费性。Stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
 */
public class StreamTest {

    public static void main(String[] args) {
        // 通过已有的集合创建流
        List<String> list = Arrays.asList("feng","xiao","jacend","iojd");
        Stream<String> stream = list.stream();

        // 通过 Stream 创建流
        Stream<String> stream1 = Stream.of("feng","xian","cat","");

        // 以下的都是中间操作：filter map limit skip distinct sorted
        // filter
        stream1.filter(str -> !str.isEmpty()).forEach(s -> System.out.print(s));
        System.out.println();

        // map
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().map( i -> i*i).forEach(System.out::print);
        System.out.println();

        // limit / skip
        numbers.stream().limit(4).forEach(System.out::print);
        System.out.println();

        // sorted
        numbers.stream().sorted().forEach(System.out::print);
        System.out.println();

        // distinct
        numbers.stream().distinct().forEach(System.out::print);
        System.out.println();

        // 综合操作
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        Stream s = strings
                .stream()
                .filter(str -> str.length()<= 6)
                .map(String::length)
                .sorted()
                .limit(3)
                .distinct();
        System.out.println(s);

        // 最终操作 foreach count collect
        // foreach
        new Random().ints().limit(39).forEach(System.out::print);
        System.out.println();

        // count
        System.out.println(strings.stream().count());

        // collect
        strings = strings.stream().filter(string -> string.startsWith("Hollis")).collect(Collectors.toList());
        System.out.println(strings);
    }
}
