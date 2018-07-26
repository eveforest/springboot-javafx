package com.kingyea.kim.core.services.test;

import com.kingyea.kim.core.services.test.TestService;
import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("test service ....");
    }
}
