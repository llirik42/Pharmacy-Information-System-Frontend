package ru.nsu.kondrenko.model.services.customers.impl;

import ru.nsu.kondrenko.model.dto.Customer;
import ru.nsu.kondrenko.model.services.customers.CustomerService;
import ru.nsu.kondrenko.model.services.customers.exceptions.CustomerServiceException;

import java.util.Date;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> getCustomers() throws CustomerServiceException {
        return List.of();
    }

    @Override
    public List<Customer> getWaitingSuppliesCustomers(Integer drugTypeId) throws CustomerServiceException {
        return List.of();
    }

    @Override
    public List<Customer> getOrderedSomethingCustomers(Date periodStart, Date periodEnd, Integer drugId, Integer drugTypeId) throws CustomerServiceException {
        return List.of();
    }
}
