package com.restaurant.mas.agents;

import java.util.List;

public class OrderAgent extends Agent {
    private List<String> dishes;

    public OrderAgent(String name, List<String> dishes) {
        super(name);
        this.dishes = dishes;
    }

    @Override
    public void execute() {
        System.out.println(getName() + " оформляет заказ с помощью посуды: " + dishes);
        for (String dish : dishes) {
            ProcessAgent processAgent = new ProcessAgent("Процесс для " + dish);
            processAgent.execute();
        }
    }
    public void estimateWaitingTime() {
        int estimatedTime = dishes.size() * 5; // Допустим, 5 минут на блюдо
        System.out.println(getName() + " расчетное время ожидания: " + estimatedTime + " минут.");
    }

}
