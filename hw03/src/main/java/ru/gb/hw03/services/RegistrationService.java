package ru.gb.hw03.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hw03.domain.User;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {

        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    // 1) В класс RegistrationService добавить поля UserService,
    // NotificationService(добавить в IOC контейнер аннотацией @Autowired
    // или через конструктор класса)
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    // 2) Разработать метод processRegistration в котором:
    //- создается пользователь из параметров метода
    //- созданный пользователь добавляется в репозиторий
    //- через notificationService выводится сообщение в консоль

    //   public User processRegistration(User user) {
    public User processRegistration(String name, int age, String email) {

        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("New user added to the list!");

        return user;
    }
}
