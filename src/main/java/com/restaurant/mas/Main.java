package com.restaurant.mas;

import com.restaurant.mas.agents.CookAgent;
import com.restaurant.mas.agents.ProcessAgent;
import com.restaurant.mas.agents.SupervisorAgent;
import com.restaurant.mas.model.VisitorOrder;
import com.restaurant.mas.model.VisitorOrderList;
import com.restaurant.mas.model.ProductList;
import com.restaurant.mas.utils.JsonUtils;
import com.restaurant.mas.utils.ErrorLogger;
import com.restaurant.mas.utils.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(4); // Пул потоков для параллельной обработки

    public static void main(String[] args) {
        try {

            VisitorOrderList orderList = loadOrders();
            ProductList productList = loadProducts();

            List<CookAgent> cooks = createCooks();
            SupervisorAgent supervisor = new SupervisorAgent("Руководитель", productList);

            List<Future<Boolean>> futures = new ArrayList<>();


            for (VisitorOrder order : orderList.getVisitorsOrders()) {
                futures.add(executorService.submit(() -> processOrder(order, supervisor, cooks)));
            }


            for (Future<Boolean> future : futures) {
                try {
                    Boolean result = future.get();
                    if (!result) {
                        System.err.println("Не удалось обработать заказ.");
                    }
                } catch (ExecutionException | InterruptedException e) {
                    System.err.println("Ошибка при обработке заказа: " + e.getMessage());
                }
            }


            ProcessAgent.saveLogs("process_logs.json");

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            ErrorLogger.logError("Main", "Execution", e.getMessage());
        } finally {

            ProcessAgent.shutdown();
            executorService.shutdown();
            System.out.println("Программа успешно завершена.");
        }
    }

    private static VisitorOrderList loadOrders() {
        try {
            VisitorOrderList orderList = JsonUtils.readJsonFile("src/main/resources/visitors_orders.json", VisitorOrderList.class);
            System.out.println("Заказы успешно загружены.");
            return orderList;
        } catch (Exception e) {
            ErrorLogger.logError("visitors_orders.json", "Invalid data", "Ошибка загрузки заказов.");
            throw new RuntimeException("Не удалось загрузить заказы.", e);
        }
    }

    private static ProductList loadProducts() {
        try {
            ProductList productList = JsonUtils.readJsonFile("src/main/resources/products.json", ProductList.class);
            System.out.println("Список продуктов успешно загружен.");
            return productList;
        } catch (Exception e) {
            ErrorLogger.logError("products.json", "Invalid data", "Ошибка загрузки продуктов.");
            throw new RuntimeException("Не удалось загрузить продукты.", e);
        }
    }

    private static List<CookAgent> createCooks() {
        List<CookAgent> cooks = new ArrayList<>();
        cooks.add(new CookAgent("Повар Иван"));
        cooks.add(new CookAgent("Повар Мария"));
        return cooks;
    }

    private static boolean processOrder(VisitorOrder order, SupervisorAgent supervisor, List<CookAgent> cooks) {
        long startTime = System.currentTimeMillis();

        System.out.println("Обработка заказа на " + order.getVisName());

        boolean success = supervisor.createOrder(order.getVisName(), order.getVisOrdDishes(), cooks);
        if (!success) {
            System.err.println("Не удалось обработать заказ на " + order.getVisName());
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Logger.log("Время обработки заказа " + order.getVisName() + ": " + duration + " мс");

        return success;
    }
}
