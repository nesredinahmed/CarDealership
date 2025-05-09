import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UserInterface{
    private final Dealership dealership;
    BufferedReader in;
    UserInterface(Dealership dealership){
        this.dealership = dealership;
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }
    void display() {
        String command = "";
        while (!command.equalsIgnoreCase("x")) {
            System.out.println("""
                    MAIN MENU:
                        Search By:
                            a) all
                            p) price
                            m) make and model
                            y) year
                            c) color
                            o) odometer miles
                            t) type (e.g. sedan)
                            +) add
                            -) remove
                            x) e(x)it
                    """);
            command = null;
            try {
                command = in.readLine().toLowerCase().trim();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            switch (command) {
                case "a" -> processGetAllVehiclesRequest();
                case "p" -> processGetByPriceRequest();
                case "m" -> processGetByMakeModelRequest();
                case "y" -> processGetByYearRequest();
                case "c" -> processGetAllVehiclesRequest();
                case "o" -> processGetAllVehiclesRequest();
                case "t" -> processGetAllVehiclesRequest();
                case "+" -> processGetAllVehiclesRequest();
                case "-" -> processGetAllVehiclesRequest();
                case "x" -> System.out.println("Thanks!");
                default -> System.out.println("Invalid Command");
            }
        }
    }
    void processGetAllVehiclesRequest(){
        var list = this.dealership.getAllVehicles();
        if(list.size() == 0){
            System.out.println("None Found.");
            return;
        }
        for(Vehicle v : list){
            System.out.println(v);
        }
    }
    int getInt(String name){
        System.out.printf("%s: ", name);
        Integer value = null;
        while(value==null) {
            try {
                value = Integer.parseInt(in.readLine().toLowerCase().trim());
            } catch (IOException e) {
                System.out.println("Try Again:");
            }
        }
        return value;
    }
    String getString(String name){
        System.out.printf("%s: ", name);
        String value = null;
        while(value==null) {
            try {
                value = in.readLine();
            } catch (IOException e) {
                System.out.println("Try Again:");
                value = null;
                continue;
            }

            if(value.trim().isEmpty()){
                System.out.println("Try Again:");
                value = null;
            }
        }
        return value;
    }
    void processGetByPriceRequest(){
        var list = this.dealership.getVehiclesByPrice(
                getInt("Minimum"),
                getInt("Maximum")
        );

        if(list.size() == 0){
            System.out.println("None Found.");
        }

        for(Vehicle v : list){
            System.out.println(v);
        }
    }
    void processGetByYearRequest(){
        var list = this.dealership.getVehiclesByYear(
                getInt("Minimum Year"),
                getInt("Maximum Year")
        );

        if(list.size() == 0){
            System.out.println("None Found.");
        }

        for(Vehicle v : list){
            System.out.println(v);
        }
    }
    void processGetByMakeModelRequest(){
        var list = this.dealership.getVehiclesByMakeModel(
                getString("Make"),
                getString("Model")
        );

        if(list.size() == 0){
            System.out.println("None Found.");
        }

        for(Vehicle v : list){
            System.out.println(v);
        }
    }

}