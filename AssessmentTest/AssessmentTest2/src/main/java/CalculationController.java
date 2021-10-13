import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculationController {

    @GetMapping("/surface")
    public String surfaceOrAreaOfCube(
            @RequestParam int width,
            Model model
    ){
        int area = Methods.calculateSurfaceAreaOrVolumeOfCube(true, width);
        model.addAttribute("area", "The surface area is " + area);
        return "result";
    }
}
