package email.pages

import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

/**
 *
 * @author Assilzm
 * createTime 2014-5-10 13:47.
 */
class HomePageTest {

    int EXPECTED_PENDING_NUMBER=0

    @Test
    void testGetInBoxPendingNumber(){
        HomePage homePage=new HomePage()
        int actualPendingNumber=homePage.mailMenu.getInBoxPendingNumber()
        assertThat("assert in box pending number is $EXPECTED_PENDING_NUMBER",actualPendingNumber,equalTo(EXPECTED_PENDING_NUMBER))
    }
}
