import java.util.ArrayList;

public class Context {
	private ArrayList<IPackagingStrategy> strategy;

	   public Context(ArrayList<IPackagingStrategy> strategy){
	      this.strategy = strategy;
	   }

	   public void executePackagingStrategy(AbstractProduct product){
		   for(IPackagingStrategy ps : strategy) {
			   ps.packageProduct(product);   
		   }
	   }
}
