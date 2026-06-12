package doc.kub.cli.model;

public class Patient {

    private int patientId;
    private String patientName;
    private int age;
    private String gender;
    private double bmi;

    public Patient() {
    }

    public Patient(String patientName,
                   int age,
                   String gender,
                   double bmi) {

        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.bmi = bmi;
    }

    public double getBmi() {
        return bmi;
    }
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}