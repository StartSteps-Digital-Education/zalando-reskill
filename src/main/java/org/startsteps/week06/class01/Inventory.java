package org.startsteps.week06.class01;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void removeItem(int itemId) throws ItemNotFoundException {
        boolean isRemoved = false;
        for (Item item: items) {
            if (item.getId() == itemId) {
                items.remove(item);
                isRemoved = true;
                break;
            }
        }

        if (!isRemoved) {
            throw new ItemNotFoundException("Item with id" + itemId + "not found");
        }
    }

    public void decreaseItemQuantity(int itemId, int quantityToReduce) throws ItemNotFoundException, InsufficentStockException {
        boolean found = false;
        for (Item item : items) {
            if (item.getId() == itemId) {
                if (item.getQuantity() >= quantityToReduce) {
                    item.setQuantity(item.getQuantity() - quantityToReduce);
                    found = true;
                } else {
                    throw new InsufficentStockException("Insufficient stock for item with ID " + itemId);
                }
                break;
            }
        }
        if (!found) {
            throw new ItemNotFoundException("Item with ID " + itemId + " not found.");
        }
    }
}
