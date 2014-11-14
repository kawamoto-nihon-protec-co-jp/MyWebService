package com.example.kpp.app;

import javax.inject.Inject;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

/**
 * Jersey設定クラス
 * @author T.Kawamoto
 * @version 1.0
 */
public final class Application extends ResourceConfig {

    @Inject
    public Application(ServiceLocator serviceLocator) {
        packages("com.example.kpp.rest");

        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);

        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(InjectorInitializer.INJECTOR);
    }

}