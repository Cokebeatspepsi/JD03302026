import entities.BankAccount;
import entities.SavingsAccount;
import entities.CheckingAccount;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> listOfAccounts = List.of(
                new SavingsAccount("12930",new BigDecimal("321.21"),new BigDecimal("4.2")),
                new SavingsAccount("32429",new BigDecimal("321.21"),new BigDecimal("6.2")),
                new CheckingAccount("56489", new BigDecimal("789.23"),new BigDecimal("15.00"))
        );
        System.out.println(listOfAccounts.get(0).equals(listOfAccounts.get(0)));
    }
}
