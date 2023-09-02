package com.krigersv.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class KinogoTestPageObjects {
    SelenideElement
            autoComplete = $("[autocomplete]"),
            lightSearchInput = $(".lightsearch__content"),
            results = $(".lightsearch__results");

    public KinogoTestPageObjects openPage() {
        open("https://kinogo.biz/");
        return this;
    }

    public KinogoTestPageObjects setComplete(String input) {
        autoComplete.setValue(input);
        return this;
    }

    public KinogoTestPageObjects setLight() {
            lightSearchInput.click();
            return this;

        }
    public KinogoTestPageObjects setResults(String searchKinogo) {
        results.shouldHave(text(searchKinogo));
            return this;
    }
}


