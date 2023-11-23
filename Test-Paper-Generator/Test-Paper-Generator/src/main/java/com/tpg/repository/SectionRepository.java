package com.tpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpg.entity.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

}
