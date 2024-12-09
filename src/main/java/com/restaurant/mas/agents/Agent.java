package com.restaurant.mas.agents;

public abstract class Agent {
    private String name;

    public Agent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute();

    public void sendMessage(Agent recipient, String message) {
        System.out.println(this.name + " отправлено сообщение на " + recipient.getName() + ": " + message);
    }
}
