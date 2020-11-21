package com.ecom.v1.interfaces;

import com.ecom.v1.enums.ItemCategory;

public interface Item {

	long getItemId();

	ItemCategory getItemCategory();

	String getItemName();

	String getItemDescription();
}
