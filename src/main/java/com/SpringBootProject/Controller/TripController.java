package com.SpringBootProject.Controller;

import com.SpringBootProject.DTO.TripDTO;
import com.SpringBootProject.DTO.TripDTOWithOutId;
import com.SpringBootProject.Entity.TripEntity;
import com.SpringBootProject.Service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "Get All Trip",description = "Get a paginated and sorted list of all trips")
    @GetMapping
    public Page<TripEntity> GetAllTrip(@Valid Pageable pageable) {
        return tripService.GetAllData(pageable);
    }
    @GetMapping("/{Id}")
    public TripDTO GetDataById(@PathVariable Integer Id){
        return tripService.GetTripByID(Id);
    }

    @Operation(summary = "Update All Trip",description = "Update an existing trip by its ID")
    @PutMapping("/{Id}")
    public TripDTO UpdateAll(@PathVariable Integer Id,@RequestBody TripDTOWithOutId tripDTOWithOutId) {
        return tripService.TripUpdateAll(Id,tripDTOWithOutId);
    }
}
