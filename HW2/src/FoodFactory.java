
public class FoodFactory implements IFactory{

	@Override
	public AbstractProduct getProduct(PRODUCT_TYPE productType) {
		if(productType == PRODUCT_TYPE.FOOD_FROZEN 
				|| productType == PRODUCT_TYPE.FOOD_FRESH) {
			return new Food(productType);
		}
		return null;
	}

}
