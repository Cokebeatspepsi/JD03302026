package entities;

import java.math.BigDecimal;
import java.util.Objects;

public class CheckingAccount extends BankAccount {
    private BigDecimal monthlyFee;

    public CheckingAccount(String accountNumber,BigDecimal balance,BigDecimal monthlyFee) {
        super(accountNumber,balance);
        this.monthlyFee = monthlyFee;

    }
    public void applyMonthlyFee(BigDecimal monthlyFee){
        this.monthlyFee = monthlyFee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CheckingAccount that = (CheckingAccount) o;
        return Objects.equals(monthlyFee, that.monthlyFee);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(monthlyFee);
    }
}
