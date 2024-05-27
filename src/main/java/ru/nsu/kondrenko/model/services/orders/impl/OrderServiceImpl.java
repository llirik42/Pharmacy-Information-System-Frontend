package ru.nsu.kondrenko.model.services.orders.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.Order;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.orders.OrderService;
import ru.nsu.kondrenko.model.services.orders.exceptions.OrderServiceException;
import ru.nsu.kondrenko.model.services.orders.requests.OrderCreationRequest;
import ru.nsu.kondrenko.model.services.orders.response.OrderCreationResponse;
import ru.nsu.kondrenko.model.services.orders.response.OrderObtainResponse;
import ru.nsu.kondrenko.model.services.orders.response.OrderPaymentResponse;
import ru.nsu.kondrenko.model.services.orders.response.OrderSearchResponse;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final String address;
    private final int port;

    public OrderServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
    }

    @Override
    public Order findOrder(int orderId) throws OrderServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForEntity(
                    getFindOrderUrl(orderId),
                    OrderSearchResponse.class,
                    orderId
            ).getBody().getOrder();
        } catch (Exception exception) {
            throw new OrderServiceException("Searching for order %s failed".formatted(orderId), exception);
        }
    }

    @Override
    public OrderCreationResponse createOrder(OrderCreationRequest request) throws OrderServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.postForEntity(
                    getOrdersUrl(),
                    request,
                    OrderCreationResponse.class
            ).getBody();
        } catch (Exception exception) {
            throw new OrderServiceException("Creation of order %s failed".formatted(request), exception);
        }
    }

    @Override
    public List<Order> getOrders() throws OrderServiceException {
        return fetchOrders(
                getOrdersUrl(),
                "Fetching orders failed"
        );
    }

    @Override
    public List<Order> getForgottenOrders() throws OrderServiceException {
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
    public OrderPaymentResponse payOrder(int orderId) throws OrderServiceException {
        return postOrderPayment(
                getPayForOrderUrl(orderId),
                null,
                "Payment of order failed"
        );
    }

    @Override
    public OrderObtainResponse obtainOrder(int orderId) throws OrderServiceException {
        return postOrderObtain(
                getObtainOrderUrl(orderId),
                null,
                "Obtaining order failed"
        );
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

    private OrderPaymentResponse postOrderPayment(String url, Object request, String errorMessage) throws OrderServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.postForEntity(
                    url,
                    request,
                    OrderPaymentResponse.class
            ).getBody();
        } catch (Exception exception) {
            throw new OrderServiceException(errorMessage, exception);
        }
    }

    private OrderObtainResponse postOrderObtain(String url, Object request, String errorMessage) throws OrderServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.postForEntity(
                    url,
                    request,
                    OrderObtainResponse.class
            ).getBody();
        } catch (Exception exception) {
            throw new OrderServiceException(errorMessage, exception);
        }
    }

    private String getOrdersUrl() {
        return String.format("http://%s:%s/orders/", address, port);
    }

    private String getOrderUrl(int orderId) {
        return getOrdersUrl() + String.format("%s/", orderId);
    }

    private String getForgottenOrdersUrl() {
        return getOrdersUrl() + "/forgotten/";
    }

    private String getOrdersInProductionUrl() {
        return getOrdersUrl() + "/production/";
    }

    private String getOrderCustomersUrl(int orderId) {
        return getOrderUrl(orderId) + "customers";
    }

    private String getPayForOrderUrl(int orderId) {
        return getOrderUrl(orderId) + "/payment";
    }

    private String getObtainOrderUrl(int orderId) {
        return getOrderUrl(orderId) + "/obtain";
    }

    private String getFindOrderUrl(int orderId) {
        return getOrdersUrl() + "/search?order_id=%s".formatted(orderId);
    }
}
