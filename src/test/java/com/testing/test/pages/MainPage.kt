package com.testing.test.pages

import org.openqa.selenium.By
import org.openqa.selenium.By.className
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.ExpectedConditions.*
import org.openqa.selenium.support.ui.WebDriverWait
import java.lang.Exception
import java.time.Duration
import java.util.concurrent.TimeUnit

class MainPage {

    private val driver: WebDriver

    @FindBy(xpath = "//*[@id=\"navigation\"]/nav/div[1]/div/div[1]/div[1]/a")
    private lateinit var generalNews: WebElement

    @FindBy(xpath = "//*[@id=\"navigation\"]/nav/div[1]/div/div[1]/div[2]/a")
    private lateinit var sbpNews: WebElement

    @FindBy(xpath = "//*[@id=\"navigation\"]/nav/div[1]/div/div[1]/div[3]/a")
    private lateinit var coronaNews: WebElement

    @FindBy(xpath = "//*[@id=\"navigation\"]/nav/div[1]/div/div[1]/div[4]/a")
    private lateinit var crisisNews: WebElement

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[3]/div[1]/div[1]/a[2]")
    private lateinit var firstGeneralNew: WebElement

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/div[1]/div[1]/a[2]")
    private lateinit var firstOtherNew: WebElement

    constructor(driver: WebDriver) {
        PageFactory.initElements(driver, this)
        this.driver = driver
    }

    fun displayGeneralNews() {
        generalNews.click()
    }

    fun displaySpbNews() {
        sbpNews.click()
    }

    fun displayCoronaNews() {
        coronaNews.click()
    }

    fun displayCrisisNews() {
        crisisNews.click()
    }

    fun getFirstOtherNew(): WebElement {
        return firstOtherNew
    }

    fun getFirstGeneralNew(): WebElement {
        return firstGeneralNew
    }

    fun openFirstOtherNew() {
        firstOtherNew.click()
    }

    fun openFirstGeneralNew() {
        firstGeneralNew.click()
    }
}