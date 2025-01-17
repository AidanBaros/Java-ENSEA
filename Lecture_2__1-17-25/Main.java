public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        for (String arguments: args){
            System.out.println(arguments);
        }

        
        Customer bob = new Customer("Bob", "Bob@hotmail.com");
        Customer tim = new Customer("Tim", "Tim@hotmail.com");
        bob.registerNewSale(10);
        tim.registerNewSale(7);

        Customer.totalCustomers();
        Customer.totalSpend();
    }
}

