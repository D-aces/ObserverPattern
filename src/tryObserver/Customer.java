package tryObserver;

import java.util.ArrayList;

public class Customer extends Observer
{
	private String customerName;
	private Store favouriteStore;
	float discount;
	private ArrayList<Store> registeredStores;
	public Customer(String customerName, Store favouriteStore) 
	{
		registeredStores = new ArrayList<Store>();
		register(favouriteStore);
		this.customerName = customerName;
		this.favouriteStore = favouriteStore;
	}
	
	public void register(Store newStore) 
	{
		registeredStores.add(newStore);
		System.out.println("Added Store: " + registeredStores.get(registeredStores.indexOf(newStore)).name);
	}
	
	public void unregister(Store removeStore) 
	{
		System.out.println("Removed Store: " + registeredStores.get(registeredStores.indexOf(removeStore)).name);
		registeredStores.remove(registeredStores.indexOf(removeStore));
		
	}
	
	public void update(float discount) 
	{
		this.discount = discount;
		System.out.println(String.format("The discount is now %f.  Thank you, %s! ", discount, customerName));
	}

	public void printRegisteredStores() {
		if(registeredStores.isEmpty()) {
			System.out.println("Empty");
		}
		else {
		for(Store s : registeredStores) {
			System.out.println(s.name);
		}
		}
	}
	
	public void setFavouriteStore(Store favouriteStore) 
	{
		this.favouriteStore = favouriteStore;
	}

	public Store getFavoriteStore() 
	{
		return this.favouriteStore;
	}
}
