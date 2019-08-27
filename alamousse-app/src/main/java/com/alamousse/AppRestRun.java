package com.alamousse;

import com.alamousse.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author mike      @ComponentScan(basePackages={"com.alamousse.appmodules.*"})
 * @date 2018/11/15 9:20:19  "com.alamousse.appmodules.*""com.alamousse.appmodules.*" , "com.alamousse.appmodules.*"
 */
@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
public class AppRestRun {
    public static void main(String[] args) {
        SpringApplication.run(AppRestRun.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
