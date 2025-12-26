public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final ExamSessionRepository sessionRepo;
    private final SeatingPlanRepository planRepo;
    private final ExamRoomRepository roomRepo;

    public SeatingPlanServiceImpl(
        ExamSessionRepository s,
        SeatingPlanRepository p,
        ExamRoomRepository r) {
        this.sessionRepo = s;
        this.planRepo = p;
        this.roomRepo = r;
    }

    public SeatingPlan generatePlan(Long sessionId) {
        ExamSession session = sessionRepo.findById(sessionId)
                .orElseThrow(() -> new ApiException("session not found"));

        int students = session.getStudents().size();

        ExamRoom room = roomRepo.findAll().stream()
                .filter(r -> r.getCapacity() >= students)
                .findFirst()
                .orElseThrow(() -> new ApiException("no room"));

        String json = "{\"students\":" + students + "}";

        SeatingPlan plan = new SeatingPlan();
        plan.setExamSession(session);
        plan.setRoom(room);
        plan.setArrangementJson(json);

        return planRepo.save(plan);
    }

    public SeatingPlan getPlan(Long id) {
        return planRepo.findById(id)
                .orElseThrow(() -> new ApiException("plan not found"));
    }

    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return planRepo.findByExamSessionId(sessionId);
    }
}
