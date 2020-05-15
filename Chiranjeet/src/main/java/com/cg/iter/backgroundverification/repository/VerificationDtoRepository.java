package com.cg.iter.backgroundverification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.backgroundverification.dto.VerficationDto;

public interface VerificationDtoRepository extends JpaRepository<VerficationDto, Integer> 
{

}
