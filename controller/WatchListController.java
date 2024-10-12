package com.earth.Trading.controller;


import com.earth.Trading.modal.Coin;
import com.earth.Trading.modal.User;
import com.earth.Trading.modal.WatchList;
import com.earth.Trading.service.CoinService;
import com.earth.Trading.service.UserService;
import com.earth.Trading.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/watchList")
public class WatchListController {

    @Autowired
    private WatchListService watchListService;

    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

    @GetMapping("/user")
    public ResponseEntity<WatchList> getUserWatchList(
            @RequestHeader("Authorization") String jwt
    )throws Exception{
        User user = userService.findUserProfileByJwt(jwt);
        WatchList watchList  = watchListService.findUserWatchList(user.getId());
        return ResponseEntity.ok(watchList);
    }

    @GetMapping("/{watchlistId}")
    public ResponseEntity<WatchList> getWatchlistById(
            @PathVariable Long watchlistId
    )throws Exception{
        WatchList watchlist = watchListService.findById(watchlistId);
        return ResponseEntity.ok(watchlist);
    }

    @PatchMapping ("/add/coin/{coinId}")
    public ResponseEntity<Coin> addItemToWatchlist(
            @RequestHeader("Authorization") String jwt,
            @PathVariable String coinId
    )throws Exception{
        User user = userService.findUserProfileByJwt(jwt);
        Coin coin = coinService.findById(coinId);
        Coin addedCoin = watchListService.addItemToWatchList(coin,user);
        return ResponseEntity.ok(addedCoin);
    }


}
