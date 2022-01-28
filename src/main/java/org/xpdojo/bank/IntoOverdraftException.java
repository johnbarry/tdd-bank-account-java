package org.xpdojo.bank;

public class IntoOverdraftException extends Exception{
    public int balanceBefore;
    public int withdrawal;

    public IntoOverdraftException(int balanceBefore, int withdrawal) {
        this.balanceBefore = balanceBefore;
        this.withdrawal = withdrawal;
    }
}
