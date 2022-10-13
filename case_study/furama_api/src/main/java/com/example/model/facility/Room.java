package com.example.model.facility;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Room extends Facility {
    private String free;

    public Room() {
    }

    public Room(String nameFacility, double leasedArea, double rentalCosts, int maxPerson,
                RentType rentalType, FacilityType facilityType, String description, String free) {
        super(nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, facilityType);
        this.free = free;
    }


    public Room(int iDFacility, String nameFacility, double leasedArea, double rentalCosts,
                int maxPerson, RentType rentalType, FacilityType facilityType,
                String free) {
        super(iDFacility, nameFacility, leasedArea, rentalCosts, maxPerson, rentalType, facilityType);
        this.free = free;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Room{ " + super.toString() +
                "free='" + free + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(getIDFacility(), room.getIDFacility());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDFacility());
    }
}
