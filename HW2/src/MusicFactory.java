
public class MusicFactory implements IFactory{

	@Override
	public AbstractProduct getProduct(PRODUCT_TYPE productType) {
		if(productType == PRODUCT_TYPE.MUSIC_STRING 
				|| productType == PRODUCT_TYPE.MUSIC_VOCAL_INSTRUMENTS) {
			return new Music_Product(productType);
		}
		return null;
	}

}
