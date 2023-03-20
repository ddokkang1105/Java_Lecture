
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleScreen {
	// ����ڰ� �ܼ��� �� �� �ְų�, �ֿܼ� �Է��� �� �ְ�
	// �޴��� �� �� �ִ� ��ɵ� �־�����...
	static Scanner k = new Scanner(System.in);
	
	
	// 1. �����ϱ�(���� �Է�, ��¥�� ��-��-��/��:��)
	public String[] reserve() throws SQLException {
		System.out.println("������ �����մϴ�.");
		System.out.println("=============================================");
		String[] reservation = new String[4];
		System.out.print("������ ���� : ");
		k = new Scanner(System.in);
		String name = k.nextLine();
		reservation[0] = name;
		System.out.print("������ �ð� (YYYY-MM-DD 24H) : ");
		String time = k.nextLine();
		reservation[1] = time;
		System.out.print("������ ��ȭ��ȣ (XXX-XXXX-XXXX) : ");
		String phoneNum = k.nextLine();
		reservation[2] = phoneNum;
		System.out.print("������ ���� : ");
		String location = k.nextLine();
		String[] check = DAO.loadRestaurant();
		DAO.checkRestaurant(check, location);
		reservation[3] = location;
		System.out.println("=============================================");
		return reservation;
		
	}
	
	// 2. ���� ���
	public String[] registRest() {
		System.out.println("�Ĵ� ����� �����մϴ�.");
		System.out.println("=============================================");
		String[] restaurantInfo = new String[3];
		System.out.println("�Ĵ� ��ġ (~��) : ");
		String location = k.next();
		restaurantInfo[0] = location;
		System.out.println("�Ĵ� ���� : ");
		String owner = k.next();
		restaurantInfo[1] = owner;
		System.out.println("�Ĵ� �¼� : ");
		String seat = k.next();
		restaurantInfo[2] = seat;
		System.out.println("=============================================");
		return restaurantInfo;
	}
	
	// 3. ��ü ���� ���� Ȯ�� (��¥�� ��-��-�� ���� ����/���� ��:��)
	public void checkReservation() {
		System.out.println("��ü ���� ������ Ȯ���մϴ�.");
		System.out.println("=============================================");
	}
	
	// 4. ��ü ���� ��ȸ (��ġ(�¼� ��) - ����� �̸�)
	public void showRest() {
		System.out.println("��ü ������ ��ȸ�մϴ�. ��ġ(�¼�)-����� ����");
		System.out.println("=============================================");
	}
	
	// 5. ���� ã�� (�ּ� �¼��� �Է� => �¼� �� �̻��� ���� ������ ���)
	public int searchRest() {
		int seat = 0;
		System.out.println("�Է��� �¼� �� �̻��� ���� ������ ��ȸ�մϴ�.");
		System.out.println("=============================================");
		System.out.print("�¼� ���� �Է��ϼ��� : ");
		seat = k.nextInt();
		System.out.println("=============================================");
		return seat;
	}
	
	// 6. ���� ã�� (������ �̸�)
	public String searchReservation() {
		String name = null;
		System.out.println("������ ������ ��ȸ�մϴ�.");
		System.out.println("=============================================");
		System.out.print("�����Ͻ� ������ �Է��ϼ��� : ");
		name = k.next();
		System.out.println("=============================================");
		return name;
	}
	
	// 7. ���� ���� ���� (�����ȣ�� �Է��ϸ�, ����ó�� ����)
	public String[] changeReservation() {
		String[] changeReservation = new String[2];
		String num = null;
		String phoneNum = null;
		System.out.println("������ ����ó�� �����մϴ�.");
		System.out.println("=============================================");
		System.out.print("�����ȣ�� �Է��ϼ��� : ");
		num = k.nextLine();
		changeReservation[0] = num;
		System.out.print("������ ����ó(XXX-XXXX-XXXX) : ");
		phoneNum = k.nextLine();
		changeReservation[1] = phoneNum;
		
		System.out.println("=============================================");
		return changeReservation;
	}
	// 8. ���� ��� (�����ȣ�� ���)
	public String cancleReservation() {
		String cancleReservation = null;
		System.out.println("������ ����մϴ�.");
		System.out.println("=============================================");
		System.out.print("�����ȣ�� �Է��ϼ��� : ");
		cancleReservation = k.next();
		return cancleReservation;
	}
	
	// 9. ����
	public void exitProgram() {
		System.out.println("�߸��� �������Դϴ�.");
		System.out.println("=============================================");
	}
}
