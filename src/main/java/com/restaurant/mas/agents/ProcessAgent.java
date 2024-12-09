package com.restaurant.mas.agents;

import com.restaurant.mas.model.LogEntry;
import com.restaurant.mas.utils.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessAgent extends Agent {
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);
    private static final List<LogEntry> logs = new ArrayList<>();
    private CookAgent assignedCook;

    public ProcessAgent(String name) {
        super(name);
    }

    public void assignCook(CookAgent cook) {
        this.assignedCook = cook;
        cook.addTask();
        logs.add(new LogEntry(getName(), cook.getName(), "Назначенный"));
        System.out.println(getName() + " назначенный для " + cook.getName());
    }

    @Override
    public void execute() {
        executor.submit(() -> {
            logs.add(new LogEntry(getName(), assignedCook != null ? assignedCook.getName() : "Неназначенный", "Начатый"));
            performOperation();
            logs.add(new LogEntry(getName(), assignedCook != null ? assignedCook.getName() : "Неназначенный", "Завершенный"));

            if (assignedCook != null) {
                assignedCook.removeTask();
            }
        });
    }

    private void performOperation() {
        try {
            Thread.sleep(2000);
            System.out.println(getName() + " операция завершена.");
        } catch (InterruptedException e) {
            System.err.println(getName() + " операция прервана.");
        }
    }

    public static void saveLogs(String filePath) throws IOException {
        JsonUtils.writeJsonFile(filePath, logs);
        System.out.println("Журналы, сохраненные в " + filePath);
    }

    public static void shutdown() {
        executor.shutdown();
        System.out.println("Завершение работы исполнителя агента процесса.");
    }
}
