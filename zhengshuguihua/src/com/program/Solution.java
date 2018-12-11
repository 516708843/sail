package com.program;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 思路：
 * 以一种车为开始，依次递增其他车辆至最大值，
 */
public class Solution {
    @Test
    public void test01(){
        findMax();
    }

    //时间总量
    int time = 6000;
    //货物量
    float goods = 600f;
    //车
    CarGroup carA = new CarGroup(280,2,1.5f);
    CarGroup carB = new CarGroup(250,3,3f);
    CarGroup carC = new CarGroup(400,4,5f);


    public int findMax(){
        int max = 0;
        //确定选项优先级
        List<CarGroup> a = new ArrayList<>();
        a.add(carA);
        a.add(carB);
        a.add(carC);
        a.sort(null);
        Collections.reverse(a);
        for (CarGroup car:
             a) {
            if (car.num!=0){
                car.num -=1;
            }else{
                int numByLoad = toIntAdd(goods, car.carload);
                int numByTime = time/car.time;
                car.num = numByLoad>numByTime ? numByTime : numByLoad;
             }
            goods -= car.num*car.carload;
            time -= car.num*car.time;
            max += car.num*car.profit;
            System.out.println(car);
            System.out.println("剩余时间："+time);
            System.out.println("剩余货物:"+goods);
        }
        System.out.println(a);

        return max;
    }

    public int toIntAdd(float goodsNum,float moveNum){
        float num = goodsNum/moveNum;
        return num%1>0 ? (int)num+1 : (int)num;
    }

}

class CarGroup implements Comparable{
    /**时间*/
    int time ;
    /**利润*/
    int profit ;
    /**载货量*/
    float carload ;
    /**利润率*/
    float profitRate;
    /**数量*/
    int num;
    public CarGroup() {
    }

    public CarGroup(int time, int profit, float carload) {
        this.time = time;
        this.profit = profit;
        this.carload = carload;
        profitRate = carload/time *profit;
    }

    @Override
    public int compareTo(Object o) {
        return (int)profitRate*100;
    }

    @Override
    public String toString() {
        return "CarGroup{" +
                "carload=" + carload +
                ", profitRate=" + profitRate +
                ", num=" + num +
                '}';
    }
}