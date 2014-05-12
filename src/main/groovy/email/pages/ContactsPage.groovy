package email.pages

import email.component.Grid

/**
 * contacts page
 * @author Assilzm
 * createTime 2014-5-12.
 */
class ContactsPage extends MainFrame{

    /**
     * conent frame path
     */
    final static String FRAME="frame"

    /**
     * grid component
     */
    Grid grid

    /**
     * init component with getter
     * @return
     */
    Grid getGrid(){
        switchFrame(FRAME)
        return new Grid()
    }
}
