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
		this.customerName = customerName;
		this.favouriteStore = favouriteStore;
		registeredStores = new ArrayList<Store>();
		register(favouriteStore);
	}
	
	public void register(Store newStore) 
	{
		registeredStores.add(newStore);
		registeredStores.get(registeredStores.indexOf(newStore)).register(this);
	}
	
	public void unregister(Store removeStore) 
	{
		registeredStores.get(registeredStores.indexOf(removeStore)).unregister(this);
		registeredStores.remove(registeredStores.indexOf(removeStore));
	}
	
	public void update(float discount) 
	{
		this.discount = discount;

		System.out.println("The discount is now " + dc.format(discount) + "% off.  Thank you, " + customerName + "!");
	}

	public void printRegisteredStores() 
	{
		if(registeredStores.isEmpty()) 
			System.out.println("Empty");
		else 
		{
			for(Store s : registeredStores) 
				System.out.println(s.name);
		}
	}
	
	public String getName() 
	{
		return customerName;
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
