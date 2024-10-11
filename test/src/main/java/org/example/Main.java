package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Main {

    WebDriver wd;

    @BeforeTest()
    public void beforeTestFixture() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        wd = WebDriverManager
                .chromedriver()
                .capabilities(chromeOptions)
                .create();
    }

    @Test()
    public void firstTest() {
        wd.get("http://matri-x.ru/");
        wd.manage().window().maximize();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By homePageH1Locator = By.xpath("//*[@id=\"categories\"]/div[1]/div/div/table/tbody/tr/td/center[1]/h1");
        WebElement homePageH1Element = wd.findElement(homePageH1Locator);
        String homePageh1ElementText = homePageH1Element.getText();
        //Проверка 1, Заголовок домашней страницы "Альтернативные источники энергии"
        Assert.assertEquals(homePageh1ElementText, "Альтернативные источники энергии");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By unknownBtnLocator = By.xpath("//*[@id=\"nav_app_forums\"]/a");
        WebElement unknownBtnElement = wd.findElement(unknownBtnLocator);
        //Действие 1, Нажатие на кнопку Непознанное
        unknownBtnElement.click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By unknownPageLocator = By.xpath("//*[@id=\"categories\"]/div[1]/div/div/table/tbody/tr/td/center/h1");
        WebElement unknownPageLocatorElement = wd.findElement(unknownPageLocator);
        boolean isUnknownPageLocatorElementPresented = unknownPageLocatorElement.isDisplayed();
        //Проверка 2, Заголовок страницы Непознанное отобразился
        Assert.assertTrue(isUnknownPageLocatorElementPresented);

        By civilizationOfMayaLinkLocator = By.xpath("//*[@id=\"categories\"]/div[1]/div/div/table/tbody/tr/td/center/a[8]");
        WebElement civilizationOfMayaLinkElement = wd.findElement(civilizationOfMayaLinkLocator);
        //Действие 2, Нажатие на ссылку Цивилизация Майя
        civilizationOfMayaLinkElement.click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By civilizationOfMayaTikalLinkLocator = By.xpath("//*[@id=\"categories\"]/div[9]/div/div/table/tbody/tr[2]/td[2]/h4/a");
        WebElement civilizationOfMayaTikalLinkElement = wd.findElement(civilizationOfMayaTikalLinkLocator);
        //Действие 3, Нажатие на ссылку Цивилизация Майя - Тикаль (Гватемала)
        civilizationOfMayaTikalLinkElement.click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By secondParagraphTikalLocator = By.xpath("/html/body/div/font[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[3]/h5[2]/p[3]");
        WebElement secondParagraphTikalElement = wd.findElement(secondParagraphTikalLocator);
        String secondParagraphTikalText = secondParagraphTikalElement.getText();
        //Проверка 3, второй параграф
        Assert.assertEquals(secondParagraphTikalText, "       В акрополе, судя по всему, люди постоянно жили на протяжении одиннадцати веков. На сегодняшний день сохранилось всего 16 храмов. Некоторые стоят на руинах более древних сооружений, среди которых есть и гробницы с удивительными по красоте росписями.");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        unknownBtnLocator = By.xpath("/html/body/table[1]/tbody/tr[3]/td[2]/font/a[1]");
        unknownBtnElement = wd.findElement(unknownBtnLocator);
        //Действие 4, Нажатие на кнопку Непознанное
        unknownBtnElement.click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By civilizationOfAztecsLinkLocator = By.xpath("//*[@id=\"categories\"]/div[1]/div/div/table/tbody/tr/td/center/a[9]");
        WebElement civilizationOfAztecsLinkElement = wd.findElement(civilizationOfAztecsLinkLocator);
        //Действие 5, Нажатие на ссылку Цивилизация Ацтеков
        civilizationOfAztecsLinkElement.click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By civilizationOfMayaTeotihuacanLinkLocator = By.xpath("//*[@id=\"categories\"]/div[10]/div/div/table/tbody/tr/td[2]/h4/a");
        WebElement civilizationOfMayaTeotihuacanLinkElement = wd.findElement(civilizationOfMayaTeotihuacanLinkLocator);
        //Действие 6, Нажатие на ссылку Цивилизация Ацтеков - Теотиуакан (Мексика)
        civilizationOfMayaTeotihuacanLinkElement.click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By teotihuacanH3Locator = By.xpath("/html/body/div/font[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[3]/h3");
        WebElement teotihuacanH3Element = wd.findElement(teotihuacanH3Locator);
        boolean isTeotihuacanH3ElementPresented = teotihuacanH3Element.isDisplayed();
        //Проверка 4, заголовок страницы Теотиуакан (Мексика) отобразился
        Assert.assertTrue(isTeotihuacanH3ElementPresented);
    }
}
