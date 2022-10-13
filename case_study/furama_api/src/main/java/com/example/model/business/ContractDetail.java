package com.example.model.business;


import daiphan.casestudy.model.dto.ContractDetailDto;
import daiphan.casestudy.model.facility.AttachFacility;

import javax.persistence.*;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id", referencedColumnName = "id")
    private AttachFacility attachFacility;

    private int quantity;
    private boolean isDelete;

    public ContractDetail(ContractDetailDto contractDetailDto) {
        this.id = contractDetailDto.getId();
        this.getContract().setId(contractDetailDto.getContract().getId());
        this.attachFacility.setId(contractDetailDto.getAttachFacility().getId());
        this.quantity = contractDetailDto.getQuantity();
        this.isDelete = false;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public ContractDetail() {
    }

    public ContractDetail(int id, Contract contract, AttachFacility attachFacility, int quantity, boolean isDelete) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
