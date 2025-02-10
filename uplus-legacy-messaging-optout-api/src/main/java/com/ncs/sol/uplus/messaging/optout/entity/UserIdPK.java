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
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@DynamicUpdate
@DynamicInsert
@Embeddable
@Data
public class UserIdPK implements Serializable {

	
	@Column(name = "reg_date")
	@ColumnDefault("sysdate")
	private String regDate;


	@Column(name = "conn_id")
	private String connId;

	public void name() {
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
