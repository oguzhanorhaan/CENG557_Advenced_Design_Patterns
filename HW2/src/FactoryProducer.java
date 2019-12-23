
public class FactoryProducer {
	 public static IFactory getFactory(FACTORY_TYPE factoryType) {   
	      if (factoryType == FACTORY_TYPE.FACTORY_BOOK) {
	         return new BookFactory();       
	      } else if (factoryType == FACTORY_TYPE.FACTORY_FOOD) {
	         return new FoodFactory();
	      }
	      else if (factoryType == FACTORY_TYPE.FACTORY_MUSIC) {
	    	  return new MusicFactory();
	      }
	      else return null;
	   }
}
