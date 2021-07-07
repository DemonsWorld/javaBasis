package com.zlm.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Kakrolot
 * @date 2021/6/19 18:15
 */
public class StreamDay2 {
    public void test(){
        //创建Stream方式1：集合创建
        List<Employee> l = new ArrayList<>();
        l.add(new Employee("1","1"));
        l.add(new Employee("2","2"));
        l.add(new Employee("3","3"));
        l.add(new Employee("4","4"));
        l.add(new Employee("5","5"));
        l.add(new Employee("5","5"));

        //filter(Predicate p) - 从流中排除某些元素
        Stream<Employee> stream = l.stream();
        //原始写法
        stream.filter(new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getId().contains("1");
            }
        }).forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee);
            }
        });
        //简便写法
        l.stream().filter(emp -> emp.getName().contains("1")).forEach(System.out::println);

        //limit(n) 截断流使元素不超过给定数量
        l.stream().limit(3).forEach(System.out::println);

        //skip(n) 跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回空流
        l.stream().skip(3).forEach(System.out::println);

        //distinct 筛选 通过流所生成元素的hashcode和equals去除重复元素
        l.stream().distinct().forEach(System.out::println);










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
