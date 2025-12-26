public interface ExamRoomRepository extends JpaRepository<ExamRoom, Long> {
    Optional<ExamRoom> findByRoomNumber(String roomNumber);
    List<ExamRoom> findByCapacityGreaterThanEqual(Integer capacity);
}
