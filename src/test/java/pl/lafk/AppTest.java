package pl.lafk;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit tests for simple App with powerful testing library.
 *
 * With annotated class, methods don't need annotation
 * as long as they're public void and as long as they don't return
 *
 * @see <a href="http://kaczanowscy.pl/tomek/2012-04/why-testng-and-not-junit">Why TestNG and not JUnit</a>
 * @see <a href="http://testng.org/doc/documentation-main.html">TestNG documentation</a>
 * @see <a href="http://testng.org/doc/idea.html">Intellij IDEA setup</a>
 * @see <a href="http://testng.org/doc/eclipse.html">Eclipse setup</a>
 */
@Test
public class AppTest {

    public void testA()
    {
        String expected = "TestNG";
        String actual = "TestNG";
        // yeah, that's NOT a mistake, order is actual -> expected
        Assert.assertEquals(actual, expected, "Order is actual, expected, not the other way around");
    }

    public void testB()
    {
        Assert.assertFalse(false == true);
    }

    /**
     * Non-noticed test - delete this quickly! Before someone sees!
     *
     * TODO: delete or mark in config that such tests are OK.
     */
    @Test
    public boolean testWithReturnIsIgnoredUnlessConfiguredOtherwise()
    {
        Assert.assertTrue( false == true, "False is not True");
        // return causes this test NOT to be noticed! Even with annotation.
        return true;
    }
}
