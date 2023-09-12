package tryObserver;

import java.util.ArrayList;

public class Store extends Subject 
{
	float discount;
	String name;
	ArrayList<Observer>	ol;
	public Store(String name, float discount) 
	{
		this.name = name;
		this.discount = discount;
		ol = new ArrayList<Observer>();
	}
	
	
	void register(Observer o) 
	{
		ol.add(o);
		System.out.println("Added \'" + o.getName() + "\' to Store " + name);
	}

	void unregister(Observer o)
	{
		try 
		{
			ol.remove(ol.indexOf(o));	
			System.out.println("Removed \'" + o.getName() + "\' from store " + name);
		}
		catch (NullPointerException e) 
		{
			System.out.println("No such Customer named " + o.getName() + " in store " + name);
		}
		
	}

	void notifyObservers() 
	{
		for(Observer o : ol)
			o.update(discount);

	}
	
	void setDiscount(String festival, float d) 
	{
		discount=d;
		System.out.println("\nSALE ALERT for " + name + "!");
		System.out.println("New Discount Offer on Account of " + festival);
		notifyObservers();
	}
}