package ru.nsu.kondrenko.model.services.customers.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.nsu.kondrenko.model.dto.Customer;
import ru.nsu.kondrenko.model.dto.FrequentCustomer;
import ru.nsu.kondrenko.model.services.ServiceConfig;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.customers.exceptions.CustomerServiceException;
import ru.nsu.kondrenko.model.services.customers.requests.CustomerCreationRequest;
import ru.nsu.kondrenko.model.services.customers.responses.CustomerCreationResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final String address;
    private final int port;
    private final SimpleDateFormat simpleDateFormat;

    public CustomerServiceImpl(ServiceConfig config) {
        address = config.getAddress();
        port = config.getPort();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public List<Customer> getCustomers() throws CustomerServiceException {
        return fetchCustomers(
                getCustomersUrl(),
                "Fetching all customers failed"
        );
    }

    @Override
    public Customer findCustomer(int customerId) throws CustomerServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.postForEntity(
                    getCustomerSearchUrl(),
                    null,
                    Customer.class,
                    customerId
            ).getBody();
        } catch (Exception exception) {
            throw new CustomerServiceException("Searching of customer %s failed".formatted(customerId), exception);
        }
    }

    @Override
    public CustomerCreationResponse createCustomer(CustomerCreationRequest request) throws CustomerServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.postForEntity(
                    getCustomersUrl(),
                    request,
                    CustomerCreationResponse.class
            ).getBody();
        } catch (Exception exception) {
            throw new CustomerServiceException(
                    "Creation of customer %s failed".formatted(request),
                    exception
            );
        }
    }

    @Override
    public List<Customer> getWaitingSuppliesCustomers(Integer drugTypeId) throws CustomerServiceException {
        return fetchCustomers(
                getWaitingSuppliesCustomersUrl(drugTypeId),
                "Fetching waiting supplies customers failed"
        );
    }

    @Override
    public List<Customer> getOrderedSomethingCustomers(Date periodStart, Date periodEnd, Integer drugId, Integer drugTypeId) throws CustomerServiceException {
        return fetchCustomers(
                getOrderedSomethingCustomersUrl(
                        periodStart,
                        periodEnd,
                        drugId,
                        drugTypeId
                ),
                "Fetching ordered something customers failed"
        );
    }

    @Override
    public List<FrequentCustomer> getFrequentCustomers(Integer drugId, Integer drugTypeId) throws CustomerServiceException {
        return fetchFrequentCustomers(
                getFrequentCustomersUrl(
                        drugId,
                        drugTypeId
                ),
                "Fetching frequent customers failed"
        );
    }

    private List<Customer> fetchCustomers(String url, String errorMessage) throws CustomerServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Customer>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new CustomerServiceException(errorMessage, exception);
        }
    }

    private List<FrequentCustomer> fetchFrequentCustomers(String url, String errorMessage) throws CustomerServiceException {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<FrequentCustomer>>() {

                    }
            ).getBody();
        } catch (Exception exception) {
            throw new CustomerServiceException(errorMessage, exception);
        }
    }

    private String getCustomersUrl() {
        return String.format("http://%s:%s/customers/", address, port);
    }

    private String getWaitingSuppliesCustomersUrl(Integer drugTypeId) {
        final String baseUrl = String.format("http://%s:%s/customers/waiting-supplies", address, port);

        if (drugTypeId == null) {
            return baseUrl;
        }

        return String.format("%s?drug_type_id=%s", baseUrl, drugTypeId);
    }

    private String getOrderedSomethingCustomersUrl(Date periodStart, Date periodEnd, Integer drugId, Integer drugTypeId) {
        String url = String.format("http://%s:%s/customers/ordered-something", address, port);

        url = String.format(
                "%s?period_start=%s&period_end=%s",
                url,
                simpleDateFormat.format(periodStart),
                simpleDateFormat.format(periodEnd)
        );

        if (drugId != null) {
            url = String.format("%s&drug_id=%s", url, drugId);
        }
        if (drugTypeId != null) {
            url = String.format("%s&drug_type_id=%s", url, drugTypeId);
        }

        return url;
    }

    private String getFrequentCustomersUrl(Integer drugId, Integer drugTypeId) {
        final boolean isDrugNotNull = drugId != null;
        final boolean isTypeNotNull = drugTypeId != null;

        String url = String.format("http://%s:%s/customers/frequent", address, port);

        if (isDrugNotNull || isTypeNotNull) {
            url = String.format("%s?", url);
        }

        if (isDrugNotNull) {
            url = String.format("%sdrug_id=%s", url, drugId);
        }

        if (isTypeNotNull) {
            if (isDrugNotNull) {
                url = String.format("%s&", url);
            }

            url = String.format("%sdrug_type_id=%s", url, drugTypeId);
        }

        return url;
    }

    private String getCustomerSearchUrl() {
        return getCustomersUrl() + "/search";
    }
}
