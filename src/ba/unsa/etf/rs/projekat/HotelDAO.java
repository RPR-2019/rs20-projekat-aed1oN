package ba.unsa.etf.rs.projekat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class HotelDAO {

    private Connection conn;
    private PreparedStatement getUsers, findUserQuery;



    public HotelDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:hotel.db");
            getUsers = conn.prepareStatement("SELECT * FROM login_information");
        } catch (SQLException throwables) {
            regenerateDatabase();
            try {
                getUsers = conn.prepareStatement("SELECT * FROM login_information");
            } catch (SQLException e) {
                System.out.println("PROVJERI BAZU!");
                e.printStackTrace();
            }
        }
        try {
            findUserQuery = conn.prepareStatement("SELECT * FROM login_information WHERE username = ? AND password = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void regenerateDatabase() {
        try {
            Scanner input = new Scanner(new FileInputStream("users.sql"));
            String sqlQuery = "";
            while (input.hasNext())  {
                sqlQuery += input.nextLine();
                if (sqlQuery.length() > 1 && sqlQuery.charAt(sqlQuery.length() - 1) == ';') {
                    Statement stmt = conn.createStatement();
                    stmt.execute(sqlQuery);
                    sqlQuery = "";
                }
            }
            input.close();
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validateUser(String username, String password) {
        try {
            findUserQuery.setString(1, username);
            findUserQuery.setString(2, password);
            ResultSet rs = findUserQuery.executeQuery();
            if (!rs.next()) return false;
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

}
