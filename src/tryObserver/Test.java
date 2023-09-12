package tryObserver;

import java.util.ArrayList;

public class Test 
{

	public static void main(String[] args) 
	{
		Store storeList[] = {
				new Store("Staples", 50),
				new Store ("Walmart", 20),
				new Store ("Freshco", 10)
		};
		
		Customer customerList[] = {
				new Customer("Noah", storeList[2]),
				new Customer("Ayush", storeList[1]),
				new Customer("Dmitri", storeList[0])
		};
		
		customerList[0].register(storeList[1]);
		customerList[0].unregister(storeList[2]);
		customerList[0].update(30);
		
	}
}
