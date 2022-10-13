package com.example.model.person;

import daiphan.casestudy.model.business.Contract;
import daiphan.casestudy.model.permission.User;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "degree_id" , referencedColumnName = "id")
    private EducationDegree degree;

    @ManyToOne
    @JoinColumn(name = "position_id" , referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "division_id" , referencedColumnName = "id")
    private Division division;
    private double salary;


    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "name")
    private User user;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getInfo() {
        Date date = getBirthday();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString  = df.format(date);
        return String.format("%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s", getName(), getIdCitizen(),dateString,
                isSex(), getPhone(), getEmail(), getAddress(), id, degree.getName(),
                position.getName(),division.getName(), salary, user.getName());
    }

    public Employee(String name, String iDCitizen, Date birthday, boolean sex,
                    String phone, String email, String address, int iDEmployee,
                    EducationDegree degree, Position position, Division division,
                    double salary, User userName) {
        super(name, iDCitizen, birthday, sex, phone, email, address);
        this.id = iDEmployee;
        this.degree = degree;
        this.position = position;
        this.division = division;
        this.salary = salary;
        this.user = userName;
    }

    public Employee(String name, String iDCitizen, Date birthday, boolean sex, String phone,
                    String email, String address, EducationDegree degree, Position position,
                    Division division, double salary, User userName) {
        super(name, iDCitizen, birthday, sex, phone, email, address);
        this.degree = degree;
        this.position = position;
        this.division = division;
        this.salary = salary;
        this.user = userName;
    }

    public Employee(String name, String iDCitizen, Date birthday, boolean sex, String phone,
                    String email, String address, int id, EducationDegree degree,
                    Position position, Division division, double salary, User userName,
                    Set<Contract> contracts) {
        super(name, iDCitizen, birthday, sex, phone, email, address);
        this.id = id;
        this.degree = degree;
        this.position = position;
        this.division = division;
        this.salary = salary;
        this.user = userName;
        this.contracts = contracts;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public EducationDegree getDegree() {
        return degree;
    }

    public void setDegree(EducationDegree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getIDEmployee() {
        return id;
    }

    public void setIDEmployee(int iDEmployee) {
        this.id = iDEmployee;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Employee(String name, String iDCitizen, Date birthday, boolean sex, String phone,
                    String email, String address, int id, EducationDegree degree,
                    Position position, Division division, double salary, Set<Contract> contracts,
                    User user) {
        super(name, iDCitizen, birthday, sex, phone, email, address);
        this.id = id;
        this.degree = degree;
        this.position = position;
        this.division = division;
        this.salary = salary;
        this.contracts = contracts;
        this.user = user;
    }
}
