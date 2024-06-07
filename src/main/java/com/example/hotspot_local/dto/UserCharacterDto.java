package com.example.hotspot_local.dto;

import com.example.hotspot_local.domain.UserCharacter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCharacterDto {
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


	public static UserCharacterDto form(UserCharacter userCharacter){
		return UserCharacterDto.builder()
				.characterFrontBigImage(userCharacter.getCharacterFrontBigImage())
				.characterFrontSmallImage(userCharacter.getCharacterFrontSmallImage())
				.characterBackImage(userCharacter.getCharacterBackImage())
				.characterMyPageImage(userCharacter.getCharacterMyPageImage())
				.characterName(userCharacter.getCharacterName())
				.characterInfo(userCharacter.getCharacterInfo())
				.reviewUserImage(userCharacter.getReviewUserImage())
				.spicyLevel(userCharacter.getSpicyLevel())
				.originalColor(userCharacter.getOriginalColor())
				.changedColor(userCharacter.getChangedColor())
				.build();
	}

}
