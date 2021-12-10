package com.clemen.proyecto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    // Nos crea un bucle entre las asociaciones infinito stack overflow
    // Ignoramos la propiedad users para que no siga serializando
    @JsonIgnoreProperties("user")
    @OneToOne
    @JoinColumn(name = "billing_info_id", unique = true)
    private BillingInfo billingInfo;

    // Asociacion

    /**
     * Un usuario tiene muchas tareas, una tarea solo un usuario
     * OnetoMany
     */

    // Nos crea un bucle entre las asociaciones infinito stack overflow
    // Ignoramos la propiedad users para que no siga serializando
    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy="user")
    private List<Task> task = new ArrayList<>();

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

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
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
