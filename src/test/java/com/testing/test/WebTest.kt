package com.testing.test

import com.testing.test.pages.MainPage
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.TimeUnit
import kotlin.io.path.ExperimentalPathApi
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

const val URL = "https://smi2.ru/"

class WebTest {

    private lateinit var driver: WebDriver

    @ExperimentalPathApi
    @BeforeEach
    fun setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/amaltsev/Downloads/chromedriver");
        val chromeOptions = ChromeOptions()

//        chromeOptions.setBinary(Path("/Users/amaltsev/Downloads/chromedriver").toFile())
        chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
        chromeOptions.addArguments("disable-infobars"); // disabling infobars
        chromeOptions.addArguments("--disable-extensions"); // disabling extensions
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--remote-debugging-port=9222")
        chromeOptions.addArguments("--no-sandbox");
        driver = ChromeDriver(chromeOptions)

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.get(URL)
    }

    @AfterEach
    fun afterEach() {
        driver.quit()
    }

    @Test
    fun shouldDisplayFirstGeneralNew() {
        val mainPage = MainPage(driver)

        mainPage.displayGeneralNews()

        val firstNew = mainPage.getFirstGeneralNew()

        assertNotNull(firstNew)

        mainPage.openFirstGeneralNew()

        assertTrue { driver.windowHandles.size == 2 } // мы открыли новость на стороннем сайте
    }

    @Test
    fun shouldDisplaySpbNew() {
        val mainPage = MainPage(driver)

        mainPage.displaySpbNews()

        val firstNew = mainPage.getFirstOtherNew()

        assertNotNull(firstNew)

        mainPage.openFirstOtherNew()

        assertTrue { driver.windowHandles.size == 2 } // мы открыли новость на стороннем сайте
    }

    @Test
    fun shouldDisplayFirstCoronaNew() {
        val mainPage = MainPage(driver)

        mainPage.displayCoronaNews()

        val firstNew = mainPage.getFirstOtherNew()

        assertNotNull(firstNew)

        mainPage.openFirstOtherNew()

        assertTrue { driver.windowHandles.size == 2 } // мы открыли новость на стороннем сайте
    }

    @Test
    fun shouldDisplayFirstCrisisNew() {
        val mainPage = MainPage(driver)

        mainPage.displayCrisisNews()

        val firstNew = mainPage.getFirstOtherNew()

        assertNotNull(firstNew)

        mainPage.openFirstOtherNew()

        assertTrue { driver.windowHandles.size == 2 } // мы открыли новость на стороннем сайте
    }
}