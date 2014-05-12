package common.model

import common.utils.LogUtils
import org.apache.log4j.Logger
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement


/**
 * web actions of WebDriver or etc.
 * Created by Assilzm on 2014/5/9.
 */
abstract class WebActions {

    WebDriver driver

    private final static Logger logger=LogUtils.getLogger(WebActions)

    /**
     * init webdriver
     * @param driver
     */
    void setDriver(WebDriver driver) {
        this.driver = driver
    }

    /**
     * get webdriver
     * @param driver
     */
    WebDriver getDriver() {
        return driver
    }

    /**
     * find element by xpath
     * @param selector
     * @return
     */
    WebElement findElement(String selector){
        logger.debug("get a element with xpath $selector")
        return driver.findElement(By.xpath(selector))
    }

    /**
     * find elements by xpath
     * @param selector
     * @return
     */
    List<WebElement> findElements(String selector){
        logger.debug("get elements with xpath $selector")
        return driver.findElements(By.xpath(selector))
    }

    /**
     * click at a element
     * @param selector  selector of the element
     */
    void click(String selector){
        logger.debug("click at [$selector]")
    }

    /**
     * type in a element
     * @param selector selector of the element
     * @param text text to type
     */
    void type(String selector,String text){
        logger.debug("type [$text] in [$selector]")
    }

    /**
     * get attribute of a element
     * @param selector selector of the element
     * @param attributeName attributeName of the element,default is text
     * @return attribute text value
     */
    String getValue(String selector,String attributeName="text"){
        logger.debug("get attribute [$attributeName] in [$selector]")
    }

    /**
     * select a radio
     * @param selector  selector of the element
     */
    void selectRadio(String selector){
        logger.debug("select radio in [$selector]")
    }

    /**
     * unselect a radio
     * @param selector  selector of the element
     */
    void unSelectRadio(String selector){
        logger.debug("unselect radio in [$selector]")
    }

    /**
     * select a checkbox
     * @param selector  selector of the element
     */
    void selectCheckBox(String selector){
        logger.debug("select checkbox in [$selector]")
    }

    /**
     * unselect a checkbox
     * @param selector  selector of the element
     */
    void unSelectCheckBox(String selector){
        logger.debug("unselect checkbox in [$selector]")
    }

    /**
     * get current window title
     * @return current window title
     */
    String getTitle(){
        return  "window title"
    }

}
