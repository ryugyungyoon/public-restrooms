package com.rc.publicrestrooms.repository.restroom;

import com.rc.publicrestrooms.domain.restroom.Restroom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RestroomRepository {

    List<Restroom> findNearby(
            @Param("lat") double lat,
            @Param("lng") double lng,
            @Param("radius") int radius
    );
}
