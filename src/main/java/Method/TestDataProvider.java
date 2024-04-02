package Method;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataProvider {
    @Test(dataProvider= "abc", dataProviderClass = DataProvider.class)
    public void test (int a, int b, int result){
        int sum = a+b;
        Assert.assertEquals(result, sum);
    }
}
