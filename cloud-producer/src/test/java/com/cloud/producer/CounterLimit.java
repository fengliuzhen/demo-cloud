package com.cloud.producer;

public class CounterLimit {
    //获取当前毫秒数
    private static long timeStamp=System.currentTimeMillis();
    //1秒内最大请求的数量
    private static long limitReqCount=100;
    //间隔毫秒数
    private static long interval=1000;
    //请求数
    private static long reqCount=0;
    //计数器限流
    public static boolean grant()
    {
        long nowStamp=System.currentTimeMillis();
        if(nowStamp<timeStamp+interval)
        {
            if(reqCount<limitReqCount)
            {
                ++reqCount;
                System.out.println(reqCount);
                return true;
            }
            else
            {
                return  false;
            }
        }
        else
        {
            timeStamp=System.currentTimeMillis();
            reqCount=0;
            return false;
        }
    }
}
