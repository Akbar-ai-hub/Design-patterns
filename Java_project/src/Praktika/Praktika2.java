package Praktika;

import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String email;
    private String role;

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', role='" + role + "'}";
    }
}

class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("Пользователь добавлен: " + user);
    }

    public void removeUser(User user) {
        users.remove(user);
        System.out.println("Пользователь " + user + " удален.");
    }

    public void updateUser(String email, String newName, String newRole) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                user.setName(newName);
                user.setRole(newRole);
                System.out.println("Информация о пользователе обновлена: " + user);
                break;
            }
        }
    }
}

public class Praktika2 {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        User user1 = new User("Alice", "alice@example.com", "Admin");
        User user2 = new User("Bob", "bob@example.com", "User");

        userManager.addUser(user1);
        userManager.addUser(user2);

        userManager.updateUser("bob@example.com", "Bobby", "Admin");

        userManager.removeUser(user1);
    }
}

