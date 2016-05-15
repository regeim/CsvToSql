import java.sql.*;


/**
 * Created by Zoli on 2016.05.12..
 */
public class CsvToSql {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        String serverName = "localhost";
        String mydatabase = "default";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

        String username = "user";
        String password = "user";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            DBase db = new DBase();
            db.importData(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    }

