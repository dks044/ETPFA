package test;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		//=================텍스트 넣을곳=====================
		String trans_eng =  "";
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

		//악세사리
		//Wearing glasses(안경), a bag(가방), a Scarf(목도리), gloves(장갑), a watch(시계) a bracelet(팔찌)
		HashMap<String, String> acc_map = new HashMap<>();
		acc_map.put("안경을 착용하고", "wearing a glasses, ");
		acc_map.put("가방을 착용하고", "wearing a bag, ");
		acc_map.put("목도리를 착용하고", "wearing a scarf, ");
		acc_map.put("장갑을 착용하고", "wearing a gloves, ");
		acc_map.put("시계를 착용하고","wearing a watch, ");
		acc_map.put("팔찌를 착용하고", "wearing a bracelet, ");
		
		//아우터
		HashMap<String,String> outer_map = new HashMap<>();
		outer_map.put("코트", "a coat, ");
		outer_map.put("패딩", "a pupper jacket, ");
		outer_map.put("바람막이","a windbreaker, ");
		
		//상의
		HashMap<String,String> top_map = new HashMap<>();
		top_map.put("셔츠", "a shirt, ");
		top_map.put("맨투맨", "a sweatshirt, ");
		top_map.put("니트", "a knit, ");
		top_map.put("티셔츠", "a T shirt, ");
		top_map.put("반팔카라티", "a collared T-shirt, ");
		top_map.put("반팔티", "a short-sleeve T-shirt, ");
		top_map.put("반팔셔츠", "a short-sleeve shirt, ");
		
		//하의
		HashMap<String, String> bottom_map2 = new HashMap<>();
		bottom_map2.put("나일론 바지/슬랙스", "a pair of nylon trousers/business trousers, ");
		bottom_map2.put("운동복 바지/산악바지", "a pair of sweat pants/hiking pants, ");
		
		HashMap<String, String> bottom_map = new HashMap<>();
		bottom_map.put("면바지", "a pair of cotton pants, ");
		bottom_map.put("산악바지", "a pair of hiking pants, ");
		bottom_map.put("운동복", "a pair of sweat pants, ");
		bottom_map.put("슬랙스", "a pair of business trousers, ");
		bottom_map.put("반바지", "a pair of shorts, ");
		bottom_map.put("청바지", "a pair of jeans, ");
		bottom_map.put("나일론 바지", "a pair of nylon trousers, ");
		
		//신발
		HashMap<String, String> shoes_map = new HashMap<>();
		shoes_map.put("운동화", "and sneakers ");
		shoes_map.put("부츠", "and boots ");
		shoes_map.put("슬리퍼", "and flip-flops ");
		shoes_map.put("구두", "and formal shoes ");
		
		//마지막에 붙는 전치사 (ex: 모자를 쓰고(with a hat on))
		HashMap<String, String> pre_map = new HashMap<>();
		pre_map.put("모자를 착용하고", "with a hat on.");
		pre_map.put("목걸이를 착용하고", "with a necklace on.");
		pre_map.put("서류가방(다른 손에 드는가방)을 들고", "with a suitcase (handcarry baggage) in hand.");
		pre_map.put("악세사리를 착용하지 않고", "without accessaries.");
		pre_map.put("악세서리를 착용하지 않고,", "without accessaries.");
		
		
		//프로그램시작
		StringBuilder sb = new StringBuilder();
		boolean acc = false; //악세사리 착용 유무
		for(String str : trans_engg) {
			//TODO:"액세사리를 착용하지 않고를 마지막에" 
			sb.append("An Elderly woman is taking a position ; ");//기본시작 (청년여자) <-성별에따라 알아서 바꾸면 됨.
			
			//포즈 번역 캡션
			String pose_num = str.split("\\s+")[0];
			Integer pose_temp = Integer.parseInt(pose_num);
			sb.append(pose_map.get(pose_temp));
			
			//악세사리
			if(str.contains("안경을 착용하고")) {
				sb.append("wearing glasses, "); acc= true;
			}else if(str.contains("가방을 착용하고")) {
				sb.append("wearing a bag, "); acc= true;
			}else if(str.contains("목도리를 착용하고")) {
				sb.append("wearing a scarf, "); acc= true;
			}else if(str.contains("장갑을 착용하고")) {
				sb.append("wearing gloves, "); acc= true;
			}else if(str.contains("시계를 착용하고")) {
				sb.append("wearing a watch, "); acc= true;
			}else if(str.contains("팔찌를 착용하고")) {
				sb.append("wearing a bracelet, "); acc= true;
			}

			//악세사리 착용 유무 (! 마지막에 다시 false로 초기화)
			if(!acc) {
				sb.append("wearing ");
			}
			
			// 문장을 단어로 분리하기(아웃터)
			for (String topKey : outer_map.keySet()) {
                if (str.contains(topKey)) {
                    sb.append(outer_map.get(topKey));
                }
            }
			
			// 문장을 단어로 분리하기(상의)
			for (String topKey : top_map.keySet()) {
                if (str.contains(topKey)) {
                    sb.append(top_map.get(topKey));
                }
            }
			
			// 문장을 단어로 분리하기(하의)
			boolean bottomFound = false; // 바지두개 중복 걸러내기용(나일론바지/슬랙스바지 등)
			for (String bottomKey2 : bottom_map2.keySet()) {
			    if (str.contains(bottomKey2)) {
			        sb.append(bottom_map2.get(bottomKey2));
			        bottomFound = true;
			        break;
			    }
			}
			if (!bottomFound) {
			    for (String bottomKey : bottom_map.keySet()) {
			        if (str.contains(bottomKey)) {
			            sb.append(bottom_map.get(bottomKey));
			            break;
			        }
			    }
			}
			
	        //양말
	        if(str.contains("흰색 양말")) {
	        	sb.append("white socks, ");
	        }else if(str.contains("검은색 양말")) {
	        	sb.append("black socks, ");
	        }
	        
			// 문장을 단어로 분리하기(신발)
	        for (String shoeKey : shoes_map.keySet()) {
                if (str.contains(shoeKey)) {
                    sb.append(shoes_map.get(shoeKey));
                }
            }
	        
	        
	        if(str.contains("맨발")) {
	        	sb.append("on bare feet ");
	        }
	        
	        
	        //마지막 전치사 (악세사리 없이, 등)
	        for (String preKey : pre_map.keySet()) {
	            if (str.contains(preKey)) {
	                sb.append(pre_map.get(preKey));
	            }
	        }
	        

	        
	        //마무리(. 붙이기 로직)
	        int sbLength = sb.toString().length()-1;
	        if (sb.charAt(sbLength) == ' ') {
	            sb.setCharAt(sbLength, '.');
	        }
	        	
	        System.out.println(sb.toString());
	        sb.setLength(0);//초기화
	        acc = false;
	        
		}
		
		
		

	}

}

