
public class Food extends AbstractProduct{

	private final PRODUCT_TYPE type;
	public Food(PRODUCT_TYPE type) {
		this.type=type;
	}

	@Override
	public PRODUCT_TYPE getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
