package com.example.kpp.guice;

import static com.google.inject.matcher.Matchers.*;

import org.aopalliance.intercept.MethodInterceptor;

import com.example.kpp.dao.HealthInfoDao;
import com.example.kpp.dao.HealthInfoDaoImpl;
import com.example.kpp.filter.EncodeingFilter;
import com.example.kpp.filter.HeaderFilter;
import com.example.kpp.guice.persist.DomaLocalTxInterceptor;
import com.example.kpp.guice.persist.DomaTransactionAttribute;
import com.example.kpp.service.HealthInfoService;
import com.example.kpp.service.impl.HealthInfoServiceImpl;
import com.google.inject.matcher.Matchers;
import com.google.inject.servlet.ServletModule;

/**
 * DIコンテナの設定クラス
 * @author T.Kawamoto
 * @version 1.0
 */
public class CommonModule extends ServletModule {

    @Override
    protected void configureServlets() {
       filter("/*").through(EncodeingFilter.class);
       filter("/*").through(HeaderFilter.class);

       bind(HealthInfoDao.class).to(HealthInfoDaoImpl.class);
       bind(HealthInfoService.class).to(HealthInfoServiceImpl.class);

       MethodInterceptor interceptor = new DomaLocalTxInterceptor();
       requestInjection(interceptor);

       bindInterceptor(Matchers.annotatedWith(DomaTransactionAttribute.class),
               any(), interceptor);
       bindInterceptor(any(), annotatedWith(DomaTransactionAttribute.class),
               interceptor);
    }

}
