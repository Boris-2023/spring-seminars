package ru.gb.hw03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw03.domain.User;
import ru.gb.hw03.services.RegistrationService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        // service.processRegistration(user);

        service.processRegistration(user.getName(), user.getAge(), user.getEmail());

        return "User added from Request body!";
    }

    @PostMapping("/params")
    public String userAddByParameters(@RequestParam Map<String, String> params)
    {
        service.processRegistration(params.get("name"), Integer.parseInt(params.get("age")), params.get("email"));

        return "User added from Request parameters!";
    }
}
