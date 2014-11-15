package com.example.kpp;

//import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
public class HealthInfoServiceTest extends DBunitSetup {
    @Inject
    private HealthInfoService healthInfoService;

    static {
        xlsFile = "com/example/kpp/HEALTH_INFO.xml";
    }

    @Test
    public void testFindAll() {
        List<HealthInfo> list = healthInfoService.findAll();
        assertThat(list.size(), is(greaterThan(0)));
    }

    @Test
    public void testFindForChartCols() {
        List<HealthInfo> list = healthInfoService.findForChartCols();
        assertThat(list.size(), is(greaterThan(0)));
    }

    @Test
    public void testFindForChartRows() {
        List<HealthInfo> list = healthInfoService.findForChartRows();
        assertThat(list.size(), is(greaterThan(0)));
    }
}
