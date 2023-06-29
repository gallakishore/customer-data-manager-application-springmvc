package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/")
	public String homePage() {
		return "index";
	}

	@GetMapping("/list")
	public String listCustomers(Map<String, Object> model) {
		List<Customer> customersList = service.getCustomerlist();

		customersList.forEach(System.out::println);
		model.put("customersList", customersList);
		return "list-customers";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		System.out.println(customer);
		Customer cus = service.saveCustomer(customer);
		if (cus.getCid() != null)
			return "redirect:/api/customer/list";
		else
			return "error";
	}

	@GetMapping("/showForm")
	public String showForm(Map<String, Object> model) {
		Customer customer = new Customer();
		model.put("customer", customer);
		return "customer-form";
	}

	@GetMapping("/update")
	public String update(Map<String, Object> model) {
		return "";
	}

	@GetMapping("/showFromUpdate")
	public String displayCustomerData(@RequestParam Integer customerId, Map<String, Object> model) {
		Customer customer = service.selectCustomerById(customerId);
		model.put("customer", customer);
		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomerData(@RequestParam Integer customerId) {

		String status = service.deleteCustomer(customerId);
		if (status.equalsIgnoreCase("success")) {
			return "redirect:/api/customer/list";
		} else
			return "error";
	}

}
