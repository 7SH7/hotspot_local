package com.example.hotspot_local.dto;

import com.example.hotspot_local.controller.request.AboutMap.UserReviewRequest;
import com.example.hotspot_local.domain.Review;
import com.example.hotspot_local.domain.User;
import com.example.hotspot_local.repository.UserCharacterRepository;
import com.example.hotspot_local.repository.UserRepository;
import jakarta.persistence.Column;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {

	private String title;
	private String comment;
	private int reviewSpicyLevel;
	private String reviewUserImage;
	private String foodName;
	private String storeId;
	private String userEmail;

	private String reviewerNickName;
	private String reviewerName;

//	private UserRepository userRepository;
//	private UserCharacterRepository userCharacterRepository;

	public ReviewDto(UserReviewRequest userReviewRequest, UserRepository userRepository, UserCharacterRepository userCharacterRepository) {
		this.title = userReviewRequest.getTitle();
		this.comment = userReviewRequest.getComment();
		this.reviewSpicyLevel = userReviewRequest.getReviewSpicyLevel();
		this.reviewerNickName = userRepository.findByEmail(userReviewRequest.getUserEmail()).getNickName();
//		this.reviewUserImage = userReviewRequest.getReviewImage();
		this.reviewerName = userRepository.findByEmail(userReviewRequest.getUserEmail()).getUserName();
		this.reviewUserImage = userCharacterRepository.findByCharacterName(userRepository.findByEmail(userReviewRequest.getUserEmail()).getNickName()).getReviewUserImage();
		this.foodName = userReviewRequest.getFoodName();
		this.storeId = userReviewRequest.getStoreId();
		this.userEmail = userReviewRequest.getUserEmail();
	}

	public static ReviewDto from(Review review){
		return ReviewDto.builder()
				.title(review.getTitle())
				.comment(review.getComment())
				.reviewSpicyLevel(review.getReviewSpicyLevel())
				.reviewUserImage(review.getReviewUserImage())
				.reviewerNickName(review.getReviewerNickName())
				.reviewerName(review.getReviewerName())
				.foodName(review.getFoodName())
				.storeId(review.getStoreId())
				.reviewerNickName(review.getReviewerNickName())
				.userEmail(review.getUser().getEmail())
				.build();

	}

}
