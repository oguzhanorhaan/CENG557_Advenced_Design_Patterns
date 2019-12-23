import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showProductTypes();

	}
	
	public static void showProductTypes() {
		IFactory productFactory;
		AbstractProduct product; 
		Scanner in = new Scanner(System.in); 
		   
		System.out.println("Please enter the number of product type");
		System.out.println("(1) BOOK");
		System.out.println("(2) FOOD");
		System.out.println("(3) MUSIC STUFF");
		
		String readedValue = in.nextLine();
		
		if(readedValue.contains("1")) {
			productFactory = FactoryProducer.getFactory(FACTORY_TYPE.FACTORY_BOOK);
			System.out.println("Choose book type");
			System.out.println("(1) DRAMA BOOK");
			System.out.println("(2) ADVENTURE BOOK");
	    	System.out.println("(3) SCIENCE BOOK");
	    	
	    	String choosenType = in.nextLine();
	    	if (choosenType.contains("1")) {
	    		System.out.println("Choosen type is DRAMA BOOK");
	    		product = productFactory.getProduct(PRODUCT_TYPE.BOOK_DRAMA);
	    	} 
	    	else if (choosenType.contains("2")) {
	    		System.out.println("Choosen type is ADVENTURE BOOK");
	    		product = productFactory.getProduct(PRODUCT_TYPE.BOOK_ADVENTURE);
	    	} 
	    	else if (choosenType.contains("3")) {
	    		System.out.println("Choosen type is SCIENCE BOOK");
	    		product = productFactory.getProduct(PRODUCT_TYPE.BOOK_SCIENCE);
	    	} 
	    	else return;
	    
		}
		else if(readedValue.contains("2")) {
			productFactory = FactoryProducer.getFactory(FACTORY_TYPE.FACTORY_FOOD);

			System.out.println("Choose food type");
			System.out.println("(1) FRESH FOOD");
			System.out.println("(2) FROZEN FOOD");
			
			String choosenType = in.nextLine();
	    	if (choosenType.contains("1")) {
	    		System.out.println("Choosen type is FRESH FOOD");
	    		product = productFactory.getProduct(PRODUCT_TYPE.FOOD_FRESH);
	    	} 
	    	else if (choosenType.contains("2")) {
	    		System.out.println("Choosen type is FROZEN FOOD");
	    		product = productFactory.getProduct(PRODUCT_TYPE.FOOD_FROZEN);

	    	}
	    	else return;
		}
		else if(readedValue.contains("3")) {
			
			productFactory = FactoryProducer.getFactory(FACTORY_TYPE.FACTORY_MUSIC);
			
			System.out.println("Choose music stuff type");
			System.out.println("(1) MUSIC STRINGS");
			System.out.println("(2) MUSIC VOCAL INSTRUMENTS");
			
			String choosenType = in.nextLine();
	    	if (choosenType.contains("1")) {
	    		System.out.println("Choosen type is MUSIC STRINGS");
	    		product = productFactory.getProduct(PRODUCT_TYPE.MUSIC_STRING);
	    	} 
	    	else if (choosenType.contains("2")) {
	    		System.out.println("Choosen type is MUSIC VOCAL INSTRUMENTS");
	    		product = productFactory.getProduct(PRODUCT_TYPE.MUSIC_VOCAL_INSTRUMENTS);
	    	}
	    	else return;
		}
		else return;
		
		product.startPackaging();
	}

}