package ex00;

import java.util.UUID;

public class Transaction {
    enum    Operation   {debit, credit };
    private final UUID  ID;
    private final User  RECIPIENT;
    private final User  SENDER;
    private final int   AMOUNT;

    public Transaction(User recipient, User sender, Operation type, int amount) {
        this.RECIPIENT = recipient;
        this.SENDER = sender;
        this.ID = UUID.randomUUID();

        if (amount > 0 && ((type == Operation.debit && recipient.getBalance() > amount) ||
        (type == Operation.credit && recipient.getBalance() > (-1) * amount)))
        {
            this.AMOUNT = amount;
            setBalance(RECIPIENT, SENDER, AMOUNT);
        }
        else
            this.AMOUNT = 0;
    }

    public UUID getId() {
        return ID;
    }

    public User getRecipient() {
        return RECIPIENT;
    }

    public User getSender() {
        return SENDER;
    }

    public int getAmount() {
        return AMOUNT;
    }

    public void setBalance(User recipient, User sender, int amount) {
        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);
    }

    public void printTransactionInfo() {
        System.out.format("%s -> %s, -%d, OUTCOME, %s\n",
                getSender().getName(), getRecipient().getName(), getAmount(), getId());
        System.out.format("%s -> %s, +%d, INCOME, %s\n",
                getRecipient().getName(), getSender().getName(), getAmount(), getId());
    }
}
