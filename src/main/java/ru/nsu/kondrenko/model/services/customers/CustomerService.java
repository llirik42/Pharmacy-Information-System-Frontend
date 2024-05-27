package ru.nsu.kondrenko.model.services.customers;

import ru.nsu.kondrenko.model.dto.Customer;
import ru.nsu.kondrenko.model.dto.FrequentCustomer;
import ru.nsu.kondrenko.model.services.customers.exceptions.CustomerServiceException;
import ru.nsu.kondrenko.model.services.customers.requests.CustomerCreationRequest;
import ru.nsu.kondrenko.model.services.customers.responses.CustomerCreationResponse;

import java.util.Date;
import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers() throws CustomerServiceException;

    Customer findCustomer(int customerId) throws CustomerServiceException;

    CustomerCreationResponse createCustomer(CustomerCreationRequest request) throws CustomerServiceException;

    List<Customer> getWaitingSuppliesCustomers(Integer drugTypeId) throws CustomerServiceException;

    List<Customer> getOrderedSomethingCustomers(Date periodStart, Date periodEnd, Integer drugId, Integer drugTypeId) throws CustomerServiceException;

    List<FrequentCustomer> getFrequentCustomers(Integer drugId, Integer drugTypeId) throws CustomerServiceException;
}
