package ex01_DI;
import java.util.Date;

class Member{
	String name;
	String nickname;
	public Member() {}
}

public class understand_DI {

	public static void main(String[] args) {
		// 날짜를 구하기 위해서는 Date 클래스에 의존해야 한다.
		Date date = new Date();
		System.out.println(date);	
	}
	
	public static void getDate(Date d) {
		// 약한 곃합 : 생성된 것을 주입 받음 - 의존 주입
		Date date = d;
		System.out.println(date);
	}
	
	public static void memberUse1() {
		// 강한 결합 : 직접 생성
		Member m1 = new Member();
	}
	
	public static void memberUse2(Member m) {
		// 약한 결합 
		Member m2 = m;
	}

}
