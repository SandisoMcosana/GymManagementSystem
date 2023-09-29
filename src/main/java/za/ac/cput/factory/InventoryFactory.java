package za.ac.cput.factory;

import za.ac.cput.domain.Inventory;

public class InventoryFactory {
    public static Inventory createInventory( String name, String description, String quantity,String alert_threshold) {

        return new Inventory.Builder()

                .setName(name)
                .setDescription(description)
                .setQuantity(quantity)
                .setAlert_threshold(alert_threshold)
                .build();
    }
//    public static Inventory createInventory(String id, String itemId, String name, String description, String quantity,String alert_threshold) {
//
//        return new Inventory.Builder().setItemId(id)
//                .setName(name)
//                .setDescription(description)
//                .setQuantity(quantity)
//                .setAlert_threshold(alert_threshold)
//                .build();
//    }

}
