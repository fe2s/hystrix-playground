package com.github.fe2s;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.Random;

/**
 * @author Oleksiy_Dyagilev
 */
public class CommandHelloWorld extends HystrixCommand<String> {
    private final String name;
    private int errorPercent = 5;
    private Random random = new Random();

    public CommandHelloWorld(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(100)
                        .withCircuitBreakerErrorThresholdPercentage(50)));
        this.name = name;
    }

    @Override
    protected String run() {
        if (random.nextInt(100) < errorPercent) {
            throw new RuntimeException();
        } else {
            try {
                Thread.sleep(random.nextInt(50));
            } catch (InterruptedException e) {
            }
            return "success";
        }

    }

    @Override
    protected String getFallback() {
        return "fallback " + name;
    }
}
