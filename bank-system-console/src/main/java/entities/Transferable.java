package entities;

import java.math.BigDecimal;
public interface Transferable {
    void transfer(BigDecimal amount, String accountNumber);

    BigDecimal getBalance();
    default canTransfer(BigDecimal amount) {
        return getBalance().compareTo(amount)<=0;
    }


    }



