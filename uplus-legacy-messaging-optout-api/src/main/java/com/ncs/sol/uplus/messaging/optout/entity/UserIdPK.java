package com.ncs.sol.uplus.messaging.optout.entity;

import java.io.Serializable;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@DynamicUpdate
@DynamicInsert
@Embeddable
public class UserIdPK implements Serializable {

    private static final long serialVersionUID = -2929789292155268166L;

    @Column(name = "reg_date", nullable = false)
    private String regDate;

    @Column(name = "conn_id", nullable = false)
    private String connId;

    public void generateConnId() {
        if (this.connId == null) {
            if (regDate == null) {
                this.regDate = String.valueOf(System.currentTimeMillis());
            }
            String connPrefix = this.regDate.substring(this.regDate.length() - 6);
            long randomPart = System.nanoTime() % 100000;
            this.connId = "009a00280" + connPrefix + String.format("%05d", randomPart);
        }
    }
}