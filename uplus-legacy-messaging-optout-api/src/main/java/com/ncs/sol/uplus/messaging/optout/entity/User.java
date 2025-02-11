package com.ncs.sol.uplus.messaging.optout.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_SRVC_DATA_INFO")
public class User {

	@EmbeddedId
	private UserIdPK userId;

	@Column(name = "dnis_no")
	private String dnisNo;

	@Column(name = "ani_no")
	private String aniNo;

	@Column(name = "reject_no")
	private String rejectNo;

	@Column(name = "auth_code")
	private String authCode;

	@Column(name = "secret_key")
	private String secretKey;

	@Column(name = "ani_hash")
	private String aniHash;

	@Column(name = "reject_hash")
	private String rejectHash;


}
