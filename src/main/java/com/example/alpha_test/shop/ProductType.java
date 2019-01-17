package com.example.alpha_test.shop;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class ProductType {

    private @Id
    int id;
    private String typeName;


    ProductType(){}

    ProductType(int id, String typeName) {
        this.id=id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


}
