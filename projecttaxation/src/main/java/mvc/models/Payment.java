package mvc.models;

import mvc.models.persons.Person;
import mvc.models.persons.PrivateIndividual;
import mvc.models.taxes.Tax;
import mvc.models.taxes.TaxesOfIndividuals;

import java.util.Date;

public class Payment implements Comparable<Payment> {
    private Person payer;
    private Tax tax;
    private Date dateOfPayment;
    private double amountOfPayment;

    public Payment(Person payer, Tax tax, Date dateOfPayment) {
        this.payer = payer;
        this.tax = tax;
        this.dateOfPayment = dateOfPayment;
        amountOfPayment = tax.setAmountOfPayment(tax.getPurposeOfPayment());
    }

    public Payment(Person payer, Tax tax, Date dateOfPayment, double amountOfPayment) {
        this.payer = payer;
        this.tax = tax;
        this.dateOfPayment = dateOfPayment;
        this.amountOfPayment = amountOfPayment;
    }

    public Person getPayer() {
        return payer;
    }

    public Tax getTax() {
        return tax;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public double getAmountOfPayment() {
        return amountOfPayment;
    }

    @Override
    public int compareTo(Payment payment) {
        return (int)(this.getAmountOfPayment() - payment.getAmountOfPayment() == 0 ? this.getAmountOfPayment() + 1 + payment.getAmountOfPayment() : this.getAmountOfPayment() - payment.getAmountOfPayment());
    }
}
