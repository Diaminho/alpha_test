package com.example.alpha_test.beans;




import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "productTypeId", cascade = CascadeType.ALL)
    private Set<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Type(){}
}
