day1:继承Thread类，实现多线程
day2：实现runable接口，实现多线程
day3：实现Callable接口，实现多线程
    静态代理：
day4：
    线程休眠Thread.sleep()
    线程礼让Thread.yield() 不一定成功
    
线程停止的方式：
    1：使用退出标志终止线程
    2：interrupt()
    3: thread.stop()不推荐
        因为当调用某个线程的stop()方法时，此线程会被强行停止，不能将该线程的run()方法中的逻辑执行完全，可能会造成线程中的数据被破坏。
        
day5:退出标志终止线程示例
        
day6：interrupt()当非阻塞状态
day7：interrupt()当阻塞状态
        If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods of the Object class, or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int), methods of this class, then its interrupt status will be cleared and it will receive an InterruptedException.
        thread.interrupt()不可取。
        如果当前线程由于wait()……join()……sleep()……等方法的调用而被阻塞，它的intterupt状态会被清除并且会接收一个InterruptedException。
        
day8:线程强制执行join ()
day9:t1,t2,t3线程之间的顺序执行

dayC:线程的五种状态 new、runnable、running、Blocked、Dead
dayD:线程优先级 setPriority(int num) 0 < num <= 10

dayE:线程同步不安全示例，ArrayList为线程不安全示例
dayF:线程同步不安全示例，买票示例

synchronized用法：https://blog.csdn.net/luoweifu/article/details/46613015

dayG:死锁

        
        