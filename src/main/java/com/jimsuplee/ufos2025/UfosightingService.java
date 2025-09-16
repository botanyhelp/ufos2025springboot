package com.jimsuplee.ufos2025;

import jakarta.annotation.PostConstruct;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

@Service
public class UfosightingService {

  private final UfosightingRepository repository;
  //private Integer currentPage = 0;

  public UfosightingService(UfosightingRepository repository) {
    this.repository = repository;
  }

	public Page<UfosightingEntity> getUfosightingsPage(Integer page) {
		Integer size = 5;
	    if (page == null) {
		       page = 0;
		}
	    Long totalRecords = repository.count();
	    //this.currentPage = page;
		//int page = 0; // zero-based page index.
		Pageable pageable = PageRequest.of(page, size);
		Page<UfosightingEntity> ufosightingsPage = repository.findAll(pageable);
		return ufosightingsPage;
	}

  public List<UfosightingEntity> getUfosightings() {
    return repository.findAll();
  }

  public UfosightingEntity create(NewUfosighting newUfosighting) {
    return repository.saveAndFlush(new UfosightingEntity(newUfosighting.sightedatyear(), newUfosighting.sightedatmonth(), newUfosighting.sightedatday(), newUfosighting.reportedat(), newUfosighting.locationcity(), newUfosighting.locationstate(), newUfosighting.shape(), newUfosighting.duration(), newUfosighting.description()));
  }
  
  public void delete(Long ufosightingId) {
	    repository.findById(ufosightingId).map(ufosightingEntity -> {
	        repository.delete(ufosightingEntity);
	        return true;
	      }).orElseThrow(() -> new RuntimeException("No ufosighting at " + ufosightingId));
	  }
  
  public List<UfosightingEntity> search(UfosightingSearch ufosightingSearch) {
    if (StringUtils.hasText(ufosightingSearch.locationcity()) && StringUtils.hasText(ufosightingSearch.shape())) {
      return repository.findByLocationcityContainsOrShapeContainsAllIgnoreCase(ufosightingSearch.locationcity(), ufosightingSearch.shape());
    }

    if (StringUtils.hasText(ufosightingSearch.locationcity())) {
      return repository.findByLocationcityContainsIgnoreCase(ufosightingSearch.locationcity());
    }

    if (StringUtils.hasText(ufosightingSearch.shape())) {
      return repository.findByShapeContainsIgnoreCase(ufosightingSearch.shape());
    }

    return Collections.emptyList();
  }

  public List<UfosightingEntity> search(UniversalSearch search) {
    UfosightingEntity probe = new UfosightingEntity();
    if (StringUtils.hasText(search.value())) {
    	probe.setDescription(search.value());
      probe.setLocationcity(search.value());
      probe.setShape(search.value());
    }
    Example<UfosightingEntity> example = Example.of(probe,ExampleMatcher.matchingAny().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
    return repository.findAll(example);
  }

	/*
	 * @PostConstruct void initDatabase() { repository.save(new
	 * UfosightingEntity("Need HELP with your SPRING BOOT 3 App?",
	 * "SPRING BOOT 3 will only speed things up and make it super SIMPLE to serve templates and raw data."
	 * )); repository.save(new UfosightingEntity("Don't do THIS to your own CODE!",
	 * "As a pro developer, never ever EVER do this to your code. Because you'll ultimately be doing it to YOURSELF!"
	 * )); repository.save(new UfosightingEntity("SECRETS to fix BROKEN CODE!",
	 * "Discover ways to not only debug your code, but to regain your confidence and get back in the game as a software developer."
	 * )); }
	 */
}
