package com.qfedu.tkmapperdemo.beans;

import lombok.Data;

@Data
public class Orders {
    private String orderId;
    private Integer userId;
    private String receiverName;
    private String receiverMobile;
    private String receiverAddress;
}
