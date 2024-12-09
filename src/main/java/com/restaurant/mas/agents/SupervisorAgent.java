package com.restaurant.mas.agents;

import com.restaurant.mas.model.ProductList;
import com.restaurant.mas.model.VisitorOrder;

import java.util.ArrayList;
import java.util.List;

public class SupervisorAgent extends Agent {
    private List<ProcessAgent> processes;
    private ProductList productList;

    public SupervisorAgent(String name, ProductList productList) {
        super(name);
        this.processes = new ArrayList<>();
        this.productList = productList;
    }

    public boolean createOrder(String orderName, List<VisitorOrder.OrderDish> dishes, List<CookAgent> cooks) {
        for (VisitorOrder.OrderDish dish : dishes) {
            if (!productList.checkIngredients(dish.getMenuDish())) {
                System.err.println("Недостаточно ингредиентов для приготовления блюда " + dish.getMenuDish());
                return false;
            }

            ProcessAgent process = new ProcessAgent("Процесс приготовления блюда " + dish.getMenuDish());
            assignCook(process, cooks);
            processes.add(process);
        }
        return true;
    }

    private void assignCook(ProcessAgent process, List<CookAgent> cooks) {
        CookAgent leastBusyCook = cooks.stream()
                .min((c1, c2) -> Integer.compare(c1.getWorkload(), c2.getWorkload()))
                .orElseThrow(() -> new RuntimeException("Свободных поваров нет"));

        process.assignCook(leastBusyCook);
    }

    @Override
    public void execute() {
        System.out.println(getName() + " руководит рестораном.");
        for (ProcessAgent process : processes) {
            process.execute();
        }
    }
}
