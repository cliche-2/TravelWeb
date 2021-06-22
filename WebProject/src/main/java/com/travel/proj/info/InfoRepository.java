package com.travel.proj.info;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<InfoBoard, Integer> {
	
	Page<InfoBoard> findAll(Pageable pageable);

}
