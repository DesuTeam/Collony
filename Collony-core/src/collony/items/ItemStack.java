package collony.items;

public class ItemStack
{
	private Item item;
	private int count;
	
	public ItemStack(Item item, int count)
	{
		this.item = item;
		this.count = count;
	}
	
	public void decrement()
	{
		count--;
	}
	
	public void increment()
	{
		count++;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public Item getItem()
	{
		return item;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	
}
