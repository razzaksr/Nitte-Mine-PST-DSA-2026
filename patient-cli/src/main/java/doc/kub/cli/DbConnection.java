package doc.kub.cli;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    private static String url;
    private static String username;
    private static String password;

    static {
        try (InputStream input = DbConnection.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            Properties prop = new Properties();
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find application.properties");
            }
            prop.load(input);

            url = prop.getProperty("db_url");
            username = prop.getProperty("db_username");
            password = prop.getProperty("db_password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(url, username, password);
    }
}