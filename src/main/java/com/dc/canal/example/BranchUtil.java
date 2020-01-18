package com.dc.canal.example;

import java.sql.Array;

/**
 * @ClassName BranchUtil
 * @Description TODO
 * @Author fangxianyang
 * @Date 2020/1/172:42 下午
 **/
public class BranchUtil {
    /**
     *
     * @param x 数组长度
     * @param a 数组
     * @param value 要获取的值
     * @return
     */
    public  static  int branch(int x, int [] a,int value){
        int low=0;
        int high=x-1;
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(a[mid]>=value){
               high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(low<x){

            while (a[low]==value){
                if(low+1>=x){
                    return low;
                }
                if(a[low+1]!=value){
                    return low;
                }
                low=low+1;
            }
            return low;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] a={1,2,3,4,5,5,6,6,6};
        int x=a.length;
        int value=5;
        System.out.println(BranchUtil.branch(x,a,value));
    }
}
