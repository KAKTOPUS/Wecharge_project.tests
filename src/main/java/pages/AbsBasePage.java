package pages;

import com.google.inject.Inject;
import common.AbsCommon;
import data.PagesData;
import io.qameta.allure.Step;
import utils.UrlBuilderUtil;

public abstract class AbsBasePage extends AbsCommon {

    @Inject
    private UrlBuilderUtil urlBuilderUtil;

    @Step("Открыть страницу {path}")
    public void open(PagesData path) {
        driver.get(urlBuilderUtil.buildUrl(path.getText()));
    }

}
