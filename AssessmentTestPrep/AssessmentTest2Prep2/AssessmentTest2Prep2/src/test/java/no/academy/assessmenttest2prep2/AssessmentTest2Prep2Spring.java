package no.academy.assessmenttest2prep2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class AssessmentTest2Prep2Spring {

    @Autowired
    private MockMvc mockMvc;

    @Test()
    public void checkIfEmployeeEndpointIsUp() throws Exception {
        MockHttpServletResponse retVal = mockMvc.perform(MockMvcRequestBuilders
                        .get("/employee"))
                .andExpect(status().isOk()).andReturn().getResponse();
        Assert.assertEquals(retVal.getStatus(), 200);
        Assert.assertEquals(retVal.getContentAsString(), "");
    }

    @Test
    public void checkIfEmployeesNumberEndpointIsUp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employeesNumber"))
                .andExpect(status().isOk());
    }

    @Test
    public void checkIfEmployeesEndpointIsUp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employees"))
                .andExpect(status().isOk());
    }

    @Test
    public void checkIfDeleteAllEmployeesEndpointIsUp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteAllEmployees"))
                .andExpect(status().isOk());
    }

    @Test()
    public void checkIfICanGetASpecificEmployee() throws Exception {
        EmployeeVO Nils = new EmployeeVO("Nils", "Nilsen", "1345");
        EmployeeVO Karl = new EmployeeVO("Karl", "Nilsen", "1547");
        populateAPI(Nils);
        populateAPI(Karl);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employee?id=" + Nils.getEmployeeNumber()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeNumber").value(Nils.getEmployeeNumber()))
                .andReturn()
                .getResponse();

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteAllEmployees"));
    }

    private int populateAPI(EmployeeVO employeeVO) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee")
                        .content(asJsonString(employeeVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getStatus();
    }

    @Test
    public void checkIfICanAddANewEmployeeUsingPost() throws Exception {
        EmployeeVO employee = new EmployeeVO("Ola", "Nordmann", "3213");

        Assert.assertEquals(populateAPI(employee), 201);

        Assert.assertEquals(checkIfICanCountTheNumberOfEmployees(), 1);
    }

    public int checkIfICanCountTheNumberOfEmployees() throws Exception {
        return Integer.parseInt(mockMvc.perform(MockMvcRequestBuilders
                        .get("/employeesNumber"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }

    @Test
    public void checkThatItActuallyReturnsSomeEmplyees() throws Exception {
        String retVal = mockMvc.perform(MockMvcRequestBuilders
                        .get("/employees"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Assert.assertFalse(retVal.isEmpty());
    }

    @Test
    public void checkIfNumberOfEmployeesIsCorrect() throws Exception {
        populateAPI(new EmployeeVO("Arve", "Opsahl", "0141"));
        populateAPI(new EmployeeVO("Nils", "Vogt", "0140"));
        populateAPI(new EmployeeVO("Sven", "Nordin", "0139"));
        populateAPI(new EmployeeVO("Siw", "Andersen", "0110"));

        Assert.assertEquals(checkIfICanCountTheNumberOfEmployees(), 4);

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteAllEmployees"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
