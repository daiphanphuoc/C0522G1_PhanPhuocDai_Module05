package com.example.model.facility;

import com.example.model.business.Contract;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Villa extends Facility {
    private String room;
    private int floor;
    private double areaPool;
    private String description;
    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

    public Villa() {
    }


    public Villa(int iDFacility, String nameFacility, double leasedArea, double rentalCosts,
                 int maxPerson, RentType rentalType, FacilityType facilityType, String description,
                 String room, int floor, double areaPool) {
        super(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, facilityType);
        this.room = room;
        this.floor = floor;
        this.areaPool = areaPool;
        this.description = description;
    }

    public Villa(String nameFacility, double leasedArea, double rentalCosts, int maxPerson, RentType rentalType, FacilityType facilityType, String description, String room, int floor, double areaPool) {
        super(nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, facilityType);
        this.room = room;
        this.floor = floor;
        this.areaPool = areaPool;
        this.description = description;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Villa villa = (Villa) o;
        return getIDFacility() == villa.getIDFacility();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDFacility());
    }


}
