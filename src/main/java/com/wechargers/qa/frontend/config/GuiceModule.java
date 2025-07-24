package com.wechargers.qa.frontend.config;

import com.google.inject.AbstractModule;
import com.wechargers.qa.frontend.utils.PageUtil;

public class GuiceModule extends AbstractModule {

    public void configure() {
        install(new WebDriverModule());

        bind(PageUtil.class).asEagerSingleton();
    }

}