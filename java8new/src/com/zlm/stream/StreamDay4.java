package com.zlm.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Kakrolot
 * @date 2021/6/19 18:15
 */
public class StreamDay4 {
    public static void main(String[] args) {
        test1();
    }

    //自然排序 sorted
    public static void test() {
        List<Integer> list = Arrays.asList(1,3,5,4,2,0);
        list.stream().sorted().forEach(System.out::println);
    }

    public static void test1() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("11","1",2));
        list.add(new Employee("22","2",1));
        list.add(new Employee("33","3",0));
        list.add(new Employee("44","4",5));
        list.add(new Employee("55","5",10));
        list.add(new Employee("55","5",9));

        list.stream().sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);

        list.stream().sorted().forEach(System.out::println);
    }



    static class Employee implements Comparable<Employee>{
        private String name;
        private String id;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
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

        public Employee(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Employee o) {
            return Integer.compare(this.age,o.age);
        }
    }
}
