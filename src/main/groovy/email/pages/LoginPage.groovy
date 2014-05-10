package email.pages

import common.model.WebActions

import static org.hamcrest.core.StringContains.containsString
import static org.junit.Assert.assertThat

/**
 * email login page
 * Created by Assilzm on 2014/5/9.
 */
class LoginPage extends WebActions{

    /**
     * login page tilte
     */
    final static String LOGIN_PAGE_TITLE

    /**
     * email page tilte after login
     */
    final static String EMAIL_PAGE_TITLE

    /**
     * user name input element selector
     */
    final static String USER_NAME_ELEMENT_SELECTOR

    /**
     * password input element selector
     */
    final static String PASSWORD_ELEMENT_SELECTOR

    /**
     * auto login input element selector
     */
    final static String AUTO_LOGIN_ELEMENT_SELECTOR

    /**
     * submit button element selector
     */
    final static String SUBMIT_ELEMENT_SELECTOR

    /**
     *
     * @param userName username
     * @param password password
     * @param autoLogin is auto login
     */
    void login(String userName,String password,boolean autoLogin=false){
        assertThat("assert login page title contains $LOGIN_PAGE_TITLE",getTitle(),containsString(LOGIN_PAGE_TITLE))
        type(USER_NAME_ELEMENT_SELECTOR,userName)
        type(PASSWORD_ELEMENT_SELECTOR,password)
        if(autoLogin)
            selectCheckBox(AUTO_LOGIN_ELEMENT_SELECTOR)
        click(SUBMIT_ELEMENT_SELECTOR)
        assertThat("assert email page title contains $LOGIN_PAGE_TITLE",getTitle(),containsString(EMAIL_PAGE_TITLE))
    }
}
