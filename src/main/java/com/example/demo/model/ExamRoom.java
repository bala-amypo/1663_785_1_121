package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExamRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private int rows;

    private int columns;

    private int capacity;

    // Automatically calculate capacity
    @PrePersist
    @PreUpdate
    public void calculateCapacity() {
        this.capacity = this.rows * this.columns;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getCapacity() {
        return capacity;
    }
}




// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// @Table(uniqueConstraints = @UniqueConstraint(columnNames = "roomNumber"))
// public class ExamRoom {

//     @Id
//     @GeneratedValue
//     private Long id;

//     private String roomNumber;
//     private Integer capacity;
//     private Integer rows;
//     private Integer columns;

//     @PrePersist
//     @PreUpdate
//     void ensureCapacityMatches() {
//         capacity = rows * columns;
//     }

//     // getters and setters
// }