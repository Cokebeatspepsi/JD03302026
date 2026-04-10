package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class SavingsAccount extends BankAccount implements Transferable{
   private BigDecimal interestRate;

    public SavingsAccount(String accountNumber, BigDecimal balance, BigDecimal interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void applyMonthlyFee();{
        applyInterest();
    }
    @Override
    public void transfer(BigDecimal amount,String toAccountNumber){
        withdraw(amount);

    }
    public void applyInterest(BigDecimal interestRate){
        BigDecimal interest = (super.getBalance().multiply(interestRate)
                .divide(new BigDecimal("100"), RoundingMode.HALF_EVEN));
        super.getBalance().add(interest);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SavingsAccount that = (SavingsAccount) o;
        return Objects.equals(interestRate, that.interestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(interestRate);
    }

    public BigDecimal getBalance() {return null;}
    public BigDecimal getInterest(){return interestRate;}
}
