package dayday;

import org.hibernate.validator.internal.constraintvalidators.bv.number.bound.AbstractMinValidator;

/**
 * @author Kakrolot
 * @date 2021/6/10 14:05
 */
public class Test2 {
    public static void main(String[] args) {
        String  str  = "000";
        String  str1 = "111";
        String  str2 = "222";
        String  str3 = "333";

        str += str1 + str2 + str3;
        System.out.println(str);

    }
}
