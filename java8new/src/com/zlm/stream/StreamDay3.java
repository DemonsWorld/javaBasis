package com.zlm.stream;



import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Kakrolot
 * @date 2021/6/19 18:15
 */
public class StreamDay3 {
    public static void main(String[] args) {
        //test();
        test1();
    }

    public static void test() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(System.out::println);

        list.stream().map(emp -> emp.toUpperCase()).forEach(System.out::println);
    }

    public static void test1() {
        String[] words = new String[]{"Hello", "World"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        a.forEach(System.out::print);
    }

    public static void test2() {


        String[] words = new String[]{"Hello", "World"};

//        Stream<String> stream1 = Arrays.stream(words);
//
//        Stream<String[]> stream = Arrays.stream(words).map(word -> word.split(""));
        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        a.forEach(System.out::print);
}

    class Employee{
        private String name;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Employee(String name, String id) {
            this.name = name;
            this.id = id;
        }


    }
}
