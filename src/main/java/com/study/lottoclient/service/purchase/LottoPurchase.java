package com.study.lottoclient.service.purchase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class LottoPurchase {
    private final int PRICE = 1000;
    private Long id;
    private List<Lotto> lottos;

    private LocalDateTime createTime;

    public LottoPurchase(Long id, List<Lotto> lottos) {
        this.id = id;
        this.lottos = lottos;
        this.createTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
    
    public List<Lotto> getLottos() {
        return lottos;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public int getTotalPrice() {
        return lottos.size() * 1000;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPurchase that = (LottoPurchase) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
