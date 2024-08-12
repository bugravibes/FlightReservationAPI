package com.example.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "PASSENGERS")
public class PassengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DOB", nullable = false)
    private String dob;

    @Column(name = "PASSPORT_NUMBER", nullable = false)
    private String passportNumber;

    @Column(name = "NATIONALITY", nullable = false)
    private String nationality;

    @OneToMany(mappedBy = "passenger")
    private Set<ReservationPassengerEntity> reservationPassengers;

    @ManyToOne
    @JoinColumn(name = "contact_info_id", nullable = false)
    private ContactInfoEntity contactInfo;

    public ContactInfoEntity getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfoEntity contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Set<ReservationPassengerEntity> getReservationPassengers() {
        return reservationPassengers;
    }

    public void setReservationPassengers(Set<ReservationPassengerEntity> reservationPassengers) {
        this.reservationPassengers = reservationPassengers;
    }

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
