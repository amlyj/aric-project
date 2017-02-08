package com.aric.seckill.controller;

import com.aric.common.utils.PrinterUtils;
import com.aric.seckill.common.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by Administrator on 2016/7/14.
 */
@Controller
@RequestMapping("/common/")
public class CommonController {

    @RequestMapping("changeLocale")
    @ResponseBody
    public String changeLocale(HttpServletRequest request,String locale,HttpServletResponse response)throws Exception{
        if(StringUtils.isEmpty(locale)){
            Cookie cookies[]= request.getCookies();
            locale="zh_CN";
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("language")){
                    locale= cookie.getValue();
//                    System.err.print("获取到了浏览器存储的cookie值："+locale);
                }
            }
        }
        Cookie cookie = new Cookie("language",locale);
        cookie.setMaxAge(Integer.valueOf(31536000));
        cookie.setPath("/");
        response.addCookie(cookie);
        return Global.OK;
    }
}



