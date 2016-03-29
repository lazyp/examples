package org.example.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * <p>
 * Google Guava Stopwatch(计时器) example
 * 
 * 请注意:Stopwatch 线程不安全
 * </p>
 * 
 * @author lazyp
 *
 */
public class StopWatchExample {

    public static void sleep(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 可以看到调用reset方法后,计时器已经清零.
     */
    public static void example3() {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();// 开始计时
        // do something
        sleep(1000);
        // end
        // stopwatch.stop();// 暂停计时,计时器不会清零

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));// 时间以毫秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));// 时间以纳秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));// 时间以秒为单位,结果会自动取整

        System.out.println("");

        stopwatch.reset();// 重置计时器,并停止计时
        stopwatch.start();// 重新开始计时
        // do something
        sleep(1000);
        // end
        stopwatch.stop();// 暂停计时

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));// 时间以毫秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));// 时间以纳秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));// 时间以秒为单位,结果会自动取整
    }

    /**
     * 可以看到第一次和第二次计时,时间是累加的
     */
    public static void example2() {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();// 开始计时
        // do something
        sleep(1000);
        // end
        stopwatch.stop();// 暂停计时,计时器不会清零

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));// 时间以毫秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));// 时间以纳秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));// 时间以秒为单位,结果会自动取整

        System.out.println("");

        stopwatch.start();// 继续开始计时,时间累加
        // do something
        sleep(1000);
        // end
        stopwatch.stop();// 暂停计时

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));// 时间以毫秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));// 时间以纳秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));// 时间以秒为单位,结果会自动取整
    }

    public static void example1() {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();// 开始计时
        // do something
        sleep(1000);
        // end
        stopwatch.stop();// 结束(暂停)计时

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));// 时间以毫秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.NANOSECONDS));// 时间以纳秒为单位
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));// 时间以秒为单位,结果会自动取整
    }

    public static void main(String[] args) {
        System.out.println("########### example1 ###########");
        example1();

        System.out.println("########### example2 ###########");
        example2();

        System.out.println("########### example3 ###########");
        example3();
    }

}
