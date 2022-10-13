package com.example.model.facility;

import com.example.model.business.Contract;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class House extends Facility {
    private String room;
    private int floor;
    private String description;

    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

    public House() {
    }


    public House(int iDFacility, String nameFacility, double leasedArea, double rentalCosts,
                 int maxPerson, RentType rentalType, FacilityType facilityType, String description,
                 String room, int floor) {
        super(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson,
                rentalType, facilityType);
        this.room = room;
        this.floor = floor;
    }

    public House(String nameFacility, double leasedArea, double rentalCosts, int maxPerson, RentType rentalType, FacilityType facilityType, String description, String room, int floor) {
        super(nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, facilityType);
        this.room = room;
        this.floor = floor;
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

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return getIDFacility() == house.getIDFacility();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDFacility());
    }
}
