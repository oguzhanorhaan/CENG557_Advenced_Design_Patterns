import java.util.ArrayList;

public abstract class AbstractProduct {
	public abstract PRODUCT_TYPE getType();
	Context context;
	private final ArrayList<IPackagingStrategy> productPackages = new ArrayList<IPackagingStrategy>();
	
	public void startPackaging() 
	{
		if (getType() == PRODUCT_TYPE.BOOK_ADVENTURE 
				|| getType()  == PRODUCT_TYPE.BOOK_DRAMA
				||getType()  == PRODUCT_TYPE.BOOK_SCIENCE) {
			productPackages.add(new PackagingBox());
			
		}
		else if (getType() == PRODUCT_TYPE.FOOD_FROZEN 
				|| getType() == PRODUCT_TYPE.FOOD_FRESH) {
			productPackages.add(new PackagingDryIce());
			productPackages.add(new PackagingBox());
		}
		else if ( getType()  == PRODUCT_TYPE.MUSIC_VOCAL_INSTRUMENTS) {
			productPackages.add(new PackagingFoam());
			productPackages.add(new PackagingBox());
		}
		else if ( getType()  == PRODUCT_TYPE.MUSIC_STRING ) {
			productPackages.add(new PackagingStamp());
		}
		
		context = new Context(productPackages);
		
		if(productPackages.size() != 0) {
			context.executePackagingStrategy(this);
		}
	}
}
