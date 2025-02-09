package com.ncs.sol.uplus.messaging.optout.entity;

import java.io.Serializable;

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
public class User implements Serializable {

	@Id
	@Column(name = "reg_date")
	private String regDate;

	@Id
	@Column(name = "conn_id")
	private String connId;
	
}
