package com.aric.seckill.controller;

import com.aric.common.utils.PrinterUtils;
import com.aric.common.utils.StringUtils;
import com.aric.seckill.entity.Account;
import com.aric.seckill.service.LoginService;
import com.aric.seckill.common.ResponseInfo;
import com.aric.seckill.common.SystemEnum;
import com.aric.seckill.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by Administrator on 2016/7/9.
 * 用户登录
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("welcome")
    public String welcome(Locale locale){
        PrinterUtils.printILog(locale);
        PrinterUtils.printILog(messageSource.getMessage("system.hello",null,locale));
        return "home";
    }

    @RequestMapping("")
    public String redirect(HttpSession session){
        if(session.getAttribute("currentUser")!=null){
            return "redirect:welcome";
        }
        return "login";
    }

    @ResponseBody
    @RequestMapping("login")
    public ResponseInfo login(String username,String password,HttpSession session){
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            return new  ResponseInfo(false,SystemEnum.RESPONSE_CODE.ERROR.getCode(),
                    "用户名或密码不能为空！", Constant.LOGIN_ERROR_INCOMPLETE);
        }
        try {
           Account account= loginService.login(username, password);
           if(account!=null){
               session.setAttribute("currentUser",account);
               String redirect=(String)session.getAttribute("redirect");
//               if(StringUtils.isNotEmpty(redirect)){
//                   session.removeAttribute("redirect");
//                   return new ResponseInfo(true,
//                           SystemEnum.RESPONSE_CODE.SUCCESS.getCode(),Constant.LOGIN_SUCCESS_REDIRECT,"success",redirect);
//               }
               return new ResponseInfo(true,
                       SystemEnum.RESPONSE_CODE.SUCCESS.getCode(),"success",Constant.LOGIN_SUCCESS_INIT);
           }
            return new ResponseInfo(false,SystemEnum.RESPONSE_CODE.ERROR.getCode(),
                    "用户名或密码错误",Constant.LOGIN_ERROR_INCOMPLETE);
        }catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseInfo(false,SystemEnum.RESPONSE_CODE.ERROR.getCode(),"error",Constant.SYSTEM_ERROR);
    }


}
