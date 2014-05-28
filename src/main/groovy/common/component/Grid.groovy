package common.component

import common.model.WebActions
import org.openqa.selenium.WebElement

import static org.hamcrest.core.IsCollectionContaining.hasItem
import static org.junit.Assert.assertThat

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

    final static String TABLE_TAGNAME = "table"

    final static String TR_TAGNAME = "tr"

    final static String TD_TAGNAME = "td"

    final static String TABLE_HEAD_TAGNAME = "thead"

    final static String TABLE_BODY_TAGNAME = "tbody"


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
    WebElement getCell(int rowIndex,int columnIndex){
        return findElement("$containerSelector/$TABLE_TAGNAME/$TABLE_BODY_TAGNAME/$TR_TAGNAME[$rowIndex]/$TD_TAGNAME[$columnIndex]")
    }


    /**
     * find a cell element with column head text and cell text
     * @param headText
     * @param cellText
     * @return cell element
     */
    WebElement getCell(String headText,String cellText){
        WebElement cell=null
        List<String> headTextList=getHeadTextList()
        assertThat("table has head [$headText]",headTextList,hasItem(cellText))
        int headIndex=headTextList.indexOf(headText)+1
        List<String> columnTexts=getTexts("$containerSelector/$TABLE_TAGNAME/$TABLE_BODY_TAGNAME/$TR_TAGNAME/$TD_TAGNAME[$headIndex]")
        int trIndex=columnTexts.indexOf(cellText)+1
        if (trIndex>0)
            cell= findElement("$containerSelector/$TABLE_TAGNAME/$TABLE_BODY_TAGNAME/$TR_TAGNAME[$trIndex]/$TD_TAGNAME[$headIndex]")
        return  cell
    }

    /**
     * get all head text
     * @return
     */
    List<String> getHeadTextList(){
        return getTexts("$containerSelector/$TABLE_TAGNAME/$TABLE_HEAD_TAGNAME/$TR_TAGNAME/$TD_TAGNAME")
    }



}
