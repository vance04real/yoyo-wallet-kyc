package za.co.yoyowallet.kyc.utils.Dtos;

import javax.persistence.Column;

/**
 * Created  26/04/2021 - 09:08
 * Project  kyc
 * Author   Evans K F C
 **/
public class CustomerDto {

    private String name;
    private String surname;
    private String email;

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
}