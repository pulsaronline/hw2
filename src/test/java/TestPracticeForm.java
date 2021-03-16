import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Selected;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm() {
        //открываем сайт
        open("https://demoqa.com/automation-practice-form");

        //заполняем формы
        $("#firstName").setValue("Boka").pressEnter();
        $("#lastName").setValue("Joka").pressEnter();
        $("#userEmail").setValue("legenda@mir.com").pressEnter();
        $("#gender-radio-3").doubleClick();       //с одинарным кликом не работало, почему то.
        $("#userNumber").setValue("8005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__day.react-datepicker__day--003").click();
        $("#subjectsInput").setValue("arts").pressEnter();

        $("#hobbiesWrapper").find(byText("Music")).click(); //подсказали, сам не догадался. Работа с радиокнопками и чекбоксами на сайте кривая или селенид дурит?

        File file = $("#uploadPicture").uploadFile(new File("src/test/java/resources/Joka.jpg"));


        $("#currentAddress").setValue("Russia, Krasnodar, Krasnaya 5.");
        $("#react-select-3-input").setValue("ncr").pressEnter();
        $("#react-select-4-input").setValue("gurgaon").pressEnter();


        sleep(10000);


        //проверяем формы

    }

}
