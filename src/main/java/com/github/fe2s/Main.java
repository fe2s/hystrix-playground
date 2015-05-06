package com.github.fe2s;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author Oleksiy_Dyagilev
 */
@EnableAutoConfiguration
public class Main {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
    }

    @Bean
    public CommandExecutor commandExecutor() {
        return new CommandExecutor();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
