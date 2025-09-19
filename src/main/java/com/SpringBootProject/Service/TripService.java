package com.SpringBootProject.Service;

import com.SpringBootProject.DTO.TripDTO;
import com.SpringBootProject.DTO.TripDTOWithOutId;
import com.SpringBootProject.Entity.TripEntity;
import com.SpringBootProject.Mapper.MapperConfig;
import com.SpringBootProject.Repository.TripRespository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<TripEntity> GetAllData(@Valid Pageable pageable) {
        return tripRespository.findAll(pageable);
    }

    public TripDTO GetTripByID(Integer id) {
        TripEntity tripEntity = tripRespository.findById(id).orElseThrow(()->new IllegalArgumentException("This"+id+"Does't exits"));
        return mapperConfig.getModelMapper().map(tripEntity,TripDTO.class);
    }

    public TripDTO TripUpdateAll(Integer id, TripDTOWithOutId tripDTOWithOutId) {
        TripEntity tripEntity=tripRespository.findById(id).orElseThrow(()->new IllegalArgumentException("This"+id+"Does't exits"));
        mapperConfig.getModelMapper().map(tripDTOWithOutId,tripEntity);
        tripEntity= tripRespository.save(tripEntity);
        return mapperConfig.getModelMapper().map(tripEntity,TripDTO.class);
    }
}
