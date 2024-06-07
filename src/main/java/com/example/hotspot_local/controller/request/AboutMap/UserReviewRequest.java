package com.example.hotspot_local.controller.request.AboutMap;

import lombok.Data;

// review로 FE에서 받아오는 것
@Data
public class UserReviewRequest {
	String storeId;     // find the store from cache
	String userEmail;   // find user from DB -> save the review list -> after, it looks in mypage.
	int reviewSpicyLevel;     // spicy level
	String title;   	// title
	String comment;         // comment
//	String reviewImage;         // 차후에 reviewUserImage로 치환됨.
	String foodName;



}

