package com.zlm.lambda;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @author Kakrolot
 * @date 2021/6/18 20:37
 */
public class LambdaDay2 {

    // 对象：：实例方法
    public void test1(){
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> c1 = s -> System.out.println("123") ;

        PrintStream ps = System.out;
        Consumer<String> c2 = ps :: println;

        c.accept("123");
        c1.accept("123");
        c2.accept("123");

        //上述三种写法效果相同

    }

    //
    public void test2(){
        Employee e = new Employee("lisi","1");
        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return e.getName();
            }
        };
        Supplier<String> s1 = ()-> e.getName();

        Supplier<String> s2 = e::getName;
        s.get();
        s1.get();
        s2.get();

        //上述方法效果相同
    }

    public void test3(){
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        Comparator<Integer> c1 = (o1,o2) -> Integer.compare(o1,o2);

        Comparator<Integer> c2 = Integer::compare;

        c.compare(1,2);
        c1.compare(1,2);
        c2.compare(1,2);
    }

    public void test4(){
        Function<Double,Long> f = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        Function<Double,Long> f1 = d -> Math.round(d);

        Function<Double,Long> f2 = Math::round;

        f.apply((double) 1);
        f1.apply((double) 1);
        f2.apply((double) 1);
    }

    public void test5(){
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<String> c1 = (o1,o2)->o1.compareTo(o2);

        Comparator<String> c2 = String::compareTo;

    }

    public void test6(){
        Employee e1 = new Employee("1","12");
        Function<Employee,String> f = new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        };

        Function<Employee,String> f1 = e -> e.getName();

        Function<Employee,String> f2 = Employee::getName;
    }

    public void test7(){
        BiPredicate<String,String> pre = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                return s.equals(s2);
            }
        };
        BiPredicate<String,String> pre1 = (s1,s2) -> s1.equals(s2);

        BiPredicate<String,String> pre2 = String::equals;

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
