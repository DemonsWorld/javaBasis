package com.zlm.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Kakrolot
 * @date 2021/6/18 19:14
 */
public class LambdaDay1 {

    //消费型接口
    //Consumer<T>   void     accept(T t)
    public static void consumeTest(double money,Consumer<Double> c){
        c.accept(money);
    }

    //Supplier<T>     T      get()

    //Function<T,R>   R      apply(T t)

    //Predicate<T>   boolean test(T t)
    public static List<String> predicateTest(List<String> list, Predicate<String> p){
        List<String> rtnList = new ArrayList<>();
        for (String s : list) {
            if(p.test(s)) rtnList.add(s);
        }
        return rtnList;
    }


    public static void main(String[] args) {
        consumeTest(100, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        });

        consumeTest(100, a -> System.out.println(a));

        //=========================================================================================

        List<String> strs = Arrays.asList("1", "11", "111", "2", "222", "22");

        List<String> rtnList = predicateTest(strs, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.contains("1")) return true;
                return false;
            }
        });
        List<String> rtnList2 = predicateTest(strs, s -> s.contains("1"));

        for (String s : rtnList) {
            System.out.println(s);
        }

        for (String s : rtnList2) {
            System.out.println(s);
        }


    }
}
