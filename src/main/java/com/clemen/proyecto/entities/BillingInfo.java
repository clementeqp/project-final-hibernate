package com.clemen.proyecto.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Información de factiración de un usuario
 */

@Entity
@Table(name="billing_info")
public class BillingInfo implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String street;
    private String postalCode;
    private String city;
    private String country;
    private String iban;

    @OneToOne(mappedBy = "billingInfo")
    private User user;

}
