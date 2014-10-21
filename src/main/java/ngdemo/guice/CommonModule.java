package ngdemo.guice;

import static com.google.inject.matcher.Matchers.*;
import ngdemo.dao.HealthInfoDao;
import ngdemo.dao.HealthInfoDaoImpl;
import ngdemo.guice.persist.DomaLocalTxInterceptor;
import ngdemo.guice.persist.DomaTransactionAttribute;
import ngdemo.rest.ProductRestService;
import ngdemo.service.HealthInfoService;
import ngdemo.service.IProductService;
import ngdemo.service.ProductService;
import ngdemo.service.impl.HealthInfoServiceImpl;

import org.aopalliance.intercept.MethodInterceptor;

import com.google.inject.matcher.Matchers;
import com.google.inject.servlet.ServletModule;

public class CommonModule extends ServletModule {

    @Override
    protected void configureServlets() {
       bind(IProductService.class).to(ProductService.class);
       bind(HealthInfoDao.class).to(HealthInfoDaoImpl.class);
       bind(HealthInfoService.class).to(HealthInfoServiceImpl.class);

       MethodInterceptor interceptor = new DomaLocalTxInterceptor();
       requestInjection(interceptor);

       ProductRestService productRestService = new ProductRestService();
       bind(ProductRestService.class).toInstance(productRestService);

       bindInterceptor(Matchers.annotatedWith(DomaTransactionAttribute.class),
               any(), interceptor);
       bindInterceptor(any(), annotatedWith(DomaTransactionAttribute.class),
               interceptor);
    }

}
