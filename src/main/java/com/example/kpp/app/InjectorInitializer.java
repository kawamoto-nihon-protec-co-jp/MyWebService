package com.example.kpp.app;

import com.example.kpp.guice.CommonModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Guice Injectorクラス
 * @author T.Kawamoto
 * @version 1.0
 */
public final class InjectorInitializer extends GuiceServletContextListener {

    public static Injector INJECTOR;

    @Override
    protected Injector getInjector() {
        INJECTOR = Guice.createInjector(new CommonModule());
        return INJECTOR;

    }

}
