package com.SpringBootProject.Service;

import com.SpringBootProject.DTO.TripDTO;
import com.SpringBootProject.DTO.TripDTOWithOutId;
import com.SpringBootProject.Entity.TripEntity;
import com.SpringBootProject.TripRepository.TRespository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripService {
      public final TRespository tRespository;
      public final Mapper MapperConfig;

    public TripDTO save(@Valid TripDTOWithOutId tripDTOWithOutId) {
//          TripEntity tripEntity=MapperConfig.map(tripDTOWithOutId,TripEntity.class);
       return null;
    }
}
