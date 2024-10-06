@Entity // If using JPA, for relational DBs
@Table(name = "training_centers")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    private Long id;

    @NotBlank(message = "Center name is mandatory")
    @Size(max = 40, message = "Center name should not exceed 40 characters")
    private String centerName;
    
    @NotBlank(message = "Center code is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be 12 alphanumeric characters")
    private String centerCode;

    @Valid
    @Embedded // If Address is a complex object
    private Address address;

    @Positive(message = "Student capacity must be a positive number")
    private Integer studentCapacity;

    @ElementCollection // For storing a list of courses
    private List<String> coursesOffered;
    
    @NotNull
    private Long createdOn; // Should be set in the service layer

    @Email(message = "Invalid email address")
    private String contactEmail;

    @Pattern(regexp = "^[0-9]{10}$", message = "Contact phone must be 10 digits")
    private String contactPhone;

    // Getters and Setters
}
