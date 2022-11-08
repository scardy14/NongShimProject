package mypage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import model.MyPageDAO;

public class TestCaseLotto {
	public static void main(String[] args) {
		TreeSet<Integer> set =new TreeSet<>();
		set=MyPageDAO.getInstance().randomPointNumber();
		//System.out.println(set);
		
		//controller에 사용할 부분
		Iterator<Integer> iter = set.iterator(); // set을 Iterator 안에 담기
		while(iter.hasNext()) { // iterator에 다음 값이 있다면
			System.out.println("iterator : " + iter.next()); // iter에서 값 꺼내기
		}
	}
}
