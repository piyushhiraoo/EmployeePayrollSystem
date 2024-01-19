import java.util.ArrayList;

abstract class Employee{
private String name;
private int id;

public Employee(String name,int id){
    this.name=name;
    this.id=id;

}

public String getName(){
    return name;
}

public int getId(){
    return id;
}

public abstract double calculateSalary();

@Override
public String toString(){
    return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
}
}

class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked , double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}


class PayRollSystem{
     private ArrayList<Employee> employeeList;

     PayRollSystem(){
        employeeList = new ArrayList<>();
     }

     public void addEmployee(Employee employee){
        employeeList.add(employee);
     }

     public void removeEmployee(int id){
        Employee employeeRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeRemove = employee ;
                break;
            }
        }
        if(employeeRemove != null){
            employeeList.remove(employeeRemove);
        }
     }
     public void displayEmployee(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}



class Main{
    public static void main(String[] args) {
        PayRollSystem payrollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("aman", 1, 700000);
        PartTimeEmployee emp2 = new PartTimeEmployee("piyush", 2, 46, 400);
      
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Inital Employee Details: ");
        payrollSystem.displayEmployee();
        System.out.println("Removing Employees: ");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployee();
    
    }      
}