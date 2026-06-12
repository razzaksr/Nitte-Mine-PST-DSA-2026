package doc.kub.cli.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import doc.kub.cli.DbConnection;
import doc.kub.cli.model.Patient;

public class PatientAPI {
    public void addPatient(Patient patient) {

        String sql =
            "INSERT INTO patients " +
            "(patient_name,age,gender,bmi) " +
            "VALUES(?,?,?,?)";

        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1,patient.getPatientName());

            ps.setInt(2, patient.getAge());

            ps.setString(3, patient.getGender());

            ps.setDouble(4, patient.getBmi());

            ps.executeUpdate();

            System.out.println(
                "Patient Added Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void getAllPatients() {

        String sql = "SELECT * FROM patients";

        try(Connection con =
                DbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                System.out.println(
                        rs.getInt("patient_id")
                        + " "
                        + rs.getString("patient_name")
                        + " "
                        + rs.getInt("age")
                        + " "
                        + rs.getString("gender")
                        + " "
                        + rs.getDouble("bmi")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void deletePatient(int id) {

        String sql =
            "DELETE FROM patients " +
            "WHERE patient_id=?";

        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,id);
            int rows = ps.executeUpdate();
            if(rows>0)
                System.out.println("Deleted Successfully");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
