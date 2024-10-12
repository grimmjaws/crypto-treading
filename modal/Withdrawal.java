package com.earth.Trading.modal;

import com.earth.Trading.domain.WithdrawalStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private WithdrawalStatus withdrawalStatus;

    private Long amount;

    @ManyToOne
    private User user;

    private LocalDateTime date = LocalDateTime.now();


    public void setStatus(WithdrawalStatus status) {
    }
}
