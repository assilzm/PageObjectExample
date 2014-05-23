package common.component

import common.model.WebActions
import common.utils.LogUtils
import org.apache.log4j.Logger
import org.openqa.selenium.WebElement

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertThat

/**
 * Tree component demo
 * Tree example url:http://www.ztree.me/v3/demo.php#_102
 * @author Assilzm
 * createTime 2014-5-23 15:45.
 */
class Tree extends WebActions {


    private final static Logger logger = LogUtils.getLogger(Tree)

    /**
     * tree container tag name
     */
    final static String CONTAINER_TAG_NAME = 'div'

    /**
     * tree container attribute name
     */
    final static String CONTAINER_ATTRIBUTE_NAME = "class"

    /**
     * tree container attribute value
     */
    final static String CONTAINER_ATTRIBUTE_VALUE = "zTreeDemoBackground"

    /**
     * switcher selector
     */
    final static String SWITCHER_SELECTOR = "span[starts-with(@class,'ico_')]"

    /**
     * switcher attribute to verify
     */
    final static String SWITCHER_ATTRIBUTE_NAME = "class"

    /**
     * tree node switcher closed class
     */
    final static String SWITCHER_CLOSED_ATTRIBUTE_VALUE = "ico_close"

    /**
     * tree node switcher opened class
     */
    final static String SWITCHER_OPENED_ATTRIBUTE_VALUE = "ico_open"

    /**
     * root node selector
     */
    final static String ROOT_NODE_SELECTOR = "ul[@class='ztree']/li[@class='level0']"

    /**
     * node element tag name
     */
    final static String NODE_SELECTOR = "a"

    /**
     * sub node container selector
     */
    final static String SUB_NODE_CONTAINER_SELECTOR = "ul/li"

    /**
     * container selector
     */
    String containerSelector = null

    /**
     * current tree container selector with default value
     */
    Tree() {
        containerSelector = "//$CONTAINER_TAG_NAME[@$CONTAINER_ATTRIBUTE_NAME='$CONTAINER_ATTRIBUTE_VALUE']"
    }

    /**
     * current grid container selector with custom value
     * @param selector
     */
    Tree(String selector) {
        containerSelector = selector
    }

    /**
     * click at a node
     * @param pathList node path,eg:[rootNodeText,firstNodeText,secondNodeText]
     */
    void clickNode(List<String> pathList) {
        String nodeSelector = getNodeSelector(pathList)
        assertNotNull("node selector of $pathList is exist", nodeSelector)
        click(nodeSelector)
    }

    /**
     * get node selector with node path list
     * @param pathList node path,eg:[rootNodeText,firstNodeText,secondNodeText]
     * @return the selector of node path
     */
    String getNodeSelector(List<String> pathList) {
        String nodeSelector = containerSelector
        if (pathList.size() > 0) {
            for (String nodeName in pathList) {
                if (nodeSelector)
                    if (!unfoldNode(nodeSelector))
                        return null
                nodeSelector = getSubNodeSelector("$nodeSelector/$SUB_NODE_CONTAINER_SELECTOR", nodeName)
            }
        }
        logger.debug("create node selector:$nodeSelector")
        return "$nodeSelector/$NODE_SELECTOR"
    }

    /**
     * get a sub node selector with displayed text of a node selector
     * @param nodeSelector father node selector
     * @param subNodeText displayed text of sub node
     * @return sub node selector
     */
    private String getSubNodeSelector(String nodeSelector, String subNodeText) {
        List<String> subNodeTexts = getTexts(nodeSelector)
        logger.debug("sub node texts:$subNodeTexts")
        int nodeIndex = subNodeTexts.indexOf(subNodeText)
        if (nodeIndex == -1)
            return null
        return nodeSelector + "[$nodeIndex]"
    }

    /**
     * unfold a father node
     * @param nodeSelector father node selector
     * @return if it is unfolded
     */
    boolean unfoldNode(String nodeSelector) {
        boolean hasSubNodes = false
        WebElement switcher = findElement("$nodeSelector/$SWITCHER_SELECTOR")
        if (switcher.getAttribute(SWITCHER_ATTRIBUTE_NAME).contains(SWITCHER_CLOSED_ATTRIBUTE_VALUE)) {
            switcher.click()
            hasSubNodes = true
        }
        return hasSubNodes
    }

}
