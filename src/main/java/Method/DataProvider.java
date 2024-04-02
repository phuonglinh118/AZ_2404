package Method;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "abc")
    public Object[][]  dpMethod(Method m){
        switch (m.getName()){
            case "sum":
                return new Object[][] {{1,2,3},{4,5,6}};
            case "Diff":
                return new Object[][] {{8,8,0},{8,9,9}};
        }
        return null;
    }
    @Test (dataProvider = "abc")
    public void sum(int a, int b, int result){
        int sum = a+b;
        Assert.assertEquals(result, sum);
    }
    @Test (dataProvider = "abc")
    public void Diff(int a, int b, int result){
        int diff = a-b;
        Assert.assertEquals(result, diff);
    }
}
