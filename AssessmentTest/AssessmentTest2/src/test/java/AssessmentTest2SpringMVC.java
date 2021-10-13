import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class AssessmentTest2SpringMVC {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(CalculationController.class).build();
    }

    /**
     * The task is to implement a controller that handles a GET request to /surface
     *
     * <ul>
     * <li>It should return a view named "result"</li>
     * <li>It should read the request parameter "width" and add the attribute "area" to the model</li>
     * <li>The value of the surface attribute should be "The surface area is [result]"</li>
     * </ul>
     *
     * The result can be calculated using {@link Methods#calculateSurfaceAreaOrVolumeOfCube}
     * <p/>
     * NOTE: You do not have to create a view template file (result.html).
     */
    @Test
    public void shouldReturnModelAndViewWithSurfaceAreaCalculated() throws Exception {
        int width = (int) (Math.random()*100);
        mockMvc.perform(get("/surface?width=" + width))
                .andExpect(view().name("result"))
                .andExpect(model().attribute("area", "The surface area is " +
                        Methods.calculateSurfaceAreaOrVolumeOfCube(true, width)));
    }
}
