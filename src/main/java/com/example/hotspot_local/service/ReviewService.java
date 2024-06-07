package com.example.hotspot_local.service;

import com.example.hotspot_local.controller.request.AboutMap.UserReviewRequest;
import com.example.hotspot_local.controller.response.AboutMap.StoreReviewInfo;
import com.example.hotspot_local.controller.response.AboutMyPage.MemberReviewListResponse;
import com.example.hotspot_local.domain.Review;
import com.example.hotspot_local.domain.User;
import com.example.hotspot_local.dto.ReviewDto;
import com.example.hotspot_local.exception.UserException;
import com.example.hotspot_local.repository.ReviewRepository;
import com.example.hotspot_local.repository.UserCharacterRepository;
import com.example.hotspot_local.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewRepository reviewRepository;
	private final UserRepository userRepository;
	private final UserCharacterRepository userCharacterRepository;


	public void save(UserReviewRequest userReviewRequest) throws NullPointerException {

		UserException.UserLoginCheck(userReviewRequest.getUserEmail());

		ReviewDto reviewDto = new ReviewDto(userReviewRequest, userRepository, userCharacterRepository);
		User targetUser = userRepository.findByEmail(userReviewRequest.getUserEmail());

		reviewRepository.save(Review.from(reviewDto, targetUser));
	}

	public StoreReviewInfo getStoreSpicyLevel(String storeId) {
		ArrayList<Review> reviewList = reviewRepository.findByStoreId(storeId); // need User info, so use Review

		ArrayList<Integer> spicyLevelList = getSpicyLevelList(reviewList);
		ArrayList<Integer> spicyLevelCountList = getSpicyLevelCount(reviewList);

		ArrayList<Double> calculateSpicyLevelAvg = calculateSpicyLevelAverage(spicyLevelList, spicyLevelCountList);

		return new StoreReviewInfo(calculateSpicyLevelAvg, spicyLevelCountList);
	}

	// flatMap : 1개의 요소를 여러개의 요소로 변환할 때 사용
	// map : 1개의 요소를 1개의 요소로 변환할 때 사용
	public ArrayList<ReviewDto> getReviewList(String storeId) {
		return (ArrayList<ReviewDto>) reviewRepository.findByStoreId(storeId).stream()
			.map(ReviewDto::from)
			.collect(Collectors.toList());
	}

	public ArrayList<Integer> getSpicyLevelList(ArrayList<Review> reviewList) {
		ArrayList<Integer> spicyLevelList = new ArrayList<>(Collections.nCopies(6, 0));

		for(Review review : reviewList) {
			spicyLevelList.set(0, spicyLevelList.get(0) + review.getReviewSpicyLevel());

			switch (review.getUser().getPersonalSpicyLevel()){
				case 1 -> spicyLevelList.set(1, spicyLevelList.get(1) + review.getReviewSpicyLevel());
				case 2 -> spicyLevelList.set(2, spicyLevelList.get(2) + review.getReviewSpicyLevel());
				case 3 -> spicyLevelList.set(3, spicyLevelList.get(3) + review.getReviewSpicyLevel());
				case 4 -> spicyLevelList.set(4, spicyLevelList.get(4) + review.getReviewSpicyLevel());
				case 5 -> spicyLevelList.set(5, spicyLevelList.get(5) + review.getReviewSpicyLevel());
			}
		}

		return spicyLevelList;
	}

	public ArrayList<Integer> getSpicyLevelCount(ArrayList<Review> reviewList) {
		ArrayList<Integer> spicyLevelCount = new ArrayList<>(Collections.nCopies(6, 0));

		for(Review review : reviewList) {
			spicyLevelCount.set(0, spicyLevelCount.get(0) + 1);

			switch (review.getUser().getPersonalSpicyLevel()){
				case 1 -> spicyLevelCount.set(1, spicyLevelCount.get(1) + 1);
				case 2 -> spicyLevelCount.set(2, spicyLevelCount.get(2) + 1);
				case 3 -> spicyLevelCount.set(3, spicyLevelCount.get(3) + 1);
				case 4 -> spicyLevelCount.set(4, spicyLevelCount.get(4) + 1);
				case 5 -> spicyLevelCount.set(5, spicyLevelCount.get(5) + 1);
			}
		}
		return spicyLevelCount;
	}

	public ArrayList<Double> calculateSpicyLevelAverage(ArrayList<Integer> spicyLevelList, ArrayList<Integer> spicyLevelCountList) {
		ArrayList<Double> spicyLevelAverageList = new ArrayList<>(Collections.nCopies(6, 0.0));

		for(int i = 0; i < 6; i++) {
			if(spicyLevelCountList.get(i) != 0) {
				spicyLevelAverageList.set(i, (double)spicyLevelList.get(i) / spicyLevelCountList.get(i));
			}
		}
		return spicyLevelAverageList;
	}

	public MemberReviewListResponse findReviewByUser(String userEmail) {
		ArrayList<Review> reviewList = reviewRepository.findByUserEmail(userEmail);

		List<ReviewDto> reviewDtoList = reviewList.stream()
			.map(ReviewDto::from)
			.collect(Collectors.toList());

		return new MemberReviewListResponse(reviewDtoList);
	}

}
