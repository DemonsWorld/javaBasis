package com.zlm.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Kakrolot
 * @date 2021/6/18 22:30
 *
 */

public class StreamDay1 {
    public void test(){
        //创建Stream方式1：集合创建
        List<Employee> l = new ArrayList<>();
        Stream<Employee> stream = l.stream();

        ////创建Stream方式2：数组创建
        int[] arr ={1,2,4};
        IntStream stream1 = Arrays.stream(arr);

        Employee e1 = new Employee("1","1");
        Employee e2 = new Employee("2","2");
        Employee[] arrEmp = new Employee[]{e1,e2};
        Stream<Employee> stream2 = Arrays.stream(arrEmp);

        //创建Stream方式3：通过Stream的of();
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5, 6, 7, 8, 9);

        //创建无限流



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
