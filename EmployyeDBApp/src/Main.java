import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Database App ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Dept: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    dao.addEmployee(name, dept, sal);
                    break;

                case 2:
                    dao.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSal = sc.nextDouble();
                    dao.updateEmployee(id, newSal);
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int delId = sc.nextInt();
                    dao.deleteEmployee(delId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
