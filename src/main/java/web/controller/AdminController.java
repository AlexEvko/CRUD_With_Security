package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;

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
    public String getUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.findAll());
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

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("all_roles", roleService.findAll());
        return "edit";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }
}
