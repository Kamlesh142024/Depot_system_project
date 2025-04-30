package model;

import java.util.HashMap;
import java.util.Map;

public class ParcelMap {
    private Map<String, Parcel> parcelMap = new HashMap<>();

    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getId(), parcel);
    }

    public Parcel getParcel(String parcelId) {
        return parcelMap.get(parcelId);
    }

    public Map<String, Parcel> getAllParcels() {
        return parcelMap;
    }
}
