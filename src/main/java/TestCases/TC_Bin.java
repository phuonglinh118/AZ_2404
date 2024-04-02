package TestCases;

import static Locator.Loc_Bin.*;

import Locator.Loc_Bin;
import Locator.Loc_Bin.*;

import static Method.Methods.*;

public class TC_Bin {
    public static void longCoin (String amount) throws Exception {
        click(TAB_MARKET);
        Thread.sleep(500);
        sendKey(INPUT_AMOUNT_FUTURE,amount);
        Thread.sleep(2000);
        click(BTN_LONG);
        Thread.sleep(4000);
    }
    public static void updateCrossValue (String valueCross) throws Exception {
        String cross = getString(VALUE_CROSS);
        if (Integer.valueOf(valueCross) == Integer.valueOf(valueCross)){

        }

    }
}
