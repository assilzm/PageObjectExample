package email.component

import common.model.WebActions

/**
 *
 * @author Assilzm
 * @createTime 2014-5-10 11:26.
 */
class MailMenu extends WebActions{

    final static String SEND_MAIL_BUTTON_SELECTOR="SEND_MAIL_BUTTON_SELECTOR"

    final static String RECEIVE_MAIL_BUTTON_SELECTOR="RECEIVE_MAIL_BUTTON_SELECTOR"

    final static String FIRST_MENU_ELEMENT_SELECTOR="FIRST_MENU_ELEMENT_SELECTOR"

    final static String SECOND_MENU_ELEMENT_SELECTOR="SECOND_MENU_ELEMENT_SELECTOR"

    final static String IN_BOX_PENDING_ELEMENT_SELECTOR="IN_BOX_PENDING_ELEMENT_SELECTOR"



    void clickSendMailButton(){
        click(SEND_MAIL_BUTTON_SELECTOR)
    }

    void clickReceiveMailButton(){
        click(RECEIVE_MAIL_BUTTON_SELECTOR)
    }

    void clickMenu(String firstMenuText,String secondMenuText=null){
        click(getMenuSelector(FIRST_MENU_ELEMENT_SELECTOR,firstMenuText))
        if (secondMenuText)
            click(getMenuSelector(SECOND_MENU_ELEMENT_SELECTOR,secondMenuText))
    }

    int getInBoxPendingNumber(){
       return Integer.parseInt(getValue(IN_BOX_PENDING_ELEMENT_SELECTOR))
    }

    private String getMenuSelector(String selector,String menuText){
        return "$selector with text $menuText"
    }

}
