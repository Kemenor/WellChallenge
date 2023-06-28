package ch.kunkel.well.integrationTests;

import ch.kunkel.well.datetracker.DateTrackerApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DateTrackerApplication.class)
@AutoConfigureMockMvc
public class DateTrackerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getDate() throws Exception {
        MvcResult result = mockMvc.perform(get("/date")
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String dateString = result.getResponse().getContentAsString();

        LocalDate ld = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);

        assertThat(ld).isEqualTo(LocalDate.now());
    }
}
