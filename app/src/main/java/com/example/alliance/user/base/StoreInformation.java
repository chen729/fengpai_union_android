package com.example.alliance.user.base;

public class StoreInformation {

    private String storeName;
    private String storeOwner;
    private String phone;
    private String storeAddress;
    private String type;

    public StoreInformation(String storeName,String storeOwner,String phone,String storeAddress,String type){
        this.storeName = storeName;
        this.storeOwner = storeOwner;
        this.phone = phone;
        this.storeAddress = storeAddress;
        this.type = type;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
