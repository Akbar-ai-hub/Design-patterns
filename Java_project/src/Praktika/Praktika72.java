package Praktika;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

interface IMediator {
    void sendMessage(String message, IUser sender, String channelName);
    void sendPrivateMessage(String message, IUser sender, IUser receiver);
    void addUserToChannel(IUser user, String channelName);
    void removeUserFromChannel(IUser user, String channelName);
    void createChannel(String channelName);
}

interface IUser {
    String getName();
    void sendMessage(String message, String channelName);
    void sendPrivateMessage(String message, IUser receiver);
    void receiveMessage(String message, IUser sender, String channelName);
    void receiveNotification(String notification);
}

class User1 implements IUser {
    protected IMediator mediator;
    protected String name;
    protected boolean isBlocked;

    public User1(IMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        this.isBlocked = false;
    }

    public String getName() {
        return name;
    }

    public void setBlocked(boolean blocked) {
        this.isBlocked = blocked;
    }

    @Override
    public void sendMessage(String message, String channelName) {
        if (!isBlocked) {
            System.out.println(name + " отправляет сообщение в канал " + channelName + ": " + message);
            mediator.sendMessage(message, this, channelName);
        } else {
            System.out.println(name + " заблокирован и не может отправлять сообщения.");
        }
    }

    @Override
    public void sendPrivateMessage(String message, IUser receiver) {
        if (!isBlocked) {
            System.out.println(name + " отправляет личное сообщение " + receiver.getName() + ": " + message);
            mediator.sendPrivateMessage(message, this, receiver);
        } else {
            System.out.println(name + " заблокирован и не может отправлять сообщения.");
        }
    }

    @Override
    public void receiveMessage(String message, IUser sender, String channelName) {
        System.out.println(name + " получил сообщение от " + sender.getName() + " в канале " + channelName + ": " + message);
    }

    @Override
    public void receiveNotification(String notification) {
        System.out.println(name + " получил уведомление: " + notification);
    }
}

class ChannelMediator implements IMediator {
    private Map<String, Set<IUser>> channels = new HashMap<>();

    @Override
    public void sendMessage(String message, IUser sender, String channelName) {
        if (!channels.containsKey(channelName)) {
            System.out.println("Канал " + channelName + " не существует.");
            return;
        }
        if (!channels.get(channelName).contains(sender)) {
            System.out.println(sender.getName() + " не состоит в канале " + channelName + ".");
            return;
        }
        for (IUser user : channels.get(channelName)) {
            if (user != sender) {
                user.receiveMessage(message, sender, channelName);
            }
        }
    }

    @Override
    public void sendPrivateMessage(String message, IUser sender, IUser receiver) {
        receiver.receiveMessage(message, sender, "Личное сообщение");
    }

    @Override
    public void addUserToChannel(IUser user, String channelName) {
        channels.computeIfAbsent(channelName, k -> new HashSet<>()).add(user);
        notifyAllUsers(user.getName() + " присоединился к каналу " + channelName, channelName);
    }

    @Override
    public void removeUserFromChannel(IUser user, String channelName) {
        if (channels.containsKey(channelName) && channels.get(channelName).remove(user)) {
            notifyAllUsers(user.getName() + " покинул канал " + channelName, channelName);
        } else {
            System.out.println("Ошибка: Пользователь не найден в канале " + channelName);
        }
    }

    @Override
    public void createChannel(String channelName) {
        channels.putIfAbsent(channelName, new HashSet<>());
        System.out.println("Канал " + channelName + " создан.");
    }

    private void notifyAllUsers(String notification, String channelName) {
        for (IUser user : channels.getOrDefault(channelName, new HashSet<>())) {
            user.receiveNotification(notification);
        }
    }

    public void blockUser(IUser user) {
        if (user instanceof User1) {
            ((User1) user).setBlocked(true);
            System.out.println(user.getName() + " заблокирован.");
        }
    }
}

public class Praktika72 {
    public static void main(String[] args) {
        ChannelMediator mediator = new ChannelMediator();

        IUser alice = new User1(mediator, "Alice");
        IUser bob = new User1(mediator, "Bob");
        IUser charlie = new User1(mediator, "Charlie");

        mediator.createChannel("General");
        mediator.createChannel("Sports");

        mediator.addUserToChannel(alice, "General");
        mediator.addUserToChannel(bob, "General");
        mediator.addUserToChannel(charlie, "Sports");

        alice.sendMessage("Привет всем!", "General");
        bob.sendPrivateMessage("Привет, Алиса!", alice);

        mediator.addUserToChannel(alice, "Sports");
        alice.sendMessage("Какой матч идет?", "Sports");

        mediator.blockUser(bob);
        bob.sendMessage("Это сообщение не должно быть отправлено.", "General");

        mediator.removeUserFromChannel(charlie, "Sports");
        charlie.sendMessage("Пока всем!", "Sports");
    }
}
