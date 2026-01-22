package com.rc.publicrestrooms.domain.restroom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestroomDto {

    private Long id;
    private String name;
    private String address;

    private Double latitude;
    private Double longitude;

    private Integer distance; // meter

    private Boolean open24h;
    private Boolean disabled;
}
