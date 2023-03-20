package com.ddokkang.franc.main;

import java.util.ArrayList;

import com.ddokkang.franc.reservation.Reservation;

public class Controller {
	// 프로그램을 실행 !
	public static void main(String[] args) {
		int menu = 0;
		String result = null;
		Reservation rsv = null;
		Restaurant rtr = null;
		ArrayList<Reservation> rsvResult = null;
		ArrayList<Restaurant> rtrResult = null;
		
		System.out.println("<< 예약 프로그램 >>");
		while (true) {
			try {
				menu = ConsoleScreen.ShowMainMenu();
				System.out.println("=============================================");
				if (menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					switch (menu) {
					case 1:
						rsv = ConsoleScreen.showRsvMenu();
						result = DAO.book(rsv);
						System.out.println(result);
						break;
					case 2:
						rtr = ConsoleScreen.registRtrMenu();
						result = DAO.regist(rtr);
						System.out.println(result);
						break;
					case 3:
						rsvResult = DAO.getAllReserve();
						ConsoleScreen.showRsvResultMenu(rsvResult);
						break;
					case 4:
						rtrResult = DAO.getAllRestaurant();
						ConsoleScreen.showRtrResultMenu(rtrResult);
						break;
					case 5:
						rtr = ConsoleScreen.showSearchRtrMenu();
						rtrResult = DAO.searchRestaurant(rtr);
						ConsoleScreen.showRtrResultMenu(rtrResult);
						break;
					case 6:
						rsv = ConsoleScreen.showSearchRsvMenu();
						rsvResult = DAO.searchReservation(rsv);
						ConsoleScreen.showRsvResultMenu(rsvResult);
						break;
					case 7:
						rsvResult = DAO.getAllReserve();
						ConsoleScreen.showRsvResultMenu(rsvResult);
						System.out.println("=============================================");
						rsv = ConsoleScreen.showUpdateMenu();
						result = DAO.updateReserve(rsv);
						System.out.println(result);
						System.out.println("=============================================");
						rsvResult = DAO.getAllReserve();
						ConsoleScreen.showRsvResultMenu(rsvResult);
						break;
					case 8:
						rsvResult = DAO.getAllReserve();
						ConsoleScreen.showRsvResultMenu(rsvResult);
						System.out.println("=============================================");
						rsv = ConsoleScreen.showDeleteRsvMenu();
						result = DAO.cancle(rsv);
						System.out.println(result);
						System.out.println("=============================================");
						rsvResult = DAO.getAllReserve();
						ConsoleScreen.showRsvResultMenu(rsvResult);
						break;
					default:
						System.out.println("잘못 입력하였읍니다.");
						break;
					}
				}
				
				
			} catch (Exception e) {
				System.out.println("=============================================");
				System.out.println("잘못 입력하였읍니다.");
//				e.printStackTrace();
			}
		}
		
		
		
	}
}
