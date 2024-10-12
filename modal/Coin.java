package com.earth.Trading.modal;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Coin {

        @Id
        @JsonProperty("id")
        private String id;                          // Cryptocurrency ID

        @JsonProperty("symbol")
        private String symbol;                      // Cryptocurrency Symbol

        @JsonProperty("name")
        private String name;                        // Cryptocurrency Name

        @JsonProperty("image")
        private String image;                       // Image URL

        @JsonProperty("current_price")
        private double currentPrice;                // Current Price (USD)

        @JsonProperty("market_cap")
        private long marketCap;                     // Market Cap (USD)

        @JsonProperty("market_cap_rank")
        private int marketCapRank;                  // Market Cap Rank

        @JsonProperty("fully_diluted_valuation")
        private long fullyDilutedValuation;         // Fully Diluted Valuation (USD)

        @JsonProperty("total_volume")
        private long totalVolume;                   // Total Volume (24h) (USD)

        @JsonProperty("high_24h")
        private double high24h;                     // 24h High Price (USD)

        @JsonProperty("low_24h")
        private double low24h;                      // 24h Low Price (USD)

        @JsonProperty("price_change_24h")
        private double priceChange24h;              // Price Change (24h) (USD)

        @JsonProperty("price_change_percentage_24h")
        private double priceChangePercentage24h;    // Price Change Percentage (24h)

        @JsonProperty("market_cap_change_24h")
        private double marketCapChange24h;          // Market Cap Change (24h) (USD)

        @JsonProperty("market_cap_change_percentage_24h")
        private double marketCapChangePercentage24h;// Market Cap Change Percentage (24h)

        @JsonProperty("circulating_supply")
        private double circulatingSupply;           // Circulating Supply (BTC)

        @JsonProperty("total_supply")
        private double totalSupply;                 // Total Supply (BTC)

        @JsonProperty("max_supply")
        private double maxSupply;                   // Max Supply (BTC)

        @JsonProperty("ath")
        private double ath;                         // All-Time High (ATH) Price (USD)

        @JsonProperty("ath_change_percentage")
        private double athChangePercentage;         // Percentage Change from ATH

        @JsonProperty("ath_date")
        private String athDate;                     // ATH Date (ISO 8601)

        @JsonProperty("atl")
        private double atl;                         // All-Time Low (ATL) Price (USD)

        @JsonProperty("atl_change_percentage")
        private double atlChangePercentage;         // Percentage Change from ATL

        @JsonProperty("atl_date")
        private String atlDate;                     // ATL Date (ISO 8601)

        @JsonProperty("roi")
        @JsonIgnore
        private String roi;                         // Return on Investment (ROI)

        @JsonProperty("last_updated")
        private String lastUpdated;                 // Last Updated (ISO 8601)


}
