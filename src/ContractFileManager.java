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
}
