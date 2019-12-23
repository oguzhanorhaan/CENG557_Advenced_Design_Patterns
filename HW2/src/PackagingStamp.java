
public class PackagingStamp implements IPackagingStrategy {

	@Override
	public void packageProduct(AbstractProduct product) {
		// TODO Auto-generated method stub
		System.out.println(product.getType().name().toString()+" packaged with strategy Stamp Packaging");
	}

}
