package java01.exam09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import java01.exam09.vo.Member;

public class SpmsApp {
	static ArrayList<Member> members;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] command = null;
		
		load();
		
		loop:
		while(true) {
			command = prompt(scanner);
			
			try {
				switch(command[0]) {
				case "add": processAdd(scanner); break;
				case "list": processList(); break;
				case "update": processUpdate(scanner, command[1]); break;
				case "delete": processDelete(scanner, command[1]); break;
				case "read": processRead(command[1]); break;
				case "quit": break loop;
				default:
					System.out.println("사용할 수 없는 명령어입니다.");
				}
			} catch (Exception e) {
				System.out.println("명령어 실행 중 오류가 발생했습니다!");
			}
		}
		scanner.close();
		
		save();
	}

	@SuppressWarnings("unchecked")
  private static void load() {
		try {
			FileInputStream in = new FileInputStream("member03.dat");
			ObjectInputStream in2 = new ObjectInputStream(in);
			
			members = (ArrayList<Member>)in2.readObject();
			
			in2.close();
			in.close();
		} catch (Exception e) {
			System.out.println("파일 로딩 중 오류발생!");
			members = new ArrayList<Member>();
    }
	}

	private static void save() {
		try {
			FileOutputStream out = new FileOutputStream("member03.dat");
			ObjectOutputStream out2 = new ObjectOutputStream(out);
			
			out2.writeObject(members);
			
			out2.close();
			out.close();
		} catch (Exception e) {
			System.out.println("저장 중 오류발생!");
		}
  }

	private static void processRead(String email) {
		for (Member member : members) {
			if (email.equals(member.getEmail())) {
				System.out.println("이름:" + member.getName());
				System.out.println("나이:" + member.getAge());
				System.out.println("이메일:" + member.getEmail());
				System.out.println("전화:" + member.getTel());
				return;
			}
		}
  }

	private static void processDelete(Scanner scanner, String email) {
		for (Member member : members) {
			if (email.equals(member.getEmail())) {
				System.out.print("정말 삭제하시겠습니까?(y/n)");
				String command = scanner.nextLine();
				if (command.toLowerCase().equals("y")) {
					members.remove(member);
					System.out.println("삭제되었습니다.");
				} else {
					System.out.println("삭제 취소하였습니다.");
				}
				return;
			}
		}
		
		System.out.println("해당 이메일의 멤버를 찾을 수 없습니다!");
  }

	private static void processUpdate(Scanner scanner, String email) {
		Member temp = new Member();
		Member member = null; 
		
		for (int i = 0; i < members.size(); i++) {
			member = members.get(i);
			if (email.equals(member.getEmail())) {
				System.out.print("이름(" + member.getName() + "):");
				String value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setName(value);
				} else {
					temp.setName(member.getName());
				}
				System.out.print("나이(" + member.getAge() + "):");
				value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setAge( Integer.parseInt(value) );
				} else {
					temp.setAge( member.getAge() );
				}
				System.out.print("전화(" + member.getTel() + "):");
				value = scanner.nextLine();
				if (!value.equals("")) {
					temp.setTel(value);
				} else {
					temp.setTel(member.getTel());
				}
				
				temp.setEmail(member.getEmail());
				
				System.out.print("변경하시겠습니까?(y/n)");
				value = scanner.nextLine();
				
				if (value.toLowerCase().equals("y")) {
					members.set(i, temp);
					System.out.println("변경 성공입니다.");
				} else {
					System.out.println("변경 취소하였습니다.");
				}
				return;
			}
		}
		
		System.out.println("해당 이메일의 멤버를 찾을 수 없습니다.");
	  
  }

	private static void processList() {
		System.out.println("----------------------------");
		System.out.println("이름 \t 나이 \t 전화");
		System.out.println("----------------------------");
		
		for (Member member : members) {
			System.out.print(member.getName() + "\t");
			System.out.print(member.getAge() + "\t");
			System.out.println(member.getTel());
		}
	  
  }

	private static void processAdd(Scanner scanner) {
		Member member = null;
		String command = null;
		
		do {
			member = new Member();
			
			System.out.print("이름:");
			member.setName(scanner.nextLine());
			
			System.out.print("나이:");
			member.setAge( Integer.parseInt(scanner.nextLine()) );
					
			System.out.print("이메일:");
			member.setEmail(scanner.nextLine());
			
			System.out.print("전화:");
			member.setTel(scanner.nextLine());
			
			System.out.print("등록하시겠습니까?(y/n)");
			command = scanner.nextLine();
			
			if (command.toLowerCase().equals("y")) {
				members.add(member);
				System.out.println("등록 성공입니다.");
			} else {
				System.out.println("등록 취소하였습니다.");
			}
			
			System.out.print("계속하시겠습니까?(y/n)");
			command = scanner.nextLine();
		} while (command.toLowerCase().equals("y"));
  }

	private static String[] prompt(Scanner scanner) {
	  System.out.print("명령>");
	  return scanner.nextLine().split(" ");
  }
}















