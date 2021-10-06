import Interfaces.IDepartment;

public class Department {
    private IDepartment department;

    public Department(IDepartment department) {
        this.department = department;
    }
    public String getDepartMent(){
        return department.getDepartmentDetails();
    }
}
