package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import com.krigersv.pages.KinogoTestPageObjects;
import java.util.stream.Stream;

public class KinogoTest extends TestBase {
    KinogoTestPageObjects kinoPageObject = new KinogoTestPageObjects();

    @BeforeEach
    void setBeforeEach() {kinoPageObject.openPage();}

    static Stream<String> searchInformation() {
        return Stream.of("Невероятный мир глазами Энцо", "Там, где раки поют","Круче некуда", "Земля мафии");
    }

    @Tags({
            @Tag("should"),
            @Tag("web")})


    @ParameterizedTest(name = "После поиска {0} открылась страница с информацией о фильме {0}")
    @MethodSource("searchInformation")
    @DisplayName("Поиск с помощью @MethodSource в kinogo.biz")
    public void searchFilmsInformation(String search) {
        kinoPageObject
                .setComplete(search)
                .setLight()
                .setResults(search);

    }
}


