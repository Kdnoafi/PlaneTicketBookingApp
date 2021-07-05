package com.raf.user_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer minMilesTravelled;
    private Integer maxMilesTravelled;
    private Integer discount;
    private Rank rank;

    public UserStatus() {

    }

    public UserStatus(Integer minMilesTravelled, Integer maxMilesTravelled, Integer discount, Rank rank) {
        this.minMilesTravelled = minMilesTravelled;
        this.maxMilesTravelled = maxMilesTravelled;
        this.discount = discount;
        this.rank = Rank.BRONZA;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMinMilesTravelled() {
        return minMilesTravelled;
    }

    public void setMinMilesTravelled(Integer minMilesTravelled) {
        this.minMilesTravelled = minMilesTravelled;
    }

    public Integer getMaxMilesTravelled() {
        return maxMilesTravelled;
    }

    public void setMaxMilesTravelled(Integer maxMilesTravelled) {
        this.maxMilesTravelled = maxMilesTravelled;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
