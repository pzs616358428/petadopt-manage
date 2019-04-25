package com.ysy.petadopt.utils;

import org.springframework.data.domain.Page;

/**
 * 分页工具类
 */
public class PageUtils {

    public static int[] getNavigationNums(Page page) {
        // 当前页码,page.getNumber()从0计数,所以+1
        int number = page.getNumber() + 1;
        // 总共多少页
        int totalPages = page.getTotalPages();
        // 总页数小于等于5
        if (totalPages <= 5) {
            int[] navigationNums = new int[totalPages];
            for (int i = 0; i < navigationNums.length; i++) {
                navigationNums[i] = i + 1;
            }
            return navigationNums;
        } else {
            if (number < 3) {
                int[] navigationNums = {1, 2, 3, 4, 5};
                return navigationNums;
            } else if (number > totalPages - 2) {
                int[] navigationNums = {totalPages - 4, totalPages - 3, totalPages - 2, totalPages - 1, totalPages};
                return navigationNums;
            } else {
                int[] navigationNums = {number - 2, number - 1, number, number + 1, number + 2};
                return navigationNums;
            }
        }
    }

}
