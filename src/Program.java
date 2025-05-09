class Program{
    public static void main(String[] args) {
        var manager = new DealershipFileManager();
        var dealer = manager.getDealership();
        var ui = new UserInterface(dealer);
        ui.display();;
    }
}