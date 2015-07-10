package ua.anakin.model_08_inheritance;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {

    private int seaterNumber;

    public int getSeaterNumber() {
        return seaterNumber;
    }

    public void setSeaterNumber(int seaterNumber) {
        this.seaterNumber = seaterNumber;
    }
}
