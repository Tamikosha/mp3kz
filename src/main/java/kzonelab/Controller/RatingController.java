package kzonelab.Controller;

import kzonelab.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/ratings")
    public String listRatings(Model model) {
        model.addAttribute("ratings", ratingService.getAllRatings());
        return "rating/list";
    }


}

