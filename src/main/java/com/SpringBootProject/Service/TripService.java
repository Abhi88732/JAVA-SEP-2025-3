package com.SpringBootProject.Service;

import com.SpringBootProject.DTO.TripDTO;
import com.SpringBootProject.DTO.TripDTOWithOutId;
import com.SpringBootProject.Entity.TripEntity;
import com.SpringBootProject.Mapper.MapperConfig;
import com.SpringBootProject.Repository.TripRespository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripService {
    public final TripRespository tripRespository;
    public final MapperConfig mapperConfig;
    public TripDTO save(@Valid TripDTOWithOutId tripDTOWithOutId) {
         TripEntity tripEntity =mapperConfig.getModelMapper().map(tripDTOWithOutId,TripEntity.class);
         return mapperConfig.getModelMapper().map(tripRespository.save(tripEntity),TripDTO.class);
    }
}
