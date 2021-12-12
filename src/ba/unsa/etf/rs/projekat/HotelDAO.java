package ba.unsa.etf.rs.projekat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class HotelDAO {

    private User user;


    private Connection conn;
    private PreparedStatement getUsersInformation, findUserInformationQuery, findUserQuery;



    public HotelDAO() {
        try {
            user = new User();
            conn = DriverManager.getConnection("jdbc:sqlite:hotel.db");
            getUsersInformation = conn.prepareStatement("SELECT * FROM login_information");
        } catch (SQLException throwables) {
            regenerateDatabase();
            try {
                getUsersInformation = conn.prepareStatement("SELECT * FROM login_information");
            } catch (SQLException e) {
                System.out.println("PROVJERI BAZU!");
                e.printStackTrace();
            }
        }
        try {
            findUserInformationQuery = conn.prepareStatement("SELECT * FROM login_information WHERE username = ? AND password = ?");
            findUserQuery = conn.prepareStatement("SELECT * FROM users WHERE login_information_id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void regenerateDatabase() {
        try {
            Scanner input = new Scanner(new FileInputStream("hotel.sql"));
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
            findUserInformationQuery.setString(1, username);
            findUserInformationQuery.setString(2, password);
            ResultSet rsUserInformation = findUserInformationQuery.executeQuery();
            if (!rsUserInformation.next()) {
                user  = null;
                return false;
            }
            findUserQuery.setInt(1, rsUserInformation.getInt(1));
            ResultSet rsUser = findUserQuery.executeQuery();
            user = new User(rsUser.getInt(1), rsUser.getString(2), rsUser.getString(3),
                    rsUser.getString(4), rsUser.getString(5));
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
