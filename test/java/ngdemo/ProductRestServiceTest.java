package ngdemo;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mockit.Mocked;
import ngdemo.bean.JsonBeanList;
import ngdemo.entity.HealthInfo;
import ngdemo.guice.CommonModule;
import ngdemo.guice.GuiceModules;
import ngdemo.guice.GuiceTestRunner;
import ngdemo.rest.ProductRestService;
import ngdemo.service.impl.HealthInfoServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GuiceTestRunner.class)
@GuiceModules(CommonModule.class)
public class ProductRestServiceTest {

    /** HttpServletRequestのモック  */
    @Mocked
    private HttpServletRequest mockRequest;

    /**  HttpServletResponseのモック */
    @Mocked
    private HttpServletResponse mockResponse;

    @Mocked
    private ProductRestService productRestService;

    @Inject
    private HealthInfoServiceImpl healthInfoService;

    @Test
    public void testDoTest() {
        List<HealthInfo> list = healthInfoService.findAll();
        JsonBeanList res = productRestService.getMessage(mockResponse);
        assertNull(res);
    }
}
