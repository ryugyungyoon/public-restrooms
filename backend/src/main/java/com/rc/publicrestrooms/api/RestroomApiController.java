package com.rc.publicrestrooms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestroomApiController {

	@GetMapping("/restrooms")
	public List<Map<String, Object>> getRestrooms() {
		return  List.of(
				Map.of(
						"id", 1,
						"name", "서울시청 공공화장실",
						"lat", 37.5658,
						"lng", 126.9770,
						"open24h", true
					),
					Map.of(
						"id", 2,
						"name", "덕수궁 공공화장실",
						"lat", 37.5651,
						"lng", 126.9755,
						"open24h", false
					)
				);
	}
}
