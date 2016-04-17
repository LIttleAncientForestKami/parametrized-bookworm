package pl.lafk;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Data providers are very useful for parametrised tests.
 * We annotate now test methods to indicate where the params come from.
 *
 * @author LAFK_pl, Tomasz.Borek@gmail.com
 */
public class AppParametrisedTest {

    // Provides data to any test method declaring Data Provider named "nameAndAge"
    @DataProvider(name = "nameAndAge")
    public Object[][] nameIrrelevant() {
        return new Object[][]{
                {"Cedric", 36},
                {"Anne", 37},
                {"Tommy", 8},
                {"Seoman", 18}, // who remembers Seoman Snowlock?
                {"Miriamele", 19}  // hint perhaps?
         };
    }

    @Test(dataProvider = "nameAndAge")
    public void verifyData1(String name, Integer age) {
        System.out.println(name + " " + age);
    }

    @Test(dataProvider = "nameAndAge")
    public void verifyData1Again(String name, Integer age) {
        Assert.assertNotNull(name, "Name null for " + name + age);
        Assert.assertNotNull(age, "Age null for " + name + age);
    }

    @Test(dataProvider = "nameAndAge")
    public void verifyData1LastTime(String name, Integer age) {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(age > 18, name + " not of age in Europe!");
        soft.assertTrue(age > 21, name + " not of age in US!");
        soft.assertAll();
    }
}
