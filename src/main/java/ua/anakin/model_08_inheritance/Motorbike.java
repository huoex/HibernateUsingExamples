package ua.anakin.model_08_inheritance;

import javax.persistence.Entity;

@Entity
public class Motorbike extends Vehicle{

    private String bikeType;

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }
}
