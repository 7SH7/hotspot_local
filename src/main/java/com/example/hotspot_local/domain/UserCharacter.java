package com.example.hotspot_local.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCharacter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	private String characterFrontBigImage;
	private String characterFrontSmallImage;
	private String characterBackImage;
	private String characterMyPageImage;
	private String characterName;
	private String characterInfo;
	private int spicyLevel;

	private String reviewUserImage;

	private String originalColor;
	private String changedColor;

}
