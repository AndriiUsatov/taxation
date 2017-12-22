package mvc.models.taxes;

import mvc.models.MinSalary;

public class TaxesOfIndividuals implements Tax {
    private int purposeOfPayment;
    private double amountOfIncome;

    public TaxesOfIndividuals(int purposeOfPayment) {
        this.purposeOfPayment = purposeOfPayment;
    }

    public TaxesOfIndividuals(int purposeOfPayment, double amountOfIncome) {
        this.purposeOfPayment = purposeOfPayment;
        this.amountOfIncome = amountOfIncome;
    }


    public int getPurposeOfPayment() {
        return purposeOfPayment;
    }


    public double setAmountOfPayment(int taxNumber) {
        double amountOfPayment = 0;
        switch (taxNumber) {
            case 1:
                amountOfPayment = amountOfIncome > MinSalary.getMinSalary() ? amountOfIncome * 0.18 : MinSalary.getMinSalary() * 0.18;
                break;
            case 2:
                amountOfPayment = amountOfIncome * 0.18;
                break;
            case 3:
                amountOfPayment = amountOfIncome * 0.015;
                break;
            case 4:
                amountOfPayment = amountOfIncome * 0.18;
                break;
            case 5:
                amountOfPayment = amountOfIncome > 2240 ? (amountOfIncome - 2240) * 0.18 : 0;
                break;
            case 6:
                amountOfPayment = amountOfIncome * 0.18;
                break;
            case 7:
                amountOfPayment = amountOfIncome * 0.05;
                break;
            case 8:
                amountOfPayment = amountOfIncome * 0.18;
                break;
            case 9:
                amountOfPayment = amountOfIncome * 0.05;
                break;

        }
        return amountOfPayment;
    }

}
