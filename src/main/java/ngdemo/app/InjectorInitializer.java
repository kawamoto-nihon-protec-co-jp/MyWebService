package ngdemo.app;

import ngdemo.service.ServiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public final class InjectorInitializer extends GuiceServletContextListener {

    public static Injector INJECTOR;

    @Override
    protected Injector getInjector() {
        INJECTOR = Guice.createInjector(new ServiceModule());
        return INJECTOR;

    }

}
