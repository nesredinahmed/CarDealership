import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class DealershipFileManager {
    Dealership getDealership() {
        String path = System.getProperty("user.dir");
        File f = new File(path + "\\dealership.csv");
        FileReader fr;
        try {
            fr = new FileReader(f);
        } catch (Exception e) {
            System.out.println("Error reading file");
            return null;
        }
        BufferedReader br = new BufferedReader(fr);

        //READ FIRST LINE
        String firstLine = null;
        try {
            firstLine = br.readLine();
        } catch (IOException e) {
            System.out.println("Error reading file");
            return null;
        }
        String[] data = firstLine.split("\\|");
        int NAME = 0;
        int ADDRESS = 1;
        int PHONE = 2;

        String name = data[NAME];
        String address = data[ADDRESS];
        String phone = data[PHONE];

        Dealership dealership = new Dealership(name, address, phone);
        try {
            String line = br.readLine();
            while (line != null){
                int VIN = 0;
                int YEAR = 1;
                int MAKE = 2;
                int MODEL = 3;
                int TYPE = 4;
                int COLOR = 5;
                int MILES = 6;
                int PRICE = 7;
                data = line.split("\\|");
                //MORE LINES - ADD VEHICLE
                int vin = Integer.parseInt(data[VIN]); //NOT A STRING?
                int year = Integer.parseInt(data[YEAR]);
                String make = data[MAKE];
                String model = data[MODEL];
                String vehicleType = data[TYPE];
                String color = data[COLOR];
                int odometer = Integer.parseInt(data[MILES]);
                double price = Float.parseFloat(data[PRICE]);
                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(v);
                line = br.readLine();
            }
        }catch (Exception e){
            System.out.println("Error reading vehicles");
        }
        return dealership;
    }

    void saveDealership(Dealership dealership) {
        //write first line - dealer info

        //write line - per vehicle
    }

    public static void main(String[] args) {
        DealershipFileManager dfm = new DealershipFileManager();
        Dealership d = dfm.getDealership();
    }
}