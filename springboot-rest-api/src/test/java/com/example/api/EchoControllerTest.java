@SpringBootTest
@AutoConfigureMockMvc
public class EchoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEcho() throws Exception {
        mockMvc.perform(get("/api/echo"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.message").value("Hello, World!"));
    }

    @Test
    public void testPostEcho() throws Exception {
        mockMvc.perform(post("/api/echo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\": \"Hello, Unit Test!\"}"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.message").value("Hello, Unit Test!"));
    }
}
