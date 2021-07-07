Lambda
day1:四种内置函数接口简介
day2：lambda表达式的方法引用
    使用情景：当要传递给Lambda体的操作，已经有实现方法了。可以使用方法引用
    方法引用：本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例，所以方法引用就是函数式接口的实例
    使用格式：
        对象：：非静态方法
        类  ：：静态方法
        类  ：：非静态方法
    方法引用要求：要求接口中抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同
    
day3:lambda构造器引用和数组引用
    构造器引用：和方法引用了类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致，抽象方法的返回值类型即为构造器所属类的类型。
      数组引用：
      
Stream      
    Stream关注的是对数据的运算，与CPU打交道；集合关注的是数据的存储，与内存打交道
    Stream：不会自己存储元素
    Stream：不会改变源对象，会返回一个持有结果的新Stream
    Stream：操作是延迟操作，等到需要结果时才执行
    Stream执行流程：
        1.Stream实例化
        2.一系列中间操作
        3.终止操作
    Stream执行说明：
        1.一个中间操作链，对数据源数据进行处理
        2.一旦进行终止操作，就执行中间操作链，并产生结果。之后不会在被利用。
    day1：创建Stream方式4种
    day2: Stream的中间操作-筛选与切片     filter、skip、limit、distinct
    day3: Stream的中间操作-映射    map、flatMap    
    day4: Stream的中间操作-排序    sort
    day5: Stream终止操作-匹配与查找      
        allMatch、anyMatch、noneMatch、findFirst、findAny、count、max、min、forEach
    day6：Stream终止操作-归约 ruduce
          Stream终止操作-收集 collect
          
    
          
    
    
      
        
    
    

    