package com.shawn.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext ctx;
    private static final Object lock = new Object();

    @Override
    public void setApplicationContext(ApplicationContext appContext) {
        synchronized (lock) {
            ctx = appContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

}
