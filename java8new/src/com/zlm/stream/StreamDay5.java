package com.zlm.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Kakrolot
 * @date 2021/6/19 18:15
 */
public class StreamDay5 {
    public static void main(String[] args) {
    }

    public static void test() {
        List<StreamDay4.Employee> list = new ArrayList<>();
        list.add(new StreamDay4.Employee("11","1",2));
        list.add(new StreamDay4.Employee("22","2",1));
        list.add(new StreamDay4.Employee("33","3",0));
        list.add(new StreamDay4.Employee("44","4",5));
        list.add(new StreamDay4.Employee("55","5",10));
        list.add(new StreamDay4.Employee("55","5",9));

        list.forEach(new Consumer<StreamDay4.Employee>() {
            @Override
            public void accept(StreamDay4.Employee employee) {
                System.out.println(employee);
            }
        });

        //allMatch 检查是否匹配所有元素
        boolean b = list.stream().allMatch(e -> e.getAge() > 5);

        //anyMatch 检查是否至少匹配一个元素
        boolean b1 = list.stream().anyMatch(e -> e.getAge() > 100);

        //noneMatch 检查是否没有匹配的元素
        boolean b2 = list.stream().noneMatch(e -> e.getName().equals("1"));

        //findFirst 返回第一个元素
        Optional<StreamDay4.Employee> first = list.stream().findFirst();

        //findAny 返回流中的任一元素
        Optional<StreamDay4.Employee> any = list.stream().findAny();

        Optional<StreamDay4.Employee> any1 = list.parallelStream().findAny();

        //count 返回流中的个数
        long count = list.stream().filter(e -> e.getAge() > 10).count();

        //max 返回流中的最大值
        Optional<Integer> max = list.stream().map(e -> e.getAge()).max(Integer::compare);

        //min 返回流中的最小值
        Optional<StreamDay4.Employee> min = list.stream().min((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));

        //foreach 内部迭代
        list.stream().forEach(System.out::println);

        list.forEach(System.out::println);


    }




    static class Employee{
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
    }
}
