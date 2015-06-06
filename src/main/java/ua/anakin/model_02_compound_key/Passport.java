package ua.anakin.model_02_compound_key;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Passport implements Serializable {
    private String passportSeries;
    private int passportNumber;

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "series='" + passportSeries + '\'' +
                ", number=" + passportNumber +
                '}';
    }
}
