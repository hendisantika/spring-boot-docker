package com.hendisantika.docker.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hendisantika on 6/14/17.
 */
@Data
@Entity(name = "SUB_ACCOUNT")
@ToString(includeFieldNames=true)
public class Account {
    @Id
    @Getter
    @Setter
    String id;

    @Getter
    @Setter
    String customerId;

    @Getter
    @Setter
    String customerName;

    @Getter
    @Setter
    String poolId;

    @Getter
    @Setter
    Double balance;

    @Getter
    @Setter
    String curr;

    @Temporal(TemporalType.TIMESTAMP)
    Date createdTimestamp;

    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdateTimestamp;


    public Account() {
    }

    public Account(String id, String customerId, String customerName, String poolId, Double balance, String curr, Date createdTimestamp, Date lastUpdateTimestamp) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.poolId = poolId;
        this.balance = balance;
        this.curr = curr;
        this.createdTimestamp = createdTimestamp;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }
}
