package ngdemo;

import javax.inject.Inject;

import ngdemo.guice.CommonModule;
import ngdemo.guice.GuiceModules;
import ngdemo.guice.GuiceTestRunner;
import ngdemo.service.impl.HealthInfoServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GuiceTestRunner.class)
@GuiceModules(CommonModule.class)
public class DBUnitTest extends DBunitSetup {
    @Inject
    private HealthInfoServiceImpl healthInfoService;

    static {
        xlsFile = "ngdemo/HEALTH_INFO.xml";
//        xlsFile = "HEALTH_INFO.xml";
        System.out.println("static");
    }

    @Test
    public void testDoTest() {
        System.out.println("dbUnit");
        healthInfoService.findAll();
    }
}
