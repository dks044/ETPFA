package test;

import java.util.HashMap;

public class Test_2 {

	public static void main(String[] args) {
    //액세사리, 의상 등 제거하고, 앞을보고, 뒤를보고 관련 번역 코드

    
		//=================텍스트 넣을곳=====================
		String trans_eng =  "3	  앞을보고 코트, 셔츠, 면바지와 흰색 양말, 운동화를 신은 청소년 남자가  주먹 맞댄 선 자세를 취하고 있다 \r\n"
				+ "4	  뒤를보고 코트, 셔츠, 면바지와 흰색 양말, 운동화를 신은 청소년 남자가  팔 굽힌 선 자세를 취하고 있다 ";
		String[] trans_engg = trans_eng.split("\n");
		//================================================
		
		
		//포즈번호
		HashMap<Integer, String> pose_map = new HashMap<>();
		pose_map.put(1, "standing straight, ");
		pose_map.put(2, "inverting both arms at 90 degree at shoulder level, ");
		pose_map.put(3, "facing both fists together, ");
		pose_map.put(4, "folding right arm, ");
		pose_map.put(5, "raising up right forearm, ");
		pose_map.put(6, "stratching both arms forward, ");
		pose_map.put(7, "sitting-straight, ");
		pose_map.put(8, "sitting-applied, ");
		pose_map.put(9, "posing T posture with both arms, ");
		pose_map.put(10, "posing A posture with both arms, ");
		
		//프로그램시작
		StringBuilder sb = new StringBuilder();

		for(String str : trans_engg) {
			
			sb.append("An Elderly woman is taking a position ; ");//기본시작 (청년여자) <-성별에따라 알아서 바꾸면 됨.
			
			//포즈캡션번역
			String pose_num = str.split("\\s+")[0];
			Integer pose_temp = Integer.parseInt(pose_num);
			sb.append(pose_map.get(pose_temp));

			//임시 : 앞을보고, 뒤를보고 
			if(str.contains("앞을보고"))sb.append("look forward ");
			if(str.contains("뒤를보고"))sb.append("look behind ");
			
			
			
			
	        //마무리(. 붙이기 로직)
	        int sbLength = sb.toString().length()-1;
	        if (sb.charAt(sbLength) == ' ') {
	            sb.setCharAt(sbLength, '.');
	        }
	        	
	        System.out.println(sb.toString());
	        sb.setLength(0);//초기화
	        
		}

	}

}
