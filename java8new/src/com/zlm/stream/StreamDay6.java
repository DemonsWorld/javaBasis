package com.zlm.stream;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Kakrolot
 * @date 2021/6/19 18:15
 */
public class StreamDay6 {
    public static void main(String[] args) {
    }

    public static void test(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Integer.sum(integer,integer2);
            }
        });
        Integer reduce = list.stream().reduce(0, Integer::sum);
    }

    public static void test1() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("11","1",200));
        list.add(new Employee("22","2",100));
        list.add(new Employee("33","3",300));
        list.add(new Employee("44","4",500));
        list.add(new Employee("55","5",101));
        list.add(new Employee("55","5",900));

        Optional<Long> reduce = list.stream().map(Employee::getSalary).reduce(Long::sum);

        reduce.get();

        List<Employee> collect = list.stream().filter(e -> e.getSalary() > 500).collect(Collectors.toList());

        Set<Employee> collect1 = list.stream().filter(e -> e.getSalary() > 500).collect(Collectors.toSet());



    }







    static class Employee{
        private String name;
        private String id;
        private long salary;

        public long getSalary() {
            return salary;
        }

        public void setSalary(long salary) {
            this.salary = salary;
        }

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

        public Employee(String name, String id, long salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
