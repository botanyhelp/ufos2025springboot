package com.jimsuplee.ufos2025;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
class UfosightingEntity {
	private @Id @GeneratedValue Long id;
	private Integer sightedatyear;
	private Integer sightedatmonth;
	private Integer sightedatday;
	private Integer reportedat;
	private String locationcity;
	private String locationstate;
	private String shape;
	private String duration;
	@Column(columnDefinition = "text") private String description;

	protected UfosightingEntity() {
		this(null, null, null, null, null, null, null, null, null);
	}

	UfosightingEntity(Integer sightedatyear, Integer sightedatmonth, Integer sightedatday, Integer reportedat,
			String locationcity, String locationstate, String shape, String duration, String description) {
		this.id = null;
		this.sightedatyear = sightedatyear;
		this.sightedatmonth = sightedatmonth;
		this.sightedatday = sightedatday;
		this.reportedat = reportedat;
		this.locationcity = locationcity;
		this.locationstate = locationstate;
		this.shape = shape;
		this.duration = duration;
	    this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSightedatyear() {
		return sightedatyear;
	}

	public void setSightedatyear(Integer sightedatyear) {
		this.sightedatyear = sightedatyear;
	}

	public Integer getSightedatmonth() {
		return sightedatmonth;
	}

	public void setSightedatmonth(Integer sightedatmonth) {
		this.sightedatmonth = sightedatmonth;
	}

	public Integer getSightedatday() {
		return sightedatday;
	}

	public void setSightedatday(Integer sightedatday) {
		this.sightedatday = sightedatday;
	}

	public Integer getReportedat() {
		return reportedat;
	}

	public void setReportedat(Integer reportedat) {
		this.reportedat = reportedat;
	}

	public String getLocationcity() {
		return locationcity;
	}

	public void setLocationcity(String locationcity) {
		this.locationcity = locationcity;
	}

	public String getLocationstate() {
		return locationstate;
	}

	public void setLocationstate(String locationstate) {
		this.locationstate = locationstate;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
