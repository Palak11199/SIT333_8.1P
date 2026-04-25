package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

    @GetMapping("/")
    public String welcome() {
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        return "view-login";
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        if (LoginService.login(username, password, dob)) {
            return new RedirectView("/q1", true);
        } else {
            redirectAttributes.addFlashAttribute("message", "Wrong credentials");
            return new RedirectView("/login", true);
        }
    }

    // ---------------- Q1 ----------------
    @GetMapping("/q1")
    public String q1View() {
        return "view-q1";
    }

    @PostMapping("/q1")
    public RedirectView q1(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String n1 = request.getParameter("number1");
        String n2 = request.getParameter("number2");
        String res = request.getParameter("result");

        try {
            if (n1 == null || n1.isEmpty() ||
                n2 == null || n2.isEmpty() ||
                res == null || res.isEmpty()) {

                redirectAttributes.addFlashAttribute("message", "Invalid input");
                return new RedirectView("/q1", true);
            }

            Double calc = MathQuestionService.q1Addition(n1, n2);

            if (calc != null && Double.compare(calc, Double.parseDouble(res)) == 0) {
                return new RedirectView("/q2", true);
            } else {
                redirectAttributes.addFlashAttribute("message", "Wrong answer");
                return new RedirectView("/q1", true);
            }

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Invalid input");
            return new RedirectView("/q1", true);
        }
    }

    // ---------------- Q2 ----------------
    @GetMapping("/q2")
    public String q2View() {
        return "view-q2";
    }

    @PostMapping("/q2")
    public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String n1 = request.getParameter("number1");
        String n2 = request.getParameter("number2");
        String res = request.getParameter("result");

        try {
            if (n1 == null || n1.isEmpty() ||
                n2 == null || n2.isEmpty() ||
                res == null || res.isEmpty()) {

                redirectAttributes.addFlashAttribute("message", "Invalid input");
                return new RedirectView("/q2", true);
            }

            Double calc = MathQuestionService.q2Subtraction(n1, n2);

            if (calc != null && Double.compare(calc, Double.parseDouble(res)) == 0) {
                return new RedirectView("/q3", true);
            } else {
                redirectAttributes.addFlashAttribute("message", "Wrong answer");
                return new RedirectView("/q2", true);
            }

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Invalid input");
            return new RedirectView("/q2", true);
        }
    }

    // ---------------- Q3 ----------------
    @GetMapping("/q3")
    public String q3View() {
        return "view-q3";
    }

    @PostMapping("/q3")
    public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String n1 = request.getParameter("number1");
        String n2 = request.getParameter("number2");
        String res = request.getParameter("result");

        try {
            if (n1 == null || n1.isEmpty() ||
                n2 == null || n2.isEmpty() ||
                res == null || res.isEmpty()) {

                redirectAttributes.addFlashAttribute("message", "Invalid input");
                return new RedirectView("/q3", true);
            }

            Double calc = MathQuestionService.q3Multiplication(n1, n2);

            if (calc != null && Double.compare(calc, Double.parseDouble(res)) == 0) {
                return new RedirectView("/success", true);
            } else {
                redirectAttributes.addFlashAttribute("message", "Wrong answer");
                return new RedirectView("/q3", true);
            }

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Invalid input");
            return new RedirectView("/q3", true);
        }
    }

    @GetMapping("/success")
    public String success() {
        return "view-success";
    }
}