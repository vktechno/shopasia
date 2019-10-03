package com.business.model;

public class CategoryMasterModel {
	
	private int catId;
	private int subCatId;
	private String category;
	private String subCategory;
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "CategoryMasterModel [catId=" + catId + ", subCatId=" + subCatId + ", category=" + category
				+ ", subCategory=" + subCategory + "]";
	}
	
	

}
