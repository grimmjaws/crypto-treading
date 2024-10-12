package com.earth.Trading.service;

import com.earth.Trading.modal.Coin;
import com.earth.Trading.modal.User;
import com.earth.Trading.modal.WatchList;

public interface WatchListService {
    WatchList findUserWatchList(Long userId) throws Exception;

    WatchList createWatchList(User user);

    WatchList findById(Long id) throws Exception;

    Coin addItemToWatchList(Coin coin , User user) throws Exception;
}
