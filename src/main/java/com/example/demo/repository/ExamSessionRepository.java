public interface ExamSessionRepository extends JpaRepository<ExamSession, Long> {
    List<ExamSession> findByExamDate(LocalDate date);
}
