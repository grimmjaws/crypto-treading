package com.earth.Trading.modal;

import com.earth.Trading.domain.USER_ROLE;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
public class  User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Embedded
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();

    private USER_ROLE role =USER_ROLE.ROLE_CUSTOMER;




}
