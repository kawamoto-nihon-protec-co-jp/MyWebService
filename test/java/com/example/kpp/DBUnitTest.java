package com.example.kpp;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.kpp.entity.HealthInfo;
import com.example.kpp.guice.CommonModule;
import com.example.kpp.guice.GuiceModules;
import com.example.kpp.guice.GuiceTestRunner;
import com.example.kpp.service.HealthInfoService;

@RunWith(GuiceTestRunner.class)
@GuiceModules(CommonModule.class)
public class DBUnitTest extends DBunitSetup {
    @Inject
    private HealthInfoService healthInfoService;

    static {
        xlsFile = "com/example/kpp/HEALTH_INFO.xml";
//        xlsFile = "HEALTH_INFO.xml";
        System.out.println("static");
    }

    @Test
    public void testDoTest() {
        System.out.println("dbUnit");
        List<HealthInfo> list = healthInfoService.findAll();
    }
}
