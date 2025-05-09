
class Vehicle {
    int vin; //NOT A STRING?
    int year;
    String make;
    String model;
    String vehicleType;
    String color;
    int odometer;
    double price;

    Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    Vehicle(int vin) { //OVERLOADED CONSTRUCTOR
        this.vin = vin; //assign value from parameter to property
    }

    public String toString() {
        return String.format("VIN: '%d'\nYEAR: '%d'\nMAKE: '%s'\nMODEL: '%s'\n",
                this.vin, this.year, this.make, this.model);
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle(123, 1999, "MAZDA", "MX-5", "ROADSTER", "WHITE", 128_000, 5_000);
        Vehicle v2 = new Vehicle(456, 2008, "HYUNDAI", "ELANTRA GT", "ROADSTER", "BLANK", 111_000, 10_000);
        System.out.println(v);
        System.out.println(v2);
    }
}