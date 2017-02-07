package edu.mum.cs525.finco.customersubsystem.model;

public class Customer implements ICustomer {
	private Address address;
    private String name;
    private String email;

    public Customer(String state, String city, String street, String zip, String name, String email) {
		super();
		this.address = new Address(state,city,street,zip);
		this.name = name;
		this.email = email;
	}

	public Customer(Address address, String name, String email) {
		super();
		this.address = address;
		this.name = name;
		this.email = email;
	}

	public Customer(){
		this.address = new Address("","","","");
		this.name = "";
		this.email = "";
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
}
	}
