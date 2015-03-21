package com.changh.sccms.test;

import java.util.ArrayList;
import java.util.List;

import com.changh.sccms.entity.ExamQuestion;
import com.changh.sccms.entity.ExamRule;

public class Test6 {
	public static void main(String[] args) {
//		Class c = AdministratorServiceImpl.class;
//		Class c = OrderServiceImpl.class;
//		Class c = StudyCardServiceImpl.class;
		/*Class c = TeacherServiceImpl.class;
		Method[] methods = c.getDeclaredMethods();
		for(Method m : methods)
		{
			System.out.println(m.getName());
		}*/
//		GregorianCalendar c = new GregorianCalendar();
//		c.add(Calendar.MONTH, 24);
//		System.out.println(c.getTime() );
		/*ExamQuestion q = new ExamQuestion();
		q.setQuestType(1);
		q.setQuestContent("鈥嬫牳閰镐腑鏍歌嫹閰镐箣闂寸殑杩炴帴鏂瑰紡鏄疉锛�'锛�7'纾烽吀浜岄叝閿瓸锛庢阿閿瓹锛�'锛�7'纾烽吀浜岄叝閿瓺锛庣硸鑻烽敭E锛�'锛�7'纾烽吀浜岄叝閿�);
		System.out.println(q.getFormatString());*/
		List<ExamRule> rules = new ArrayList<ExamRule>();
		List<ExamQuestion> list = new ArrayList<ExamQuestion>();
		System.out.println(getRules(rules));
		System.out.println(getQuestion(list));
		String answers = "ssss&1001=A&1002=A,B&1003=A,B&1004=A&1005=A,B";
						//     A	  ABCD	A	A	A
		String[] arr = answers.split("&");
		double score = 0, score1 = 0,score2=0;
		StringBuffer buf = new StringBuffer();
		for(int k=0;k<rules.size();k++)
		{
			ExamRule r = rules.get(k);
			double fen = r.getRuleScoreForEach();//姣忛鐨勫垎鏁�
			String fenRule = r.getRuleScoreSet();//鍒ゅ垎瑙勫垯 0|N琛ㄧず姣忛澶氬皯鍒嗗氨鏄灏戝垎锛�
												//1|N,琛ㄧず绛斿涓�釜閫夐」寰桸鍒嗭紝鍏ㄩ儴绛斿寰楄棰樼殑婊″垎
												//2|N,琛ㄧず鎵撻敊鎵鍒�鏈�皯寰�鍒�
			for(int j=0;j<list.size();j++)
			{
				ExamQuestion q = list.get(j);
				for(int i=1;i<arr.length;i++)
				{
					String arr1[] = arr[i].split("="); //瑙ｆ瀽绛旀    1001=A; 1001鏄鍙凤紝A鏄瓟妗�
					if(q.getQuestRuleId().equals(r.getRuleId())) //灞炰簬璇ュぇ棰樼殑棰樼洰锛屾寜璇ヨ鍒欒繘琛屽垽鍒�
					{
						if(fenRule.startsWith("0|")) //绛旈敊涓嶆墸鍒嗭紝鍏ㄥ鎵嶅緱婊″垎
						{
							if(q.getQuestId().equals(Integer.parseInt(arr1[0]))&&q.getQuestAnswer().equals(arr1[1]))
							{
								score=score+fen;
							}
						}else if(fenRule.startsWith("1|"))//绛斿涓�釜閫夐」寰楀灏戝垎
						{
							if(q.getQuestId().equals(Integer.parseInt(arr1[0])))
							{
								String qans = q.getQuestAnswer();
								if(qans.equals(arr1))
								{
									score = score+fen;
								}else if(qans.contains(arr1[1])){
									String[] ua = arr1[1].split(",");
									System.out.println(q.getQuestId()+":"+ua.length);
									System.out.println(Double.parseDouble(fenRule.split("[|]")[1]));
									double fen1 = ua.length*Double.parseDouble(fenRule.split("[|]")[1]);
									System.out.println(fen1);
									score = score+fen1;
								}
							}
						}else if(fenRule.startsWith("2|"))//绛旈敊鎵ｅ垎
						{
							if(q.getQuestId().equals(Integer.parseInt(arr1[0])))
							{
								String qans = q.getQuestAnswer();
								if(qans.equals(arr1))
								{
									score1 = score1+Double.parseDouble(fenRule.split("[|]")[1]);
								}else
								{
									score1 = score1-Double.parseDouble(fenRule.split("[|]")[1]);
								}
							}
						}
					}
				}
			}
			//姣忛寰楀垎
			if(fenRule.startsWith("2|"))
			{
				buf.append(r.getRuleId());
				buf.append("=");
				buf.append(score1>0?score1:0);
				buf.append(";");}
			else
			{
				buf.append(r.getRuleId());
				buf.append("=");
				score2 = score-score2;
				buf.append(score2);buf.append(";");
				score2 = score;
			}
			System.out.println(buf.toString());
		}
		score = score1>0?(score+score1):score;
		System.out.println(score);
		
	}
	private static List<ExamRule> getRules(List<ExamRule> rules)
	{
		ExamRule r1 = new ExamRule();
		ExamRule r2 = new ExamRule();
		ExamRule r3 = new ExamRule();
		r1.setRuleId(1001);r2.setRuleId(1002);r3.setRuleId(1003);
		r1.setRuleScoreForEach(1);
		r2.setRuleScoreForEach(2);
		r3.setRuleScoreForEach(1);
		r1.setRuleScoreSet("0|1");
		r2.setRuleScoreSet("1|0.5");
		r3.setRuleScoreSet("0|1");
		rules.add(r1);
		rules.add(r2);
		rules.add(r3);
		return rules;
	}
	private static List<ExamQuestion> getQuestion(List<ExamQuestion> list)
	{
		for(int i=0;i<5;i++)
		{
			ExamQuestion q = new ExamQuestion();
			q.setQuestId(1001+i);
			q.setQuestRuleId(1001+i%3); //1001,1002,1003,1001,1002
			if(i==1)
			{
				q.setQuestAnswer("A,B,C,D");
			}else
				q.setQuestAnswer("A");
			list.add(q);
		}
		return list;
	}
}
