package ascend.group.demo.controller;

import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import ascend.group.demo.dto.BooksDto;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // for JSON (de)serialization

    @Test
    public void testCreateBook() throws Exception {
        BooksDto book = new BooksDto();
        book.setTitle("Test Book");
        book.setAuthor("Mr.Test");
        book.setPublishedDate(new SimpleDateFormat("yyyy-MM-dd").parse("2025-05-30"));

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.author").value("Mr.Test"));
    }

    @Test
    public void testGetBooks() throws Exception {
        mockMvc.perform(get("/books")
                        .param("author", "Mr.Test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
