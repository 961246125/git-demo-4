package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class Test04 {

    public static void main(String[] args) {
        //等额本金
//        double lv_gjj = 0.031 / 12;
//        double lv_shang = 0.041 / 12;
//        double sum_shang = 90 * 10000;
//        double sum_gjj = 60 * 10000;
//        double benjin_shang = sum_shang / 30 / 12;
//        double benjin_gjj = sum_gjj / 30 / 12;
//        System.out.println(benjin_shang * 5 * 12);
//        System.out.println(benjin_gjj * 5 * 12);
//        double temp = 0;
//        double lixi = 0;
//
//        for (int i = 0; i < 30 * 12; i++) {
//            double lixi_shang = sum_shang * lv_shang;
//            double lixi_gjj = sum_gjj * lv_gjj;
//            //每月总还款（本金+利息）
////            System.out.println("每月总还款：" + (lixi_shang + lixi_gjj + benjin_gjj + benjin_shang));
//            //每月利息
//            System.out.println("每月利息：" + (lixi_shang + lixi_gjj));
//            //每月本金
////            System.out.println("每月本金：" + (benjin_gjj + benjin_shang));
//            temp = temp + lixi_shang + lixi_gjj + benjin_gjj + benjin_shang;
//            sum_shang = sum_shang - benjin_shang;
//            sum_gjj = sum_gjj - benjin_gjj;
//            lixi = lixi + lixi_shang + lixi_gjj;
//        }
//        System.out.println("总还款：" + temp);
//        System.out.println("总利息：" + lixi);



        //等额本息
//        double sum_gjj = 60 * 10000;
//        double lv_gjj = 0.031 / 12;
//        double zong_lixi_gjj = sum_gjj * lv_gjj * Math.pow(1 + lv_gjj, 360) / (Math.pow(1 + lv_gjj, 360)-1) ;
//        double sum_shang = 90 * 10000;
//        double lv_shang = 0.041 / 12;
//        double zong_lixi_shang = sum_shang * lv_shang * Math.pow(1 + lv_shang, 360) / (Math.pow(1 + lv_shang, 360)-1) ;
//        double temp_gjj = 0;
//        double temp_shang = 0;
//        double lixi = 0;
//        List<Double> list = new ArrayList<>();
//        for (int i = 0; i < 30 * 12; i++) {
//            double lixi_gjj = sum_gjj * lv_gjj;
//            double lixi_shang = sum_shang * lv_shang;
//            double benjin_gjj = zong_lixi_gjj - lixi_gjj;
//            double benjin_shang = zong_lixi_shang - lixi_shang;
//            //每月总还款
//            System.out.println("每月总还款：" + (zong_lixi_gjj + zong_lixi_shang));
//            //每月本金
//            System.out.println("每月本金：" + (benjin_gjj + benjin_shang));
//            //每月利息
//            System.out.println("每月利息：" + (lixi_gjj + lixi_shang));
//            list.add(lixi_gjj + lixi_shang);
//            sum_gjj = sum_gjj - benjin_gjj;
//            sum_shang = sum_shang - benjin_shang;
//            temp_gjj = temp_gjj + benjin_gjj;
//            temp_shang = temp_shang + benjin_shang;
//            lixi = lixi + lixi_gjj + lixi_shang;
//        }
//        System.out.println("公积金已还：" + temp_gjj);
//        System.out.println("商贷已还：" + temp_shang);
//        System.out.println("利息：" + lixi);
//        System.out.println(temp_gjj + temp_shang);
//        for (int i = 1; i < list.size(); i++) {
////            System.out.println(list.get(i) - list.get(i-1));
//        }
    }
}
