package com.rc.publicrestrooms.domain.restroom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Restroom {

	private Long id;

	private String name;
	private String address;

	private Double latitude;
	private Double longitude;

	private Boolean open24h;
	private Boolean disabled;
	private Boolean free;

	private String managementOrg;
}
