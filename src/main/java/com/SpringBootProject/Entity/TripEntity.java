package com.SpringBootProject.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="Trip")
@Setter
@Getter
public class TripEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;
        @NotBlank(message = "Destination can't be empty")
        @Column(name="destination")
        private String destination;
        @NotNull(message = "Start date can't be null")
        @Column(name="startDate")
        private LocalDate startDate;
        @NotNull(message = "End date can't be null")
        @Column(name="endDate")
        private LocalDate endDate;
        @Positive(message = "Price must be positive")
        @Column(name="price")
        private Double price;
        @Enumerated(EnumType.STRING)
        @NotNull(message = "Status is required")
        @Column(name="status")
        private Status status;

        @AssertTrue(message = "End date must be after start date")
        public boolean isEndDateAfterStartDate() {
              if(startDate==null || endDate==null)
                  return true;
              return endDate.isAfter(startDate);
        }

}
