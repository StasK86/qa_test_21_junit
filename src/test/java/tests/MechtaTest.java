package tests;

import com.krigersv.pages.MechtaObjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;


public class MechtaTest extends TestBase {

    MechtaObjects mechtaPage = new MechtaObjects();

    @BeforeEach
    void setBeforeEach() {mechtaPage.openWeb();}


    @Tags({
            @Tag("select"),
            @Tag("web")
            })

    @ValueSource(strings = {"Смартфоны и гаджеты","Ноутбуки и компьютеры",
            "Игры, консоли и развлечения","ТВ, аудио, видео"})
    @ParameterizedTest(name = "После поиска {0} открылась страница с информацией о товаре {0}")
    @DisplayName("Поиск с помощью @MethodSource в mechta.kz")
    void productCategory(String category) {
        mechtaPage
                .openCatalog()
                .setResult(category);

    }
    static Stream<String> searchValue() {
        return Stream.of("Смартфоны и гаджеты","Ноутбуки и компьютеры",
                "Игры, консоли и развлечения","ТВ, аудио, видео");
    }
        @Tags({
                @Tag("select"),
                @Tag("web")
        })
        @MethodSource("searchValue")
        @ParameterizedTest(name = "После открытия каталога выбираем название категории {0}")
        @DisplayName("Поиск в каталогe для выбора категории товаров")

        void openCatalogToSelectSource(String setCategory) {
            mechtaPage
                    .openCatalog()
                    .setResult(setCategory);
        }


        @Tags({
                @Tag("select"),
                @Tag("web")
        })
        @CsvSource(value = {
                "Красота и здоровье | Красота и здоровье"
        },
                delimiter = '|')
        @ParameterizedTest(name = "После открытия страницы {0} должен присутствовать текст {1}")
        @DisplayName("Переходим на страницу для проверки")
        void openCatalogSource(String getCategory) {
            mechtaPage
                    .openCatalog()
                    .setClick(getCategory)
                    .shouldSet(getCategory);

        }
    }
