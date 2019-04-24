package rockets.model;

import com.google.common.collect.Sets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import static org.apache.commons.lang3.Validate.notBlank;

public class LaunchServiceProvider extends Entity {
    private String name;

    private int yearFounded;

    private String country;

    private String headquarters;

    private Set<Rocket> rockets;

    public LaunchServiceProvider(String name, int yearFounded, String country) {
        notBlank(name,"name cannot be null or empty");
        notBlank(country,"country cannot be null or empty");
        validYearFounded(yearFounded);
        this.name = name;
        this.yearFounded = yearFounded;
        this.country = country;

        rockets = Sets.newLinkedHashSet();
    }

    public LaunchServiceProvider() {
        this.name = "";
        this.yearFounded = 1966;
        this.country = "China";

        rockets = Sets.newLinkedHashSet();
    }

    public String getName() {
        return name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public String getCountry() {
        return country;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public Set<Rocket> getRockets() {
        return rockets;
    }

    public boolean validYearFounded(int year) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        String strDate = dateFormat.format(new Date());
        int currentYear = Integer.valueOf(strDate);
        if(year<1957 || year>currentYear)
            throw new IllegalArgumentException("the year input should within a reasonable range");
        return true;
    }

    public boolean numberOfRockets(Set<Rocket> rockets) {
        if(rockets==null){
            throw new NullPointerException("the number of rockets should not be null");
        }
        if(rockets.size()==0)
            throw new IllegalArgumentException("the number of rockets should be at least one");
        return true;
    }

    public void setHeadquarters(String headquarters) {
        notBlank(headquarters,"headquarters cannot be null or empty");
        this.headquarters = headquarters;
    }

    public void setRockets(Set<Rocket> rockets) {
        numberOfRockets(rockets);
        this.rockets = rockets;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaunchServiceProvider that = (LaunchServiceProvider) o;
        return yearFounded == that.yearFounded &&
                Objects.equals(name, that.name) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, yearFounded, country);
    }
}
