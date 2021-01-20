package com.gokhana.courierservice.model.event;

import java.util.List;

public class OrderDTO {

    private Long Id;
    private String name;
    private List<Integer> productIds;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }


    @Override
    public String toString() {
        return "OrderDTO{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", productIds=" + productIds +
                '}';
    }
}
