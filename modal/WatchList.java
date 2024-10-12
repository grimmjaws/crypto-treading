package com.earth.Trading.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class WatchList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Coin> coins = new ArrayList<>();
}
