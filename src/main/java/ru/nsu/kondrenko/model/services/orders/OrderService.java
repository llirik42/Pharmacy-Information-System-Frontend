package ru.nsu.kondrenko.model.services.orders;

import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;
import ru.nsu.kondrenko.model.services.orders.requests.OrderCreationRequest;
import ru.nsu.kondrenko.model.services.orders.response.OrderCreationResponse;
import ru.nsu.kondrenko.model.services.orders.response.OrderObtainResponse;
import ru.nsu.kondrenko.model.services.orders.response.OrderPaymentResponse;

import java.util.List;

public interface OrderService {
    Order findOrder(int orderId) throws OrderServiceException;

    OrderCreationResponse createOrder(OrderCreationRequest request) throws OrderServiceException;

    List<Order> getOrders() throws OrderServiceException;

    List<Order> getForgottenOrders() throws OrderServiceException;

    List<Order> getOrdersInProduction() throws OrderServiceException;

    OrderPaymentResponse payOrder(int orderId) throws OrderServiceException;

    OrderObtainResponse obtainOrder(int orderId) throws OrderServiceException;
}
