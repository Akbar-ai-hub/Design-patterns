package Praktika;

import java.util.ArrayList;
import java.util.List;

abstract class OrganizationComponent{
    public String name;
    public double Salary;

    public abstract void add(OrganizationComponent component);
    public abstract void delete(OrganizationComponent component);
}

class Employee extends OrganizationComponent{

    @Override
    public void add(OrganizationComponent component) {

    }

    @Override
    public void delete(OrganizationComponent component) {

    }
}

class Department extends OrganizationComponent{
    private List<OrganizationComponent> components;

    public Department(){
        components = new ArrayList<>();
    }
    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void delete(OrganizationComponent component) {
        components.remove(component);
    }

    public double getSalary(){
        return components.size();
    }
    public int getCount(){
        return components.size();
    }
}


public class Praktika91 {
    public static void main(String[] args){
        Department department = new Department();
        department.name = "DBU";
        Employee John = new Employee();
        Employee Jane = new Employee();
        Employee Jack = new Employee();
        department.add(John);
        department.add(Jane);
        department.add(Jack);

        Department department1 = new Department();
        department.name = "";
        Employee Doe = new Employee();
        Employee Doe1 = new Employee();
        department.add(Doe);
        department.add(Doe1);

        Department department2 = new Department();
        department2.name = "";
        department2.add(department);
        department2.add(department1);
    }
}
