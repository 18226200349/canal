package com.dc.canal.example;

import java.math.BigDecimal;

/**
 * @ClassName SqrtUtil
 * @Description TODO
 * @Author fangxianyang
 * @Date 2020/1/1711:05 上午
 **/
public class SqrtUtil {
    /**
     * 方法1 精确度差
     * @param data
     * @return
     */
    public static double getSquareRoot(int data){
        if(data < 0){
            return -1;
        }
        double low = 0.0;
        double high = data;
        double mid = 0.0;
        while(isNumOfDigLessThenInput(mid, 6) ){
            mid = low + ((high - low) / 2);
            if(data == mid*mid){
                return mid;
            }else if(data < mid*mid){
                high = mid;
            }else{
                low = mid;
            }
        }
        return mid;
    }

    private static boolean isNumOfDigLessThenInput(double data,int num){
        String dataStr = String.valueOf(data);
        int index = dataStr.indexOf(".");
        if(index == -1){
            return true;
        }
        int numofDig = dataStr.length() - index;
        return numofDig <= 6;
    }

    /**
     * 方法2，易于理解，精确度高
     * @param a
     * @return
     */
    public static Double squareRoot(int a){
        double x = 0;
        double low = 0;
        double high = a;
        while(low<=high){
            x = (low+high)/2;
            if(x>a/x){
                high = x-0.000001;
            }
            //防止溢出
            if(x<a/x){
                low = x+0.000001;
            }
            if(x==a/x){
                //刚好整除
                return x+0.000001;
            }
        }
        //精确到六位小数
        return new BigDecimal(x).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println( SqrtUtil.squareRoot(5));
    }
}

