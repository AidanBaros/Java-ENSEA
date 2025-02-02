package Homework;

import java.util.ArrayList;

public class Customer {
    
    private String firstName;
    private String email;
    private double fidelityPoint;
    private double totalAmountInDollars;

    private static ArrayList<Customer> allCustomers = new ArrayList<>();

    public Customer(String firstName, String email){
        this.firstName = firstName;
        this.email = email;
        this.fidelityPoint = 0;
        this.totalAmountInDollars = 0;
        allCustomers.add(this);
    }
    @SuppressWarnings({"removal"})
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Customer object with name [" + firstName + "] is about to be garbage collected.");
        super.finalize();
    }

    @Override
    public String toString(){
        return "First Name: " + firstName + "\n"
            + "Email: " + email + "\n"
            + "Fidelity Points: " + fidelityPoint + "\n"
            + "Total Amount in Dollars: " + totalAmountInDollars;
    }

    public void registerNewSale(int amountSpent){
        totalAmountInDollars += amountSpent;
        fidelityPoint += amountSpent * 0.81;
    }

    public static void totalCustomers(){
        System.out.println("Total customers in the list: " + allCustomers.size());
    }

    public static void totalSpend(){
        double totalSpent = 0;
        for (Customer customer : allCustomers){
            totalSpent += customer.totalAmountInDollars;
        }
        System.out.println("Total spent by all customers: $" + totalSpent);
    }

    public static void main(String[] args) {
        {
            Customer c1 = new Customer("John", "john@example.com");
            Customer c2 = new Customer("Jane", "jane@example.com");

            System.out.println("Created c1 and c2:");
            totalCustomers();

            c1.registerNewSale(100);
            c2.registerNewSale(200);
            totalSpend();

            System.out.println("\nClearing the static list to remove references...");
            totalCustomers();
            allCustomers.clear();
            c1 = null;
            c2 = null;
        }

        System.out.println("\nRequesting garbage collection...");
        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End");
    }
}

