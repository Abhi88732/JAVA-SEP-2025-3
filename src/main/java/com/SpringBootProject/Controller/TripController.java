package com.SpringBootProject.Controller;

import com.SpringBootProject.DTO.TripDTO;
import com.SpringBootProject.DTO.TripDTOWithOutId;
import com.SpringBootProject.Entity.Status;
import com.SpringBootProject.Entity.TripEntity;
import com.SpringBootProject.Service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/{Id:[0-9]+}")
    public TripDTO GetDataById(@PathVariable Integer Id){
        return tripService.GetTripByID(Id);
    }

    @Operation(summary = "Update All Trip",description = "Update an existing trip by its ID")
    @PutMapping("/{Id:[0-9]+}")
    public TripDTO UpdateAll(@PathVariable Integer Id,@RequestBody TripDTOWithOutId tripDTOWithOutId) {
        return tripService.TripUpdateAll(Id,tripDTOWithOutId);
    }
    @DeleteMapping("/{Id:[0-9]+}")
    public void deleteDataById(@PathVariable Integer Id){
        tripService.TripDelete(Id);
    }

    @GetMapping("/search")
    public List<TripEntity> SearchStudent(@RequestParam String destination){
        if(destination!=null&&!destination.equals("")) {
            return tripService.findByDestination(destination);
        }
        return tripService.tripRespository.findAll();
    }
    @GetMapping("/filter")
    public List<TripEntity> filter(@RequestParam Status status) {
        return tripService.filterByStatus(status);
    }
    @GetMapping("/daterange")
    public List<TripEntity> getTripsBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return tripService.getTripsBetweenDates(startDate, endDate);
    }
    @Operation(summary = "Trip Summary",description = "Returns total trips,minimum price,maximum price,average price")
    @GetMapping("/summary")
    public Map<String, Object> getTripSummary() {
        return tripService.getTripSummary();
    }
}
