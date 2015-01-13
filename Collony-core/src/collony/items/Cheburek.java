package collony.items;

public class Cheburek extends Food
{
	protected Cheburek instance;
	
	@Override
	public Item getInstance() {
		
		instance = new Cheburek();
		return instance;
	}
	
}
