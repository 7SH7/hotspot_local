insert into silbi_portfolio_likelion.user(email, nick_name, personal_spicy_level, user_name)
values('22000116@handong.ac.kr', '실비요정', 5, '이반');

UPDATE silbi_portfolio_likelion.user
SET nick_name = '실비요정'
WHERE email = '22000116@handong.ac.kr';


ALTER TABLE [테이블명]
    MODIFY [컬럼명][수정 데이터타입(수정 길이)] ;

delete from silbi_portfolio_likelion.user where email = '22000116@handong.ac.kr';

# 처음이 review_id, 두번째가 comment, 세번째가 foodName, 네번째가 review_image,
# 다섯번째가 review_spicyLevel, 여섯번째가 store_id, 일곱번짝 title, 마지막이 user_id
insert into review(comment, food_name, review_image, review_spicy_level, store_id, title, user_email)
values('추천', null, null, 5, '26546824', '하하', 'yezi0512@handong.ac.kr');

insert into silbi_portfolio_likelion.review(comment, food_name, review_image, review_spicy_level, store_id, title, user_email)
values( '추천', null, null, 4, '26546824', '하하', '22000116@handong.ac.kr');

insert into silbi_portfolio_likelion.review(comment, food_name, review_image, review_spicy_level, store_id, title, user_email)
values(  '추천', null, null, 2, '26546824', '하하', '22000116@handong.ac.kr');

insert into silbi_portfolio_likelion.review(comment, food_name, review_image, review_spicy_level, store_id, title, user_email)
values( '추천', null, null, 1, '26546824', '하하', '22000116@handong.ac.kr');

insert into silbi_portfolio_likelion.review(comment, food_name, review_image, review_spicy_level, store_id, title, user_email)
values( '추천', null, null, 4, '26546824', '하하', '22000116@handong.ac.kr');

# 큰앞면, 뒷면, 작은앞면
#   private String characterFrontBigImage;
# 	private String characterFrontSmallImage;
# 	private String characterBackImage;
# 	private String characterName;
# 	private String characterInfo;

insert into user_entity(id, email, role, username) values(1,'22000116@handong.ac.kr', 'User', '학부생 김승환');


insert into silbi_portfolio_likelion.user_character(character_back_image, character_front_big_image, character_front_small_image, character_info, character_name, spicy_level)
values('https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/17c47407-f793-447b-b718-75f5f7270b03%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/2785897e-6396-4761-87ab-959b51fb6b60%ED%81%B0%EB%B2%84%EC%A0%84.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/886383da-248f-4c03-a022-7b591ba6ab82%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84.png',
'*어………… 맵다………… 매운 거 먹을 때마다 코찔찔이 맹구 되는 나…… 나는 매운 거 먹을 때마다 맵찔찔이 되는…… 세상에서 매운 거 제일 못 먹는 존재야…… 매운 건 모르겠고…… 돌이나 줍고 싶다……”*

매운 음식을 먹을 때마다 코찔찔이 맹구가 되는 당신! 어쩌면 세상에서 매운 것을 가장 못 먹는 존재일 수 있습니다.','맵구',1);

insert into silbi_portfolio_likelion.user_character(character_back_image, character_front_big_image, character_front_small_image, character_info, character_name, spicy_level)
values('https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/4672999e-2866-4473-8718-938b3681ebde%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4-1.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/df75f355-717b-452e-9dd6-cb5caa57a085%ED%81%B0%EB%B2%84%EC%A0%84-1.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/719ad0dd-e052-480e-8020-ca7d3e92c5ce%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84-1.png',
'"It is inevitable."
”나의 비할 데 없는 힘과 의지에도 불구하고, 매운 음식의 감각은 나조차도 압도하여,
헛된 저항으로 손을 움직이게 만든다. 이 또한 우주의 위대한 설계의 일부,
모든 힘이 힘에서 오는 것은 아니라는 겸손한 상기이다.','맵노스',2);

insert into silbi_portfolio_likelion.user_character(character_back_image, character_front_big_image, character_front_small_image, character_info, character_name, spicy_level)
values('https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/63994b50-f49e-4cb3-9377-80bccb900bbf%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4-2.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/1c61386d-db18-48d3-aaff-ee95fe618b2c%ED%81%B0%EB%B2%84%EC%A0%84-2.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/ee6733f7-34b2-4b70-8a64-21b4b5ae1554%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84-2.png',
'"아, 또 매운 게 땡기네~"
매운 음식을 잘 먹는다고 생각하는 당신은 주기적으로 매운 음식에 돈을 투자합니다. 매운 음식을 좋아하고, 자신감도 넘치지만, 사실 그렇게까지 잘 먹는 건 아닙니다. 그저 한국인의 평균적인 수준이죠 그래도 매운 음식에 대한 열정만큼은 누구에게도 뒤지지 않습니다.'
    ,'맵물주',3);

insert into silbi_portfolio_likelion.user_character(character_back_image, character_front_big_image, character_front_small_image, character_info, character_name, spicy_level)
values('https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/6560c15c-b6db-4f77-bda1-c5fcfbb4c5e5%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4-3.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/ae509df6-4896-451c-84e7-dcaa2355c716%ED%81%B0%EB%B2%84%EC%A0%84-3.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/9a65494d-4fa7-4563-8ca9-ad53d00a2108%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84-3.png',
       '*"내 위 상태를 보니 매운 음식을 더 먹어도 되겠군."*

매운 것을 너무 좋아하고 잘 먹으며 항상 매운 음식을 찾는 그대! 맵기 높은 음식을 자주 먹어서 당신의 위장은 이미 위암에 걸렸을 수도, 아닐 수도 있습니다. 그러나 확실한 것은, 당신의 위장이 이미 정상은 아니라는 점입니다.'
    ,'위암플래너',4);

insert into silbi_portfolio_likelion.user_character(character_back_image, character_front_big_image, character_front_small_image, character_info, character_name, spicy_level)
values('https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/b0b3d831-353e-4fb8-affb-257526c32836%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4-4.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/d82019ff-1c40-4f4a-913b-bdec4a6dedab%ED%81%B0%EB%B2%84%EC%A0%84-4.png',
'https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/3084d604-6f80-4e0c-81f4-45ec22beb264%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84-4.png',
       '*"뾰로롱~ο(=•ω＜=)ρ⌒☆ (캡사이신을 뿌리며)"*

매운맛을 통달한 당신은 매운 음식 앞에서 두려움 따위 없습니다. 캡사이신을 물처럼 다루는 당신! 어떠한 매운 맛의 공격에도 끄떡 없는 당신! 어떠한 매운 음식이든 그대에겐 식은 죽 먹기입니다.'
    ,'실비요정',5);

# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/2785897e-6396-4761-87ab-959b51fb6b60%ED%81%B0%EB%B2%84%EC%A0%84.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/df75f355-717b-452e-9dd6-cb5caa57a085%ED%81%B0%EB%B2%84%EC%A0%84-1.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/1c61386d-db18-48d3-aaff-ee95fe618b2c%ED%81%B0%EB%B2%84%EC%A0%84-2.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/ae509df6-4896-451c-84e7-dcaa2355c716%ED%81%B0%EB%B2%84%EC%A0%84-3.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/d82019ff-1c40-4f4a-913b-bdec4a6dedab%ED%81%B0%EB%B2%84%EC%A0%84-4.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/17c47407-f793-447b-b718-75f5f7270b03%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/4672999e-2866-4473-8718-938b3681ebde%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4-1.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/63994b50-f49e-4cb3-9377-80bccb900bbf%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4-2.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/6560c15c-b6db-4f77-bda1-c5fcfbb4c5e5%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4-3.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/b0b3d831-353e-4fb8-affb-257526c32836%EC%BA%90%EB%A6%AD%ED%84%B0%20%EB%92%B7%EB%A9%B4-4.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/886383da-248f-4c03-a022-7b591ba6ab82%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/719ad0dd-e052-480e-8020-ca7d3e92c5ce%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84-1.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/ee6733f7-34b2-4b70-8a64-21b4b5ae1554%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84-2.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/9a65494d-4fa7-4563-8ca9-ad53d00a2108%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84-3.png
# https://elasticbeanstalk-ap-northeast-2-975049928260.s3.ap-northeast-2.amazonaws.com/viaF/3084d604-6f80-4e0c-81f4-45ec22beb264%EC%9E%91%EC%9D%80%EB%B2%84%EC%A0%84-4.png
