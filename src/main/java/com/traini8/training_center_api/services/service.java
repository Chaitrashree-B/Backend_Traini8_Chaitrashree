@Service
public class TrainingCenterService {
    
    @Autowired
    private TrainingCenterRepository trainingCenterRepository; // Repository for database interaction
    
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        // Set the current system timestamp for createdOn
        trainingCenter.setCreatedOn(System.currentTimeMillis());
        
        // Save the training center in the database
        return trainingCenterRepository.save(trainingCenter);
    }
 

    // Method to fetch all training centers
    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll(); // Returns all centers (empty list if none exist)
    }
}
