
public class Book extends AbstractProduct{
	private final PRODUCT_TYPE type;
	public Book(PRODUCT_TYPE type) {
		this.type=type;
	}

	@Override
	public PRODUCT_TYPE getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
