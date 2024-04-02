package Method;
import static Method.Methods.*;

public class CustomFunctions {
    public static int countMonthRemain (String date) throws Exception {
//        String inputMonth, inputYear;
        int remainMonth, systemMonth, systemYear, inputMonth, inputYear;
        systemMonth = Integer.parseInt(getSystemMonth());
        systemYear = Integer.parseInt(getSystemYear());
        inputMonth = Integer.parseInt(subStringSuffix(date, "-"));
        inputYear = Integer.parseInt(subStringPrefix(date, "-"));
        remainMonth = 0;
        if(inputYear==systemYear){
            remainMonth = inputMonth - systemMonth + 1;
        }
        else {
            if(inputYear - systemYear == 1){
                remainMonth = inputMonth + (12 - systemMonth) + 1;
            }
            else {
                if(inputYear - systemYear > 1) {
                    remainMonth = inputMonth + (12 - systemMonth) + (inputYear -  1) * 12 + 1;
                }
            }
        }
        return remainMonth;
    }
}
