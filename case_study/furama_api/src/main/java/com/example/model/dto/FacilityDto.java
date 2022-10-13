package com.example.model.dto;

import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class FacilityDto implements Validator {
    private int id;
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}\\d]{1,8})(\\s([\\p{Lu}\\d]|[\\p{Lu}\\d][\\p{Ll}\\d]{1,10})){0,5})| *$",
            message = "Tên dịch vụ các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;
    @Min(20)
    private double leasedArea;
    @Min(value = 200000, message = "Chi phí thuê tối thiểu 200000")
    private double rentalCosts;
    @Min(value = 2, message = "Số người tối thiểu là 2")
    @Max(value = 19, message = "Số người tối đa là 19")
    private int maxPerson;
    private boolean isDelete;
    private RentType rentType;
    private FacilityType facilityType;
    private String description;
    private String room;
    private int floor;
    private double areaPool;
    private String free;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, double leasedArea, double rentalCosts, int maxPerson, boolean isDelete, RentType rentType, FacilityType facilityType, String description, String room, int floor, double areaPool, String free) {
        this.id = id;
        this.name = name;
        this.leasedArea = leasedArea;
        this.rentalCosts = rentalCosts;
        this.maxPerson = maxPerson;
        this.isDelete = isDelete;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.description = description;
        this.room = room;
        this.floor = floor;
        this.areaPool = areaPool;
        this.free = free;
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

    public void setName(String name) {
        this.name = name;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;

    }
}
