package config;

import com.google.inject.AbstractModule;
import utils.DataPropertiesUtil;
import utils.PageUtil;
import utils.UrlBuilderUtil;

public class GuiceModule extends AbstractModule {

    public void configure() {
        install(new WebDriverModule());

        bind(PageUtil.class).asEagerSingleton();
        bind(UrlBuilderUtil.class).asEagerSingleton();
        bind(DataPropertiesUtil.class).asEagerSingleton();
    }

}