package com.algaworks.algalog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Occurrence;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long>{

}
