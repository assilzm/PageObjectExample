package email.pages

import org.junit.Test
import sun.security.util.Password

import static org.hamcrest.core.StringContains.containsString
import static org.hamcrest.core.StringContains.containsString
import static org.junit.Assert.assertThat
import static org.junit.Assert.assertThat

/**
 *
 * @author Assilzm
 * createTime 2014-5-10 12:59.
 */
class LoginPageTest {


    String userName="userName"
    String password="password"

    @Test
    void testLogin() {
        LoginPage loginPage=new LoginPage()
        assertThat("assert login page title contains $loginPage.LOGIN_PAGE_TITLE",loginPage.getTitle(),containsString(loginPage.LOGIN_PAGE_TITLE))
        loginPage.login(userName,password)
        HomePage homePage=new HomePage()
        assertThat("assert email page title contains $homePage.EMAIL_PAGE_TITLE",homePage.getTitle(),containsString(homePage.EMAIL_PAGE_TITLE))
    }
}
