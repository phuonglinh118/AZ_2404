package Method;
import org.testng.annotations.DataProvider;

public class DpGetDataFromObject {
    @DataProvider (name = "listSkuReceipt",parallel = true)
    public static Object[][] listSKUCreateReceipt (){

        return new Object[][] {{"100390034"},{"100390034"},{"100390034"}};
    }
    @DataProvider (name = "listStore",parallel = true)
    public static Object[][] listStorePushShippingCompany (){

        return new Object[][] {{"SHOP-4 30 THANG 4"},{"SHOP-1134 KHA VAN CAN"},{"SHOP-39 NGUYEN VAN TANG"},{"SHOP-513 PHU RIENG DO"},{"SHOP-217 NGUYEN VAN CU"},
                {"SHOP-517 PHU LOI"},{"SHOP-723 CACH MANG THANG 8"}, {"SHOP-40 BACH MAI "}, {"SHOP-137 NGUYEN TRAI"}, {"SHOP-17 PHAN HUY ICH"},
                {"SHOP-113 LUONG KHANH"},{"SHOP-232 PHAN BOI CHAU"},{"SHOP-30 PHAN DINH PHUNG"},{"SHOP-219 NGUYEN THI THAP"},{"SHOP-112 TRAN NAO"},
                {"SHOP - 555 3 THANG 2"},{"SHOP - 176 PHAN DANG LUU"},{"SHOP - 311 TAY THANH"},{"SHOP - 182 CAU GIAY"},{"SHOP - 96 YJUT"},{"SHOP - 177 BA CU"}};
        // //SHOP-137 NGUYEN TRAI //SHOP-1134 KHA VAN CAN //SHOP-39 NGUYEN VAN TANG //SHOP-513 PHU RIENG DO //SHOP-217 NGUYEN VAN CU //SHOP-217 NGUYEN VAN CU //	SHOP-517 PHU LOI
        //SHOP-723 CACH MANG THANG 8 //	SHOP-30 PHAN DINH PHUNG //SHOP-113 LUONG KHANH
        //SHOP - 555 3 THANG 2 // SHOP-232 PHAN BOI CHAU //SHOP-17 PHAN HUY ICH // SHOP - 176 PHAN DANG LUU //SHOP-219 NGUYEN THI THAP //SHOP-40 BACH MAI //SHOP-112 TRAN NAO
    }

}
