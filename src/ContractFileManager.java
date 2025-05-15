import java.util.ArrayList;
import java.util.Date;

public class ContractFileManager {
    //methods;

    public ArrayList<BusinessContract> load(){
        //heterogeneous has more than one kind of contract
        ArrayList<BusinessContract> list = new ArrayList<>();

        //loop through lines
        String line = ""; //read this
        BusinessContract bc = parseContract(line);
        list.add(bc);
        //end loop

        return list;
    } //read

    public void save(ArrayList<BusinessContract> list){
        for(BusinessContract c : list){
            System.out.println("SAVING: " + c);
            String line = getContractString(c);
            System.out.println(line);
            //TODO WRITE TO FILE
        }
    } //write

    BusinessContract parseContract(String data){

        int CONTRACT_TYPE = 0; // LEASE|
        int CONTRACT_DATE = 1; // 20210928|
        int CUSTOMER_NAME = 2; // Zachary Westly|
        int CUSTOMER_EMAIL = 3; // zach@texas.com|

        /* ** VEHICLE ** */
        int VIN = 4;// 37846|
        int YEAR = 5;// 2021|
        int MAKE = 6;// Chevrolet|
        int MODEL = 7;// Silverado|
        int TYPE = 8;// truck|
        int COLOR = 9;// Black|
        int MILES = 10;// 2750|
        int PRICE = 11;// 31995.00|

        /* ** END VEHICLE ** */

        /* LEASE */
        int EXPECTED_ENDING_VALUE = 12; // 15997.50|
        int LEASE_FEE = 13; // 2239.65|
        int COMBINED = 14; // 18337.15|
        int MONTHLY_LEASE = 15; // 541.3 //Rounded down? Math.floor()

        /* SALES */
//        SALE|20210928|Dana Wyatt|dana@texas.com|10112|1993|Ford|Explorer|SUV|Red|525123|995.00|
        int SALES_TAX_AMOUNT = 12; //49.75|
        int RECORDING_FEE =13;// 100.00|
        int PROCESSING_FEE = 14; //processingFee 295.00|
        int TOTAL_AMOUNT = 15; // 1439.75| 11 12 13 14 together
        int IS_FINANCED = 16; //NO|
        int MONTHLY_PAYMENT = 17; //0.00

        //TODO SPLIT ON PIPE TO GET AN ARRAY
        //COPY ARRAY VALUES INTO VARIABLES AND VEHICLE OBJECT
//        if(isLeaseContract){
//            new LeaseContract()
//        }else if(isSalesContract){
//            new SalesContract()
//        }

        return new SalesContract(new Vehicle(123), new Date(),
                "Kevin Ernest Long",
                "kevinelong@gmail.com",
                true,
                10000.00,
                500.00,
                0,
                0,
                true);
    }

    String getContractString(BusinessContract bc){
        //TODO Glue with PIPES ||||
        return "";
    }

    public static void main(String[] args) {
        // test
        ContractFileManager cfm = new ContractFileManager();

        BusinessContract bc1 = cfm.parseContract("SALE|20210928|Dana Wyatt|dana@texas.com|10112|1993|Ford|Explorer|SUV|Red|525123|995.00|49.75|100.00|295.00|1439.75|NO|0.00");
        System.out.println(bc1);

        BusinessContract bc2 = cfm.parseContract("LEASE|20210928|Zachary Westly|zach@texas.com|37846|2021|Chevrolet|Silverado|truck|Black|2750|31995.00|15997.50|2239.65|18337.15|541.3");
        System.out.println(bc2);

//        ArrayList<BusinessContract> list = cfm.load();
//        for(BusinessContract bc : list){
//            System.out.println(bc);
//        }
    }
}
