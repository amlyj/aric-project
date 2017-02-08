package com.aric.webui.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2016/7/21.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.aric"})
public class App extends SpringBootServletInitializer {



    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);

    }
}
