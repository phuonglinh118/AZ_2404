package Scripts;
import java.util.Locale;

import static Method.Methods.*;
import static TestCases.TC_Bin.*;

public class Script_Bin {
    public void check() throws Exception {
        String url, coin, listCoins, amount;
        amount = "50";
        int n= 100;
        listCoins = "EGLD ARB GRT SEI KLAY SAND MATIC HOT RONIN ENS SFP XEM SSV";
        for (int i = 1; i<n; i++){
            coin = subStringPrefix(listCoins," ");
            listCoins = listCoins.trim();
            if(listCoins.length()>0){
                listCoins = subStringSuffix(listCoins, coin);
                url = "https://www.binance.com/futures/"+coin+"USDT";
                Navigator_Web(url);
                longCoin(amount);
            }
            else {
                url = "https://www.binance.com/futures/"+coin+"USDT";
                Navigator_Web(url);
                i = n;
            }


        }



    }
}
