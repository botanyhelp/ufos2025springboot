package com.jimsuplee.ufos2025;

public record UfosightingSearch(Integer sightedatyear, Integer sightedatmonth, Integer sightedatday,
		Integer reportedat, String locationcity, String locationstate, String shape, String duration,
		String description) {

}
