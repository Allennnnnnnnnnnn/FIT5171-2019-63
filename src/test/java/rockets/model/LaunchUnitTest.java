package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by 56835 on 3/24/2019.
 */
public class LaunchUnitTest {
    private Launch target;

    @BeforeEach
    public void setUp() {
        target = new Launch();
    }

    @Test
    public void shouldConstructUser() {
        assertNotNull(target);
    }


}
