package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ICustomerDao;
import in.ineuron.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao repo;

	@Override
	public List<Customer> getCustomerlist() {
		return (List<Customer>) repo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public Customer selectCustomerById(Integer sid) {
		Optional<Customer> optional = repo.findById(sid);
		return optional.get();
	}

	@Override
	public String deleteCustomer(Integer sid) {
		Optional<Customer> customer = repo.findById(sid);
		if (customer.isPresent()) {
			repo.deleteById(sid);
			return "success";
		} else {
			return "failure";
		}
	}

}
