package com.jimsuplee.ufos2025;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  private final UfosightingService ufosightingService;

  public ApiController(UfosightingService ufosightingService) {
    this.ufosightingService = ufosightingService;
  }

  @GetMapping("/api/ufosightings")
  public List<UfosightingEntity> all() {
    return ufosightingService.getUfosightings();
  }

  @PostMapping("/api/ufosightings")
  public UfosightingEntity newUfosighting(@RequestBody NewUfosighting newUfosighting) {
    return ufosightingService.create(newUfosighting);
  }
}
