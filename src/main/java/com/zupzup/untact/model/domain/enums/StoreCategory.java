package com.zupzup.untact.model.domain.enums;

public enum StoreCategory {

    BAKERY("BAKERY"),
    CAFE("CAFE"),
    SALAD("SALAD"),
    YOGURT("YOGURT"),
    OTHERS("OTHERS");

    private final String storeCategory;

    StoreCategory(String storeCategory) { this.storeCategory = storeCategory; }

    public String getStoreCategory() { return this.storeCategory; }

}
