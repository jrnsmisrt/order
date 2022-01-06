package com.switchfully.order.domain.user;

import javax.persistence.Embeddable;

@Embeddable
public enum UserLevel {
    ADMIN,
    CUSTOMER
}
