import Interfaces.IDepartment;
//high level model
public class DepartmentManagement {
    private IDepartment department;
//    private HumanResource department;
//    public DepartmentManagement(HumanResource department) {
//        this.department = department;
//    }
    public  DepartmentManagement(IDepartment department){
        this.department = department;
    }

    public String getDepartment(){
        return department.getDepartmentDetails();
    }
}
