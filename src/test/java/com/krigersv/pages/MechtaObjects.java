package com.krigersv.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MechtaObjects {

    SelenideElement
            catalogSet = $(".text-ts7"),
            resultSet = $(".q-list"),
            setShould = $(".text-ts5"),
            clickSet = $(".q-list");

    public MechtaObjects openWeb() {
        open("https://www.mechta.kz/");
        return this;
    }
    public MechtaObjects openCatalog() {
        catalogSet.doubleClick();
        return this;
    }
    public MechtaObjects setResult(String result) {
        resultSet.shouldHave(text(result));
        return this;
    }
    public MechtaObjects setClick(String value) {
        clickSet.shouldHave(text(value)).click();
        return this;
    }
    public MechtaObjects shouldSet(String result) {
        setShould.shouldHave(text(result));
        return this;

    }
}







