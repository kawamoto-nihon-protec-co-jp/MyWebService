package ngdemo.service;

import com.google.inject.servlet.ServletModule;

public final class ServiceModule extends ServletModule {

    @Override
    protected void configureServlets() {
       bind(IProductService.class).to(ProductService.class);
    }

}
