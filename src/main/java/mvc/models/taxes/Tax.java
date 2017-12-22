package mvc.models.taxes;

public interface Tax {
    double setAmountOfPayment(int taxNumber);

    int getPurposeOfPayment();
}
