package common.component

import common.model.WebActions
import org.openqa.selenium.WebElement

/**
 * Grid component
 * @author Assilzm
 * createTime 2014-5-12.
 */
class Grid extends WebActions {

    /**
     * default container tag name
     */
    final static String DEFAULT_CONTAINER_TAGNAME = "div"

    /**
     * default container attribute
     */
    final static String DEFAULT_CONTAINER_ATTRIBUTE = "class"

    /**
     * default container attribute value
     */
    final static String DEFAULT_CONTAINER_ATTRIBUTEVALUE = "nui-table"

    /**
     * current grid container selector
     */
    String containerSelector

    /**
     * current grid container selector with default value
     */
    Grid() {
        containerSelector = "//$DEFAULT_CONTAINER_TAGNAME[@$DEFAULT_CONTAINER_ATTRIBUTE='$DEFAULT_CONTAINER_ATTRIBUTEVALUE']"
    }

    /**
     * current grid container selector with custom value
     * @param selector
     */
    Grid(String selector) {
        containerSelector = selector
    }

    /**
     * find a cell element with row index and colum index
     * @param row
     * @param column
     * @return cell element
     */
    WebElement getCell(int row,int column){
       return findElement("$containerSelector/table/tbody/tr[$row]/td[$column]")
    }

}
