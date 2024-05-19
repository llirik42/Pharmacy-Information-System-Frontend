package ru.nsu.kondrenko.model.services.orders;

import ru.nsu.kondrenko.model.dto.Customer;
import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.dto.Prescription;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;

import java.util.List;

public interface OrderService {
    List<Order> getOrders() throws OrderServiceException;

    List<Order> getForgotterOrders() throws OrderServiceException;

    List<Order> getOrdersInProduction() throws OrderServiceException;

    OrderResponse createOrder(Prescription prescription) throws OrderServiceException;

    OrderResponse setOrderCustomer(int orderId, Customer customer) throws OrderServiceException;

    OrderResponse deleteOrderCustomer(int orderId) throws OrderServiceException;

    OrderResponse payForOrder(int orderId) throws OrderServiceException;

    OrderResponse obtainOrder(int orderId) throws OrderServiceException;
}
