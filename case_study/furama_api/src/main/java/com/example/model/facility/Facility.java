package com.example.model.facility;

import javax.persistence.*;

@Entity
@Table(name = "facility")
@Inheritance
public abstract class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double leasedArea;
    private double rentalCosts;
    private int maxPerson;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "id")
    private FacilityType facilityType;




    public Facility() {
    }

    public Facility(int id, String name, double leasedArea, double rentalCosts,
                    int maxPerson, RentType rentalType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.leasedArea = leasedArea;
        this.rentalCosts = rentalCosts;
        this.maxPerson = maxPerson;
        this.rentType = rentalType;
        this.facilityType = facilityType;

    }

    public Facility(String name, double leasedArea, double rentalCosts, int maxPerson, RentType rentalType, FacilityType facilityType) {
        this.name = name;
        this.leasedArea = leasedArea;
        this.rentalCosts = rentalCosts;
        this.maxPerson = maxPerson;
        this.rentType = rentalType;
        this.facilityType = facilityType;

    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameFacility) {
        this.name = nameFacility;
    }

    public double getLeasedArea() {
        return leasedArea;
    }

    public void setLeasedArea(double leasedArea) {
        this.leasedArea = leasedArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentalType) {
        this.rentType = rentalType;
    }

    public int getIDFacility() {
        return id;
    }

    public void setIDFacility(int iDFacility) {
        this.id = iDFacility;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public String toString() {
        return "iDFacility='" + id + '\'' +
                ", nameFacility='" + name + '\'' +
                ", leasedArea='" + leasedArea + '\'' +
                ", rentalCosts=" + rentalCosts +
                ", maxPerson=" + maxPerson +
                ", rentalType='" + rentType.getName() + '\'';
    }
}
