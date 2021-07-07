package com.zlm.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Kakrolot
 * @date 2021/6/18 22:29
 */
public class LambdaDay3 {

    public void test1(){
        Supplier<Employee>  s = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        Supplier<Employee> s1 = ()-> new Employee();

        Supplier<Employee> s2 = Employee::new;

    }

    public void test2(){
        Function<String,Employee> f = new Function<String, Employee>() {
            @Override
            public Employee apply(String s) {
                return new Employee(s);
            }
        };

        Function<String,Employee> f1 = s -> new Employee(s);

        Function<String,Employee> f2 = Employee::new;
    }

    public void test3() {
        BiFunction<String, String, Employee> bf = new BiFunction<String, String, Employee>() {
            @Override
            public Employee apply(String s, String s2) {
                return new Employee(s, s2);
            }
        };

        BiFunction<String, String, Employee> bf1 = (s, s1) -> new Employee(s, s1);

        BiFunction<String, String, Employee> bf2 = Employee::new;
    }

    public void test4(){
        Function<Integer,String[]> f = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };

        Function<Integer,String[]> f1 = length -> new String[length];

        Function<Integer,String[]> f2 = String[]::new;

     }




    class Employee{
        private String name;
        private String id;

        public Employee() {

        }

        public Employee(String id) {
            this.id = id;
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

        public Employee(String name, String id) {
            this.name = name;
            this.id = id;
        }
    }

}
