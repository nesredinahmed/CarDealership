import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class DealershipFileManager {
    Dealership getDealership() {
        File f = new File("dealership.csv");
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

        //MORE LINES - ADD VEHICLE
        int vin; //NOT A STRING?
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        return dealership;
    }

    void saveDealership(Dealership dealership) {
        //write first line - dealer info

        //write line - per vehicle
    }
}