package za.co.yoyowallet.kyc.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created  25/04/2021 - 21:29
 * Project  kyc
 * Author   Evans K F C
 **/

@Entity
@Table(name="CUSTOMER")
public class Customer extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable=false, length=200)
    private String name;

    @Column(name="surname", nullable=false, length=200)
    private String surname;

    @Column(name="email", nullable=false, length=200)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @PrePersist
    protected void init() {
        super.prePersist();
    }

    @PreUpdate
    protected void reload() {
        super.preUpdate();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
