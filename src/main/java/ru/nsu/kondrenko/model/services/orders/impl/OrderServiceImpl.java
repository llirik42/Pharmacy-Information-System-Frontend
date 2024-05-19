package ru.nsu.kondrenko.model.services.orders.impl;

import ru.nsu.kondrenko.model.dto.Customer;
import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.dto.Prescription;
import ru.nsu.kondrenko.model.services.orders.OrderResponse;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> getOrders() throws OrderServiceException {
        return List.of();
    }

    @Override
    public List<Order> getForgotterOrders() throws OrderServiceException {
        return List.of();
    }

    @Override
    public List<Order> getOrdersInProduction() throws OrderServiceException {
        return List.of();
    }

    @Override
    public OrderResponse createOrder(Prescription prescription) throws OrderServiceException {
        return null;
    }

    @Override
    public OrderResponse setOrderCustomer(int orderId, Customer customer) throws OrderServiceException {
        return null;
    }

    @Override
    public OrderResponse deleteOrderCustomer(int orderId) throws OrderServiceException {
        return null;
    }

    @Override
    public OrderResponse payForOrder(int orderId) throws OrderServiceException {
        return null;
    }

    @Override
    public OrderResponse obtainOrder(int orderId) throws OrderServiceException {
        return null;
    }
}
