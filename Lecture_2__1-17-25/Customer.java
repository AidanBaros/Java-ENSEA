import java.util.ArrayList;

public class Customer {
    
    private String firstName;
    private String email;
    private double fidelityPoint;
    private double totalAmountInDollars;

    private static ArrayList<Customer> allCustomers = new ArrayList<Customer>();

    public Customer(String firstName, String email){
        this.firstName = firstName;
        this.email = email;
        this.fidelityPoint = 0;
        this.totalAmountInDollars = 0;

        allCustomers.add(this);
    }

    public String toString(){
        return(
            "First Name:" + firstName + "\n" +
            "Email:" + email + "\n" +
            "Fidelity Points:" + fidelityPoint + "\n" +
            "Total amount in Dollars:" + totalAmountInDollars
            );
    }

    public void registerNewSale(int amountSpent){
        totalAmountInDollars += amountSpent;
        fidelityPoint += amountSpent*.81;
    }

    public static void totalCustomers(){
        System.out.println(allCustomers.size());
    }

    public static void totalSpend(){
        double totalSpent = 0;

        for (Customer customer: allCustomers){
            totalSpent += customer.totalAmountInDollars;
        }

        System.out.println(totalSpent);
    }

}
