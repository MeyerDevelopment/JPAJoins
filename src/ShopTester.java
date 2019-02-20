import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ShopHelper;
import model.ListDetails;
import model.ListItem;
import model.Shop;

public class ShopTester {
public static void main(String[] args) {
Shop target = new Shop("Target");
ListDetailsHelper ldh = new ListDetailsHelper();
ListItem shampoo = new ListItem(54, "Shampoo", 3.95);
ListItem brush = new ListItem(67, "Brush", 4.98);
List<ListItem> targetsItems = new
ArrayList<ListItem>();
targetsItems.add(shampoo);
targetsItems.add(brush);
ListDetails targetsList = new ListDetails("Target's Inventory", LocalDate.now(), target);
targetsList.setListOfItems(targetsItems);
ldh.insertNewListDetails(targetsList);
List<ListDetails> allLists = ldh.getLists();
for(ListDetails a: allLists) {
System.out.println(a.toString());
}
}
}
