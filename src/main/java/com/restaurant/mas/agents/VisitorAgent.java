package com.restaurant.mas.agents;

public class VisitorAgent extends Agent {

    public VisitorAgent(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println(getName() + " размещает заказ.");

    }
}
