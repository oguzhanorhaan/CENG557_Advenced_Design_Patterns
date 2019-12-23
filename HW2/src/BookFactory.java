
public class BookFactory implements IFactory{

	@Override
	public AbstractProduct getProduct(PRODUCT_TYPE productType) {
		if(productType == PRODUCT_TYPE.BOOK_ADVENTURE 
				|| productType == PRODUCT_TYPE.BOOK_DRAMA
				||productType == PRODUCT_TYPE.BOOK_SCIENCE ) {
			return new Book(productType);
		}
		return null;
	}

}
