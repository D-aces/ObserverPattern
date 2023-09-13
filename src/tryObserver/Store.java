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
		System.out.println("\nAdded \'" + o.getName() + "\' to " + name);
	}

	void unregister(Observer o)
	{
		try 
		{
			ol.remove(ol.indexOf(o));	
			System.out.println("\nRemoved \'" + o.getName() + "\' from " + name);
		}
		catch (NullPointerException e) 
		{
			System.out.println("\nNo such Customer named \'" + o.getName() + "\'' in " + name);
		}
	}

	void notifyObservers()
	{
		for(Observer o : ol)
			o.update(discount);
	}
	
	void setDiscount(String festival, float d) 
	{
		discount = d;
		System.out.println("\nSALE ALERT for " + name + "!");
		System.out.println("Discount Offer for " + festival + "!");
		notifyObservers();
	}
}