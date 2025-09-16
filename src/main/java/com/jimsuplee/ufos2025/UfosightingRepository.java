package com.jimsuplee.ufos2025;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UfosightingRepository extends JpaRepository<UfosightingEntity, Long> {

  List<UfosightingEntity> findByLocationcityContainsIgnoreCase(String partialLocationcity);

  List<UfosightingEntity> findByShapeContainsIgnoreCase(String partialShape);

  List<UfosightingEntity> findByLocationcityContainsOrShapeContainsAllIgnoreCase(String partialLocationcity,
    String partialShape);
  @Override
  void delete(UfosightingEntity entity);
}
