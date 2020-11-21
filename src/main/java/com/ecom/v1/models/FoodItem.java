package com.ecom.v1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ecom.v1.enums.ItemCategory;
import com.ecom.v1.interfaces.Item;

@Entity
public class FoodItem implements Item {

	private long itemId;
	private String itemName;
	private ItemCategory itemCategory;
	private String itemDescription;

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Id
	@GeneratedValue
	@Override
	public long getItemId() {
		return itemId;
	}

	@Override
	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	@Override
	public String getItemName() {
		return itemName;
	}

	@Override
	public String getItemDescription() {
		return itemDescription;
	}
}
