package ru.nsu.kondrenko.model.services.orders.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.Customer;
import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.dto.Prescription;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.orders.OrderResponse;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final String address;
    private final int port;

    public OrderServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
    }

    @Override
    public List<Order> getOrders() throws OrderServiceException {
        return fetchOrders(
                getOrdersUrl(),
                "Fetching orders failed"
        );
    }

    @Override
    public List<Order> getForgotterOrders() throws OrderServiceException {
        return fetchOrders(
                getForgottenOrdersUrl(),
                "Fetching forgotten orders failed"
        );
    }

    @Override
    public List<Order> getOrdersInProduction() throws OrderServiceException {
        return fetchOrders(
                getOrdersInProductionUrl(),
                "Fetching orders in production failed"
        );
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

    private List<Order> fetchOrders(String url, String errorMessage) throws OrderServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Order>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new OrderServiceException(errorMessage, exception);
        }
    }

    private String getOrdersUrl() {
        return String.format("http://%s:%s/orders/", address, port);
    }

    private String getForgottenOrdersUrl() {
        return getOrdersUrl() + "/forgotten/";
    }

    private String getOrdersInProductionUrl() {
        return getOrdersUrl() + "/production/";
    }
}
