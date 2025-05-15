import java.util.Date;

// abstract - CANT CREATE *NEW* INSTANCES DIRECTLY, ONLY OF ITS DESCENDANTS
abstract class BusinessContract {
    private Date date;
    private String customerName;
    private String customerEmail;
    private boolean isSold;
    private double totalPrice;
    private double monthlyPayment;

    BusinessContract(
            Date date,
            String customerName,
            String customerEmail,
            boolean isSold,
            double totalPrice,
            double monthlyPayment
    ) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.isSold = isSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }
    public String toString(){
        return String.format("""
                %s
                %s
                %s
                %s
                %.2f
                %.2f
                """,
                this.date,
                this.customerName,
                this.customerEmail,
                this.isSold,
                this.totalPrice,
                this.monthlyPayment
        );
    }
    public Date getDate(){
        return this.date;
    }
    public String getCustomerName(){
        return this.customerName;
    }
    public String getCustomerEmail(){
        return this.customerEmail;
    }
    public boolean isSold(){
        return this.isSold;
    }
    abstract double getTotalPrice();
    abstract double getMonthlyPayment();

//    public static void main(String[] args) {
//        //TEST FOR THIS CLASS ONLY
//        BusinessContract bc = new BusinessContract(
//                new Date(),
//                "Kevin Ernest Long",
//                "kevinelong@gmail.com",
//                true,
//                10000.00,
//                500.00
//        );
//        System.out.println(bc);
//    }
}
