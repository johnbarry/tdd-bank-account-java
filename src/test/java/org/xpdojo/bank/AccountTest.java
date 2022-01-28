package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.xpdojo.bank.Account.emptyAccount;

public class AccountTest {

    @Test
    public void InitialAmount_shouldHaveZeroBalance() {
        assertThat(emptyAccount().balance()).isEqualTo(0);
    }
    @Test
    public void SingleDeposit_shouldReflectInBalance() {
        assertThat(emptyAccount()
                .deposit(10)
                .balance()).isEqualTo(10);
    }
    @Test
    public void MultipleDeposits_shouldReflectInBalance() {
        assertThat(emptyAccount()
                .deposit(10)
                .deposit(20)
                .deposit(30)
                .balance())
                .isEqualTo(60);
    }
    @Test
    public void SingleWithdrawal_shouldReflectInBalance() throws IntoOverdraftException {
        assertThat(emptyAccount()
                .deposit(100)
                .withdraw(20)
                .balance()
        ).isEqualTo(80);
    }
    @Test
    public void WithdrawalMoreThanBalance_shouldNotBeAllowed() {
        assertThatExceptionOfType(IntoOverdraftException.class)
                .isThrownBy(() -> emptyAccount()
                        .deposit(100)
                        .withdraw(120));
    }
}
