package com.example.entity;

import com.example.model.ContactInfo;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_INFO")
public class ContactInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToOne(mappedBy = "contactInfo")
    private ReservationEntity reservation;

    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ContactInfo toContactInfoDto() {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmail(this.email);
        contactInfo.setPhone(this.phone);
        return contactInfo;
    }

}
