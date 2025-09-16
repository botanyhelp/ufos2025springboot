package com.jimsuplee.ufos2025;
  
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

  private final UfosightingService ufosightingService;

  public HomeController(UfosightingService ufosightingService) {
    this.ufosightingService = ufosightingService;
  }

  @GetMapping("/")
  public String index(Model model) {
    //model.addAttribute("ufosightings", ufosightingService.getUfosightings());
    return "redirect:/page/0";
  }
  
  @GetMapping("/page/{page}")
  public String page(@PathVariable Integer page, Model model) {
    model.addAttribute("ufosightings", ufosightingService.getUfosightingsPage(page));
    if(page < 5) {
    	 model.addAttribute("nextten", page+1);
    }
    if(page > 0) {
        model.addAttribute("lastten", page-1);
    }
   
    //model.addAttribute("page", page+1);
    return "index";
  }

  @PostMapping("/new-ufosighting")
  public String newUfosighting(@ModelAttribute NewUfosighting newUfosighting) {
    ufosightingService.create(newUfosighting);
    return "redirect:/";
  }

  @PostMapping("/multi-field-search")
  public String multiFieldSearch( @ModelAttribute UfosightingSearch search, Model model) {
    List<UfosightingEntity> searchResults = ufosightingService.search(search);
    model.addAttribute("ufosightings", searchResults);
    return "index";
  }

  @PostMapping("/universal-search")
  public String universalSearch(@ModelAttribute UniversalSearch search, Model model) {
    List<UfosightingEntity> searchResults = ufosightingService.search(search);
    model.addAttribute("ufosightings", searchResults);
    return "index";
  }
  @PostMapping("/delete/ufosighting/{ufosightingId}")
  public String deleteVideo(@PathVariable Long ufosightingId) {
    ufosightingService.delete(ufosightingId);
    return "redirect:/";
  }
}
