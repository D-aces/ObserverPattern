package tryObserver;
public class Test 
{
	public static void main(String[] args) 
	{
		Store storeList[] = 
		{
				new Store("Staples", 50),
				new Store("Walmart", 20),
				new Store("FreshCo", 10)
		};
		
		Customer customerList[] = 
		{
				new Customer("Noah", storeList[2]),
				new Customer("Ayush", storeList[1]),
				new Customer("Dmitri", storeList[0])
		};
		//For Customer Noah add store Staples
		customerList[0].register(storeList[0]);
		//For Customer Noah remove store FreshCo
		customerList[0].unregister(storeList[2]);
		
		//Update all customers of discount amount 60% on Account of Christmas 
		storeList[0].setDiscount("Christmas", 60);
		
		//For Customer Noah remove store Staples
		customerList[0].unregister(storeList[0]);
		//For Customer Ayush add Store Staples
		customerList[1].register(storeList[0]);

		//Update all customers of discount 20% on Account of Halloween
		storeList[0].setDiscount("Halloween", 20);
	}
}
