package com.example.parts_inventory.entity;

import javax.persistence.*;

@Entity
@Table(name = "canon")
public class Canon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "part_name")
    private String partName;

    @Column(name = "part_number")
    private String partNumber;

    @Column(name = "part_price")
    private float partPrice;

    public Canon() {
    }

    public Canon(String partName, String partNumber, float partPrice) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.partPrice = partPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public float getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(float partPrice) {
        this.partPrice = partPrice;
    }

    @Override
    public String toString() {
        return "Canon{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", partPrice=" + partPrice +
                '}';
    }
}
