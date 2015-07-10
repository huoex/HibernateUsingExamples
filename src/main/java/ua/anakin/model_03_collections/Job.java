package ua.anakin.model_03_collections;

import javax.persistence.Embeddable;

@Embeddable
public class Job {

    private String company;
    private String vacancy;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public String toString() {
        return "Job{" +
                "company='" + company + '\'' +
                ", vacancy='" + vacancy + '\'' +
                '}';
    }
}
