package rskovbo.rtp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import rskovbo.rtp.model.team.Team;
import rskovbo.rtp.model.user.User;
import rskovbo.rtp.service.user.DataService;
import rskovbo.rtp.service.user.UsernameAlreadyExists;

import javax.security.auth.login.LoginException;

@Controller
public class WebController {

    private final DataService dataService;

    @Autowired
    public WebController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/")
    public String welcome(Model model, WebRequest request) {
        packView(model, request);
        return "index";
    }

    // Already logged in
    @GetMapping("/login")
    public String goToLoginSite() {
        return "login";
    }

    @GetMapping("/register")
    public String goToRegisterSite(Model model, WebRequest request) {
        packView(model, request);
        return "register";
    }

    @GetMapping("/profile")
    public String goToProfile(Model model, WebRequest request) {
        try {
            packView(model, request);
            if (model.getAttribute("user") == null) throw new NullPointerException();
        } catch (NullPointerException e){
            return "redirect:/login";
        }

        return "profile";
    }

    @PostMapping("/login")
    public String loginUser(Model model, WebRequest request) {
        try {
            String username = request.getParameter("username");
            String pw = request.getParameter("pw");

            User user = dataService.login(username, pw);

            setSessionInfo(request, user);
        } catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
        return "redirect:/profile";
    }

    @GetMapping("/logout")
    public String logoutUser(WebRequest request) {
        request.setAttribute("user", null, WebRequest.SCOPE_SESSION);
        request.setAttribute("id", null, WebRequest.SCOPE_SESSION);
        return "index";
    }

    @PostMapping("/register")
    public String registerUser(WebRequest request, User user, Model model) {
        try {
            model.addAttribute("user", dataService.registerUser(user));
            setSessionInfo(request, user);
            return "profile";
        } catch (UsernameAlreadyExists e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @PostMapping("/registerTeam")
    public String registerTeam(WebRequest request, Team team) {
        Team teamForID = dataService.registerTeam(team);
        User userToUpdate = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
        dataService.setTeam(teamForID, userToUpdate);
        return "redirect:/profile";
    }

    private void setSessionInfo(WebRequest request, User user) {
        // Place user info on session
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        request.setAttribute("id", user.getId(), WebRequest.SCOPE_SESSION);
    }

    private void packView(Model model, WebRequest request) {
        User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
        try {
            Team team = dataService.getTeam(user.getTeamID());
            System.out.println(team.getTeamName());
            model.addAttribute("team", team);
        } catch (Exception ignored) {

        }
        model.addAttribute("user", user);
    }


}
