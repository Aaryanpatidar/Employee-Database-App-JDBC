// EmployeeDAO.java
import java.sql.*;

public class EmployeeDAO {

    public void addEmployee(String name, String dept, double salary) {
        String sql = "INSERT INTO employees(name, department, salary) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setString(2, dept);
            pst.setDouble(3, salary);
            pst.executeUpdate();
            System.out.println("Employee Added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, double newSalary) {
        String sql = "UPDATE employees SET salary=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, newSalary);
            pst.setInt(2, id);
            int rows = pst.executeUpdate();
            System.out.println(rows > 0 ? "Updated!" : "No employee found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            System.out.println(rows > 0 ? "Deleted!" : "No employee found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

