package com.rc.publicrestrooms.service.restroom;

import com.rc.publicrestrooms.domain.restroom.Restroom;
import com.rc.publicrestrooms.domain.restroom.RestroomDto;
import com.rc.publicrestrooms.repository.restroom.RestroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestroomService {

    private final RestroomRepository restroomRepository;

    public List<RestroomDto> findNearby(double lat, double lng, int radius) {

        List<Restroom> restrooms = restroomRepository.findNearby(lat, lng, radius);

        return restrooms.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private RestroomDto toDto(Restroom restroom) {
        RestroomDto dto = new RestroomDto();

        dto.setId(restroom.getId());
        dto.setName(restroom.getName());
        dto.setAddress(restroom.getAddress());
        dto.setLatitude(restroom.getLatitude());
        dto.setLongitude(restroom.getLongitude());

        // distance는 SQL alias로 내려오는 값 → Restroom에 필드 추가해도 되고
        // 지금은 생략하거나 확장 가능

        dto.setOpen24h(restroom.getOpen24h());
        dto.setDisabled(restroom.getDisabled());

        return dto;
    }
}
