package com.SpringBootProject.Controller;

import com.SpringBootProject.DTO.TripDTO;
import com.SpringBootProject.DTO.TripDTOWithOutId;
import com.SpringBootProject.Service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trips")
@Tag(name="Trip APIs",description = "APIs For Managing Trips")
public class TripController {
     public final TripService tripService;

     @Operation(summary = "Create Trip",description = "Add a new trip")
     @PostMapping
     public TripDTO CreateTrip(@Valid @RequestBody TripDTOWithOutId tripDTOWithOutId) {
         return tripService.save(tripDTOWithOutId);
     }
}
