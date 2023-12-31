package com.java.ecommerce.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //JPA entity object that Spring Boot JPA can manage
@Table(name="product")
@Data //Lombok's annotation with autogenerated boilerplate code
public class Product {

    @Id // indicates that the field is a primary key for the database table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // the primary key is auto-incremented in database
    @Column(name = "id") // a field should be mapped to a database column
    private Long id;

    /* specifies the column in the Product table which serves as a foreign key to the related entity.
     In this case, the category_id column in the Product table is the foreign key pointing to the
     primary key of the ProductCategory table.*/
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp
    private java.util.Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;
}
