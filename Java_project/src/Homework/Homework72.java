package Homework;

import java.util.ArrayList;
import java.util.List;

interface IMediator {
    void sendMessage(String message, User sender);
    void sendPrivateMessage(String message, User sender, User receiver);
    void addUser(User user);
    void removeUser(User user);
}

class ChatRoom implements IMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message, sender);
            }
        }
    }

    @Override
    public void sendPrivateMessage(String message, User sender, User receiver) {
        if (users.contains(sender) && users.contains(receiver)) {
            receiver.receivePrivateMessage(message, sender);
        } else {
            System.out.println("Ошибка: Один из пользователей не является участником чата.");
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " присоединился к чату.");
        notifyAllUsers(user.getName() + " присоединился к чату.");
    }

    @Override
    public void removeUser(User user) {
        if (users.remove(user)) {
            System.out.println(user.getName() + " покинул чат.");
            notifyAllUsers(user.getName() + " покинул чат.");
        } else {
            System.out.println("Ошибка: Пользователь не найден в чате.");
        }
    }

    private void notifyAllUsers(String notification) {
        for (User user : users) {
            user.receiveNotification(notification);
        }
    }
}

abstract class User {
    protected IMediator mediator;
    protected String name;

    public User(IMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void send(String message);
    public abstract void sendPrivate(String message, User receiver);
    public abstract void receiveMessage(String message, User sender);
    public abstract void receivePrivateMessage(String message, User sender);
    public abstract void receiveNotification(String notification);
}

class ChatUser extends User {

    public ChatUser(IMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " отправляет сообщение: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void sendPrivate(String message, User receiver) {
        System.out.println(this.name + " отправляет личное сообщение для " + receiver.getName() + ": " + message);
        mediator.sendPrivateMessage(message, this, receiver);
    }

    @Override
    public void receiveMessage(String message, User sender) {
        System.out.println(this.name + " получил сообщение от " + sender.getName() + ": " + message);
    }

    @Override
    public void receivePrivateMessage(String message, User sender) {
        System.out.println(this.name + " получил личное сообщение от " + sender.getName() + ": " + message);
    }

    @Override
    public void receiveNotification(String notification) {
        System.out.println(this.name + " уведомление: " + notification);
    }
}

public class Homework72 {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        User user3 = new ChatUser(chatRoom, "Charlie");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Всем привет!");
        user2.sendPrivate("Привет, Алиса!", user1);

        chatRoom.removeUser(user3);

        user3.send("Это сообщение не должно отправиться, так как пользователь не в чате.");
    }
}
