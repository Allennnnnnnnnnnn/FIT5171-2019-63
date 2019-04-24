package rockets.model;

import static org.apache.commons.lang3.Validate.notBlank;

/**
 * Created by 56835 on 3/30/2019.
 */
public class payload {
    private String name;
    private String category;
    private float cost;
    private float weight;

    public payload(String name, String category, float cost, float weight) {
        notBlank(name,"category and name should not be null or empty");
        notBlank(category,"category and name should not be null or empty");

        this.name = name;
        this.category = category;
        this.cost = cost;
        this.weight = weight;
    }

    public payload(){
        this.name = "";
        this.category = "";
        this.cost = 0;
        this.weight = 0;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public float getWeight() {
        return weight;
    }

    public void setName(String name) {
        notBlank(name,"name should not be null or empty");
        this.name = name;
    }

    public void setCategory(String category) {
        notBlank(category,"category should not be null or empty");
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
