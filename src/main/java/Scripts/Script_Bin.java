package Scripts;
import org.testng.annotations.Test;

import java.util.Locale;

import static Method.Methods.*;
import static TestCases.TC_Bin.*;

public class Script_Bin extends Setup.LoginBin{
    @Test
    public void check() throws Exception {
        String url, coin, listCoins, amount;
        amount = "50";
        int n= 100;
        listCoins = "EGLD ARB GRT SEI KLAY SAND MATIC HOT RONIN ENS SFP XEM SSV";
        for (int i = 1; i<n; i++){
            if(listCoins.length()>0 && listCoins.contains(" ")){
                coin = subStringPrefix(listCoins," ");
                System.out.println(i + " - " + coin);
                listCoins = subStringSuffixAddIndex(listCoins, coin);
                listCoins = listCoins.trim();
//                listCoins = subStringSuffix(listCoins, coin);
                url = "https://www.binance.com/futures/"+coin+"USDT";
                Navigator_Web(url);
                Thread.sleep(3000);
                //longCoin(amount);
            }
            else {
                if(listCoins.length()>0 && listCoins.contains(" ") == false){
                    url = "https://www.binance.com/futures/"+listCoins+"USDT";
                    Navigator_Web(url);
                    System.out.println(i + " - " + listCoins);
                    Thread.sleep(3000);
                    i = n;
                }
            }


        }



    }
}
