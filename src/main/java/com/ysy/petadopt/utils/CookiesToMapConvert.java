package com.ysy.petadopt.utils;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookiesToMapConvert {

    /**
     * 将cookie数组转化为map集合
     * @param cookies
     * @return 转化后的map集合
     */
    public static Map<String, String> convert(Cookie[] cookies) {
        Map<String, String> map = new HashMap<>();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie.getValue());
            }
        }
        return map;
    }

}
