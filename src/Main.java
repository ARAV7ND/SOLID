import Interfaces.IDepartment;
import Interfaces.IEmployee;

import java.util.*;

public class Main {
    static Map<Integer, IDepartment> departmentMap = new HashMap<>();
    public static void displayEmployeeTypes(){

        System.out.println("1.Permanent Employee");
        System.out.println("2.Temporary Employee");
        System.out.println("3.Contract Based Employee");

    }
    public static void displayDepartmentTypes(){
        System.out.println("1.Finance");
        System.out.println("2.Human Resource");
        System.out.println("3.Development");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<IEmployee> employeeList = new ArrayList<>();
        System.out.println("Enter the number of Employees : ");
        int noOfEmployees = scanner.nextInt();
        while (noOfEmployees-->0){
            System.out.println("Enter Employee Id : ");
            int employeeId = scanner.nextInt();
            System.out.println("Enter Employee "+employeeId+" Name :");
            String employeeName = scanner.next();
            System.out.println("Enter Minimum salary :");
            double employeeSalary = scanner.nextDouble();
            System.out.println("Choose the option from below : ");
            System.out.println("--------------------------");
            displayEmployeeTypes();
            int option = scanner.nextInt();
            while(option!=1 && option!=2 && option!=3) {
                System.out.println("Please choose the correct option");
                System.out.println("-----------------------------");
                displayEmployeeTypes();
                option = scanner.nextInt();
            }
            if (option == 1) {
                employeeList.add(new PermanentEmployee(employeeId, employeeName, employeeSalary));
            } else if (option == 2) {
                employeeList.add(new TemporaryEmployee(employeeId, employeeName, employeeSalary));
            } else if (option == 3) {
                employeeList.add(new ContractBasedEmployee(employeeId, employeeName, employeeSalary));
            }
            System.out.println("choose the Deapartment from below");
            displayDepartmentTypes();
            int departmentOption = scanner.nextInt();
            while (departmentOption!=1 && departmentOption!=2 && departmentOption!=3){
                System.out.println("Please choose the correct option from below");
                departmentOption = scanner.nextInt();
            }
            if(departmentOption==1){
                departmentMap.put(employeeId,new Finance());
            }else if(departmentOption==2){
                departmentMap.put(employeeId,new HumanResource());
            }else if(departmentOption==3){
                departmentMap.put(employeeId,new Development());
            }
        }
        for(var employee : employeeList){
            if(employee instanceof Employee){
                Employee emp = (Employee)employee;
                System.out.println("Employee Id : "+emp.employeeId+", Employee Name : "+emp.employeeName
                        +", Department : "+departmentMap.get(emp.employeeId).getDepartmentDetails()+", Minimum salary : "+emp.getMinimumSalary()+", Bonus : "+emp.getBonus());
            }else{
                ContractBasedEmployee emp = (ContractBasedEmployee)employee;
                System.out.println("Employee Id : "+emp.employeeId+", Employee Name : "+emp.employeeName
                        +", Department : "+departmentMap.get(emp.employeeId).getDepartmentDetails()+", Minimum salary : "+emp.getMinimumSalary());
            }
        }
    }
}
