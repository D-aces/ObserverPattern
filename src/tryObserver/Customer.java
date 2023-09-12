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
		this.customerName = customerName;
		this.favouriteStore = favouriteStore;
	}
	
	public void register(Store newStore) 
	{
		registeredStores.add(newStore);
	}
	
	public void unregister(Store removeStore) 
	{
		registeredStores.remove(registeredStores.indexOf(removeStore));
	}
	
	public void update(float discount) 
	{
		this.discount = discount;
		System.out.println(String.format("The discount is now %f%.  Thank you, %s! ", discount, customerName));
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
