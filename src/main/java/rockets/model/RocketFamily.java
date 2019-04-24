package rockets.model;

import static org.apache.commons.lang3.Validate.notBlank;

/**
 * Created by 56835 on 3/30/2019.
 */
public class RocketFamily {
    private String familyName;
    private String variation;

    public RocketFamily(String familyName, String variation) {
        notBlank(familyName,"family and variation should not be null and empty");
        notBlank(variation,"family and variation should not be null and empty");
        this.familyName = familyName;
        this.variation = variation;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getVariation() {
        return variation;
    }

    public void setFamilyName(String familyName) {
        notBlank(familyName,"family and variation should not be null and empty");
        this.familyName = familyName;
    }

    public void setVariation(String variation) {
        notBlank(variation,"family and variation should not be null and empty");
        this.variation = variation;
    }
}
