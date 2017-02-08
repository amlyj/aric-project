package com.aric.webui.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/7/21.
 */
@Controller
public class WebController {
    @RequestMapping("/")
    String home() {
        return "login";
    }

    @RequestMapping("/index")
    ModelAndView index() {
      return  new ModelAndView("index","user","king-aric");
    }

}
