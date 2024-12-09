package com.restaurant.mas.agents;

import java.util.concurrent.atomic.AtomicInteger;

public class CookAgent extends Agent {
    private AtomicInteger workload;

    public CookAgent(String name) {
        super(name);
        this.workload = new AtomicInteger(0);
    }

    public int getWorkload() {
        return workload.get();
    }

    public void addTask() {
        workload.incrementAndGet();
    }

    public void removeTask() {
        workload.decrementAndGet();
    }

    @Override
    public void execute() {
        System.out.println(getName() + " доступен с учетом рабочей нагрузки: " + workload);
    }
}
