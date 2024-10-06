import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TrainingCenterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTrainingCenters() throws Exception {
        mockMvc.perform(get("/api/training-centers"))
               .andExpect(status().isOk());
    }
}
@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService; // Service layer for business logic
    private MockMvc mockMvc;

    // Get a list of all training centers
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> trainingCenters = trainingCenterService.getAllTrainingCenters();
        
        // Return the list in JSON format (an empty list if no centers exist)
        return ResponseEntity.ok(trainingCenters);
    }
    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = trainingCenterService.createTrainingCenter(trainingCenter);
        return ResponseEntity.ok(savedCenter);  // Return the newly saved center
    }
  

    @Test
    public void testGetTrainingCenters() throws Exception {
        mockMvc.perform(get("/api/training-centers"))
               .andExpect(status().isOk());  // Verify that the status is 200 OK
    }

}
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

