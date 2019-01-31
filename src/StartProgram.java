import java.util.List;
import java.util.Scanner;
import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a quantity: ");
			String quantity = in.nextLine();
			System.out.print("Enter an item: ");
			String item = in.nextLine();
			System.out.print("Enter a price: ");
			String price = in.nextLine();
			ListItem toAdd	=	new	ListItem(Integer.parseInt(quantity),item,Double.parseDouble(price));
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the quantity to delete: ");
			String quantity = in.nextLine();
			System.out.print("Enter the item to delete: ");
			String item = in.nextLine();
			System.out.print("Enter the price to delete: ");
			String price = in.nextLine();
			ListItem toDelete =	new	ListItem(Integer.parseInt(quantity),item,Double.parseDouble(price));
			lih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			List<ListItem> foundItems;
			System.out.print("Enter the item to search by: ");
			String itemName = in.nextLine();
			foundItems	=	lih.searchForItemByItem(itemName);

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getItem());
				System.out.println("1 : Update Quantity");
				System.out.println("2 : Update Item");
				System.out.println("3 : Update Price");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Quantity: ");
					int newQuantity = Integer.parseInt(in.nextLine());
					toEdit.setQuantity(newQuantity);
				} else if (update == 2) {
					System.out.print("New Item: ");
					String newItem = in.nextLine();
					toEdit.setItem(newItem);
				} else if (update ==3) {
					System.out.print("New Price: ");
					String newPrice = in.nextLine();
					toEdit.setPrice(Double.parseDouble(newPrice));
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Inventory Management System ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Thank you for using the Invetory Management System!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListItem>	allItems	=	lih.showAllItems();
			for(ListItem singleItem :	allItems){
			System.out.println(singleItem.returnItemDetails());
			}
		}
}
