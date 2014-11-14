package com.example.kpp;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mockit.Mocked;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.kpp.entity.HealthInfo;
import com.example.kpp.guice.CommonModule;
import com.example.kpp.guice.GuiceModules;
import com.example.kpp.guice.GuiceTestRunner;
import com.example.kpp.service.impl.HealthInfoServiceImpl;

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
//    private ProductRestService productRestService;

    @Inject
    private HealthInfoServiceImpl healthInfoService;

    @Test
    public void testDoTest() {
        List<HealthInfo> list = healthInfoService.findAll();
//        JsonBeanList res = productRestService.getMessage(mockResponse);
//        assertNull(res);
    }
}
