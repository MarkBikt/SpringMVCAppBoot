package ru.mark.springwebapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mark.springwebapp.models.User;
import ru.mark.springwebapp.service.UserService;


import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "users/index";
    }
    @GetMapping("/users/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "users/show";
    }
    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }
    @PostMapping("/users")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "users/edit";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.update(id, user);
        return "redirect:/users/{id}";
    }

    @DeleteMapping("users/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
//1. Написать CRUD-приложение. Использовать Spring MVC + Hibernate.
//2. Должен быть класс User с произвольными полями (id, name и т.п.).
//3. В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять, удалять и изменять юзера.
//4. Конфигурация Spring через JavaConfig и аннотации, по аналогии с предыдущими проектами.
// Без использования xml. Без Spring Boot.
//5. Внесите изменения в конфигурацию для работы с базой данных. Вместо SessionFactory должен использоваться EntityManager.

//@GetMapping() зачем пустой конструктор
//модель всегда эевалс и хешкод
//public interface UserRepository extends JpaRepository<User, Integer>
// у тебя есть четкое задание что нужно использовать в качестве дао