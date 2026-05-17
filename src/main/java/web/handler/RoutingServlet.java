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

/**
 * Main controller for routing all STEM game pages.
 * Handles login, math questions, date questions,
 * science question, and success page navigation.
 */
@Controller
@RequestMapping("/")
public class RoutingServlet {

    // ======================================================
    // WELCOME + LOGIN
    // ======================================================

    @GetMapping("/")
    public String welcome() {
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        return "view-login";
    }

    /**
     * Handles user login validation.
     */
    @PostMapping("/login")
    public RedirectView login(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        if (LoginService.login(username, password, dob)) {
            return new RedirectView("/q1", true);
        }

        redirectAttributes.addFlashAttribute(
                "message",
                "Wrong credentials"
        );

        return new RedirectView("/login", true);
    }

    // ======================================================
    // QUESTION 1 - ADDITION
    // ======================================================

    @GetMapping("/q1")
    public String q1View() {
        return "view-q1";
    }

    @PostMapping("/q1")
    public RedirectView q1(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        return processMathQuestion(
                request,
                redirectAttributes,
                "/q1",
                "/q2",
                MathQuestionService.q1Addition(
                        request.getParameter("number1"),
                        request.getParameter("number2")
                )
        );
    }

    // ======================================================
    // QUESTION 2 - SUBTRACTION
    // ======================================================

    @GetMapping("/q2")
    public String q2View() {
        return "view-q2";
    }

    @PostMapping("/q2")
    public RedirectView q2(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        return processMathQuestion(
                request,
                redirectAttributes,
                "/q2",
                "/q3",
                MathQuestionService.q2Subtraction(
                        request.getParameter("number1"),
                        request.getParameter("number2")
                )
        );
    }

    // ======================================================
    // QUESTION 3 - MULTIPLICATION
    // ======================================================

    @GetMapping("/q3")
    public String q3View() {
        return "view-q3";
    }

    @PostMapping("/q3")
    public RedirectView q3(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        return processMathQuestion(
                request,
                redirectAttributes,
                "/q3",
                "/q4",
                MathQuestionService.q3Multiplication(
                        request.getParameter("number1"),
                        request.getParameter("number2")
                )
        );
    }

    // ======================================================
    // QUESTION 4 - NEXT DAY
    // ======================================================

    @GetMapping("/q4")
    public String q4View() {
        return "view-q4";
    }

    @PostMapping("/q4")
    public RedirectView q4(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        String answer = MathQuestionService.nextDay(
                request.getParameter("date")
        );

        return processStringQuestion(
                request.getParameter("result"),
                answer,
                "/q4",
                "/q5",
                redirectAttributes
        );
    }

    // ======================================================
    // QUESTION 5 - PREVIOUS WEEK
    // ======================================================

    @GetMapping("/q5")
    public String q5View() {
        return "view-q5";
    }

    @PostMapping("/q5")
    public RedirectView q5(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        String answer = MathQuestionService.previousWeek(
                request.getParameter("date")
        );

        return processStringQuestion(
                request.getParameter("result"),
                answer,
                "/q5",
                "/q6",
                redirectAttributes
        );
    }

    // ======================================================
    // QUESTION 6 - SCIENCE
    // ======================================================

    @GetMapping("/q6")
    public String q6View() {
        return "view-q6";
    }

    @PostMapping("/q6")
    public RedirectView q6(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        String answer = request.getParameter("answer");

        if (MathQuestionService.boilingPoint(answer)) {
            return new RedirectView("/success", true);
        }

        redirectAttributes.addFlashAttribute(
                "message",
                "Wrong answer!"
        );

        return new RedirectView("/q6", true);
    }

    // ======================================================
    // SUCCESS PAGE
    // ======================================================

    @GetMapping("/success")
    public String success() {
        return "view-success";
    }

    // ======================================================
    // HELPER METHODS
    // ======================================================

    /**
     * Reusable method for processing numeric questions.
     */
    private RedirectView processMathQuestion(
            HttpServletRequest request,
            RedirectAttributes redirectAttributes,
            String currentPage,
            String nextPage,
            Double calculatedAnswer) {

        try {

            String result =
                    request.getParameter("result");

            if (calculatedAnswer != null
                    && Double.compare(
                    calculatedAnswer,
                    Double.parseDouble(result)) == 0) {

                return new RedirectView(nextPage, true);
            }

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute(
                    "message",
                    "Invalid input"
            );

            return new RedirectView(currentPage, true);
        }

        redirectAttributes.addFlashAttribute(
                "message",
                "Wrong answer"
        );

        return new RedirectView(currentPage, true);
    }

    /**
     * Reusable method for processing string/date questions.
     */
    private RedirectView processStringQuestion(
            String userAnswer,
            String correctAnswer,
            String currentPage,
            String nextPage,
            RedirectAttributes redirectAttributes) {

        if (correctAnswer != null
                && correctAnswer.equals(userAnswer)) {

            return new RedirectView(nextPage, true);
        }

        redirectAttributes.addFlashAttribute(
                "message",
                "Wrong answer!"
        );

        return new RedirectView(currentPage, true);
    }
}