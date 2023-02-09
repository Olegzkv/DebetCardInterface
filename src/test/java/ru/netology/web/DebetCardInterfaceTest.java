package ru.netology.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class DebetCardInterfaceTest {
    @BeforeEach
    void shouldOpenBrowser() {
        open("http://localhost:9999/");
    }

    @Test
    public void shouldValidationFioTestOne() {
        $("[type=text]").setValue("Иван");
        $("[type=tel]").setValue("+79876543210");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));


    }

    @Test
    public void shouldValidationFioTestTwo() {
        $("[type=text]").setValue("Петров Иван");
        $("[type=tel]").setValue("+79876543210");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));


    }

    @Test
    public void shouldValidationFioTestThree() {
        $("[type=text]").setValue("Алёна");
        $("[type=tel]").setValue("+79876543210");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));


    }

    @Test
    public void shouldValidationFioTestFour() {
        $("[type=text]").setValue("Иванов-Петров Игорь");
        $("[type=tel]").setValue("+79876543210");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));


    }

    @Test
    public void shouldInvalidFioTestOne() {
        $("[type=text]").setValue("Ivan");
        $("[type=tel]").setValue("+79876543210");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldInvalidFioTestTwo() {
        $("[type=text]").setValue("123456789");
        $("[type=tel]").setValue("+79876543210");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }


    @Test
    public void shouldInvalidPhoneTestOne() {
        $("[type=text]").setValue("Анатолий");
        $("[type=tel]").setValue("+798765432101");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }

    @Test
    public void shouldInvalidPhoneTestTwo() {
        $("[type=text]").setValue("Анатолий");
        $("[type=tel]").setValue("+7987987654");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldFioFieldMissing() {
        $("[type=tel]").setValue("+79876543210");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldPhoneFieldMissing() {
        $("[type=text]").setValue("Анатолий");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));

    }

    @Test
    public void shouldCheckBoxFieldMissing() {
        $("[type=text]").setValue("Иван");
        $("[type=tel]").setValue("+79876543210");
        $(".button__content").click();
        $("[data-test-id=agreement]").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }
}