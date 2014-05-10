package email.pages

import common.model.WebActions
import email.component.SearchCondition
import email.component.Tab
import email.component.ToolBar

/**
 * main frame
 * @author Assilzm
 * @createTime 2014-5-10 11:23.
 */
abstract class MainFrame extends WebActions{

    /**
     * email page tilte after login
     */
    final static String EMAIL_PAGE_TITLE="EMAIL_PAGE_TITLE"

    /**
     * toolBar
     */
    ToolBar toolBar=new ToolBar()
    /**
     * tab
     */
    Tab tab=new Tab()

    /**
     * searchCondition
     */
    SearchCondition searchCondition=new SearchCondition()
}
