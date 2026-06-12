package doc.kub.cli;

import java.util.Scanner;

import doc.kub.cli.api.PatientAPI;
import doc.kub.cli.model.Patient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        PatientAPI dao = new PatientAPI();

        while(true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1.Add Patient");
            System.out.println("2.View Patients");
            System.out.println("3.Delete Patient");
            System.out.println("4.Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    sc.nextLine();

                    System.out.println("Name:");
                    String name =
                        sc.nextLine();

                    System.out.println("Age:");
                    int age =
                        sc.nextInt();

                    sc.nextLine();

                    System.out.println("Gender:");
                    String gender =
                        sc.nextLine();

                    System.out.println("BMI:");
                    double bmi =
                        sc.nextDouble();

                    dao.addPatient(
                        new Patient(
                            name,
                            age,
                            gender,
                            bmi));

                    break;

                case 2:
                    dao.getAllPatients();
                    break;

                case 3:

                    System.out.println(
                        "Enter ID:");

                    int id =
                        sc.nextInt();

                    dao.deletePatient(id);

                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
