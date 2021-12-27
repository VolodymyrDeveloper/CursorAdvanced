import java.sql.*;
import java.util.ArrayList;

public class Main {

    static Connection connection;
    static String Url = "jdbc:mysql://localhost:3306/sqltest";
    static String username = "root";
    static String password = "xalimonenko001";

    public static void main(String[] args) {

        //Query 1
        ArrayList<Users> users = getUsersOrderetByName();
        for (Users all : users) {
            System.out.println(all);
        }

        //Query 2
        ArrayList<Address> addresses = searchAddressByCityName("New York");
        for (Address all : addresses) {
            System.out.println(all);
        }

        //Query 3
        deleteEmployeeById(11);

        //Query 4
        printDataByWorkigDate("2020-04-10");

        //Query 5
        printEmployeeAndUsers();
    }

    private static ArrayList<Users> getUsersOrderetByName() {
        ArrayList<Users> users = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(Url, username, password);
            String sql = "SELECT * FROM users ORDER BY username";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String user_password = resultSet.getString(3);
                String email_address = resultSet.getString(4);
                int age = resultSet.getInt(5);
                users.add(new Users(id, username, user_password, email_address, age));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static ArrayList<Address> searchAddressByCityName(String cityName) {
        ArrayList<Address> addresses = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(Url, username, password);
            String sql = "SELECT * FROM address WHERE city =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cityName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String address = resultSet.getString(2);
                String city = resultSet.getString(3);
                int phone = resultSet.getInt(4);
                addresses.add(new Address(id, address, city, phone));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    private static void deleteEmployeeById(int id_employee) {
        try {
            connection = DriverManager.getConnection(Url, username, password);
            String sql = "DELETE FROM employee WHERE employeeId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_employee);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Employee with " + id_employee + " id successfully removed ");
    }

    private static void printDataByWorkigDate(String working_date) {
        try {
            connection = DriverManager.getConnection(Url, username, password);
            String sql = "SELECT person_name, occupation FROM employee WHERE working_date = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, working_date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printEmployeeAndUsers() {
        try {
            connection = DriverManager.getConnection(Url, username, password);
            String sql = "SELECT employee.person_name, employee.working_date,employee.working_hours,users.email_address,users.age FROM employee INNER JOIN users ON employee.employeeId = users.id;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + ";");
                System.out.print(resultSet.getString(2) + ";");
                System.out.print(resultSet.getInt(3) + ";");
                System.out.print(resultSet.getString(4) + ";");
                System.out.print(resultSet.getInt(5) + ";");
                System.out.println();
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}







