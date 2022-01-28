package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.xpdojo.bank.Account.emptyAccount;

public class AccountTest {

    @Test
    public void initialAmount_shouldHaveZeroBalance() {
        assertThat(emptyAccount().balance()).isEqualTo(0);
    }
    @Test
    public void addDeposit_shouldReflectInBalance() {
        assertThat(emptyAccount()
                .deposit(10)
                .balance()).isEqualTo(10);
    }
    @Test
    public void addMultipleDeposits_shouldReflectInBalance() {
        assertThat(emptyAccount()
                .deposit(10)
                .deposit(20)
                .deposit(30)
                .balance())
                .isEqualTo(60);
    }
}
