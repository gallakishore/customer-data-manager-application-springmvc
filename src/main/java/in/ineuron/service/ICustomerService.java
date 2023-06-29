package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Customer;

public interface ICustomerService {

	public List<Customer> getCustomerlist();

	public Customer saveCustomer(Customer customer);

	public Customer selectCustomerById(Integer sid);

	public String deleteCustomer(Integer sid);
}
