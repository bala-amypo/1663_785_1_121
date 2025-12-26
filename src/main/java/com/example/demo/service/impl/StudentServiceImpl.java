public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student s) {
        if (s.getYear() == null || s.getYear() < 1 || s.getYear() > 5)
            throw new ApiException("Invalid year");

        if (repo.findByRollNumber(s.getRollNumber()).isPresent())
            throw new ApiException("exists");

        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
