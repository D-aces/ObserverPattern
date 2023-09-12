package tryObserver;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Customer extends Observer
{
	private String customerName;
	private Store favouriteStore;
	float discount;
	private ArrayList<Store> registeredStores;
	private NumberFormat dc = new DecimalFormat("0.00");
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
		System.out.println("The discount is now " + dc.format(discount) + "% off.  Thank you, " + customerName + "!");
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
