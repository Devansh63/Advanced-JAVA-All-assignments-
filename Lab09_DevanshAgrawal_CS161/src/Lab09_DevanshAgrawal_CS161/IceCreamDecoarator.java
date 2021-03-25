package Lab09_DevanshAgrawal_CS161;
/**
 * This is my decorator class. It is abstract and i used it to add specific flavours to my icecream
 * @author devan
 *
 */
public abstract class IceCreamDecoarator implements IceCream {
	
	protected IceCream IC;
	
	public IceCreamDecoarator (IceCream icecream) {
		IC=icecream;
	}
	 
	  public String toString() {
		  return IC.toString();
	  }
	  public IceCream eat() {
		  return this.IC;
	  }
}
