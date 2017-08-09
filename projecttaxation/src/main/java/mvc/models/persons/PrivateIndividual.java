package mvc.models.persons;


import mvc.models.persons.Person;

public class PrivateIndividual implements Person {
    private String firstName;
    private String secondName;
    private String middleName;
    private String fullName;
    private final String idNumber;

    public PrivateIndividual(String fullName, String idnumber){
     this.fullName = fullName;
     this.idNumber = idnumber;
    }

    public PrivateIndividual(String firstName, String secondName, String middleName, String idNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.idNumber = idNumber;
        fullName = secondName + " " + firstName + " " + middleName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIDNumber() {
        return idNumber;
    }
}
