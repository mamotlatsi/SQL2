package mamotlatsiSql;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Scanner;
public class Queries {
    // JDBC driver name and database URL
    Connection con;
    Statement stmt;


        public void DBConnection () {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Class added");
            } catch (Exception e) {
                System.out.println("Class not added");
                System.err.println(e.getMessage());
            }
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:Umuzi", "postgres", "pass");
                System.out.println("database connected");
            } catch (Exception e) {
                System.out.println("Class not added");
                System.err.println(e.getMessage());
            }
        }

        private void SelectAll () {
            try {
                stmt = con.createStatement();
                String query = "SELECT  * FROM Customer ";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getInt("customer_id") + "" + rs.getString("name") + "" + rs.getString("surname") + "" + rs.getString("gender") + "" + rs.getString("address") + "" + rs.getInt("phone") + "" + rs.getString("email") + "" + rs.getString("city") + "" + rs.getString("country"));
                }
            } catch (Exception e) {
                System.err.print(e);
            }
        }

        private void SelectName () {
            try {
                stmt = con.createStatement();
                String query = " SELECT first_name, last_name FROM customers; ";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("name") + "" + rs.getString("surname"));
                }
            } catch (Exception e) {
                System.err.print(e);
            }
        }

        private void showName () {
            try {
                stmt = con.createStatement();
                String query = " SELECT first_name, last_name FROM customers, WHERE customer_id=1; ";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("name") + "" + rs.getString("surname"));
                }
            } catch (Exception e) {
                System.err.print(e);
            }
        }

        private void UpdateRecord () {
            try {
                stmt = con.createStatement();
                String query = " SELECT first_name, last_name FROM customers, WHERE customer_id=1; ";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("name") + "" + rs.getString("surname"));
                }
            } catch (Exception e) {
                System.err.print(e);

            }
        }

        private void DeleteRecords () {
            this.DBConnection();
            String customers = JOptionPane.showInputDialog("Please enter a customer-id ");

            try {
                String selectSQL = " Delete from customers where customer_id = 2;";
                PreparedStatement pr = this.con.prepareStatement(selectSQL);
                ResultSet rs = pr.executeQuery();

                while (rs.next()) {
                    if (rs.getString("customer_id").equals(2)) {
                        this.stmt.executeQuery(rs.getString(" customer_id "));
                    }
                    pr.execute();
                    this.con.close();
                }
            } catch (SQLException var7) {
                JOptionPane.showMessageDialog((Component) null, "Database error on record not found");
                System.out.println(var7.getMessage());
            }

        }

        private void SelectUnique () {
            try {
                stmt = con.createStatement();
                String query = "SELECT  * FROM Customer ";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getInt("customer_id") + "" + rs.getString("name") + "" + rs.getString("surname") + "" + rs.getString("gender") + "" + rs.getString("address") + "" + rs.getInt("phone") + "" + rs.getString("email") + "" + rs.getString("city") + "" + rs.getString("country"));
                }
            } catch (Exception e) {
                System.err.print(e);
            }
        }
    }


