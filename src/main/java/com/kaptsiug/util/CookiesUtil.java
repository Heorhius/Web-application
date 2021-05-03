package com.kaptsiug.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

public class CookiesUtil {

    public static long getUserCookies(HttpServletRequest request) {
        long guid = 0;

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("guid")) {
                    guid = Long.parseLong(cookie.getValue());
                }
            }
        }
        return guid;
    }

    public static void setUserCookies(HttpServletResponse response) {
        Random random = new Random();
        String guid = String.valueOf(random.nextLong());

        Cookie cookie = new Cookie("guid", guid);
        cookie.setMaxAge(1800);
        response.addCookie(cookie);
    }

    public static void deleteCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("guid", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
