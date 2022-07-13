package web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService service, RoleService roleService) {
        this.userService = service;
        this.roleService = roleService;
    }

    @GetMapping
    public String getUsers(@AuthenticationPrincipal User user, Model model,ModelMap modelMap) {
        modelMap.addAttribute("users", userService.findAll());
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAll());
        return "admin-page";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") User user,
                           @RequestParam(value = "role", required = false) String[] roles) {
        setRolesToUser(user, roles);
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("all_roles", roleService.findAll());
        return "create";
    }


    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam(value = "role", required = false) String[] roles) {
        setRolesToUser(user, roles);
        userService.update(user);
        return "redirect:/admin";
    }
    private void setRolesToUser(@ModelAttribute("user") User user,
                                @RequestParam(value = "role", required = false) String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        if (roles != null) {
            for (String roleName : roles) {
                roleSet.add(roleService.findByName(roleName));
            }
        }
        user.setRoles(roleSet);
    }

//    @GetMapping("/create")
//    public String create(@ModelAttribute("user") User user, ModelMap model) {
//        model.addAttribute("all_roles", roleService.findAll());
//        return "create";
//    }


    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @PostMapping("/{id}/delete")
    public String removeUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    private void getUserRoles(User user) {
        user.setRoles(user.getRoles().stream()
                .map(role -> roleService.findByName(role.getName()))
                .collect(Collectors.toSet()));
    }
}
