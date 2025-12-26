public interface SeatingPlanRepository extends JpaRepository<SeatingPlan, Long> {
    List<SeatingPlan> findByExamSessionId(Long sessionId);
}
