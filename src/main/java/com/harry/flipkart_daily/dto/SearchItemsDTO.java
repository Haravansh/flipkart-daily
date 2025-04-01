package com.harry.flipkart_daily.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class SearchItemsDTO {
    private List<String> categories;
    private List<String> brands;
    private Double priceFrom;
    private Double priceTo;
    private String orderBy;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public SearchItemsDTO(List<String> categories, List<String> brands, Double priceFrom, Double priceTo, String orderBy) {
        this.categories = categories;
        this.brands = brands;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.orderBy = orderBy;
    }

    public SearchItemsDTO() {
    }
}
