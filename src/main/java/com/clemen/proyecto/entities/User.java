package com.clemen.proyecto.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User implements Serializable {
    // Attributes id, firstName,
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String dni;

    private boolean active;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    //Relaciones

    /**
     * Un usuario tiene una informacion de facturacion(BillingInfo)
     * y una BillingInfo solo puede pertenecer a un usuario
     */
    @OneToOne
    @JoinColumn(name = "billing_info_id", unique = true)
    private BillingInfo billingInfo;

    //Constructor vacio
    public User() {
    }
    // Constructor con parametros
    public User(Long id, String firstName, String lastName, String dni, boolean active, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.active = active;
        this.birthDate = birthDate;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    //toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", active=" + active +
                ", birthDate=" + birthDate +
                '}';
    }
}
