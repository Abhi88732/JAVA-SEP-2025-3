package com.SpringBootProject.DTO;

import com.SpringBootProject.Entity.Status;
import lombok.*;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TripDTOWithOutId {
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private Status status;
}
