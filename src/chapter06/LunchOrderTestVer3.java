package chapter06;

import java.util.Scanner;

/*
 * 음식 주문/결제 프로그램(콘솔)
 * - 음식을 주문(1), 결제(2), 프로그램 종료(9)하는 메뉴로 구성된다.
 * - 프로그램 종료를 제외하고 나머지 메뉴는 반복 선택 가능하다.
 * - 메뉴 선택 시 체크하는 기능은 switch~case를 이용하여 구현한다.
 * 
 * < 추가 사항 >
 * 1) 예외사항 처리 
 * 		: 메뉴 선택, 결제금액 이력 시 정수형 타입이 아닌 경우 메세지 출력 후 재입력 요구
 * 2) 입력값이 정확할 때까지 재입력을 유도하여 진행, flag 변수를 이용하여 반복
 * 3) 결제 급액이 부족한 경우 재입력을 통해 금액을 누적으로 계산하여 저장 후 결제	
 */

public class LunchOrderTestVer3 {

	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);		
		boolean menuFlag = true;
		
		//주문 음식 리스트
		String[] menuList = {"🍕(피자)","🍔(햄버거)","🍜(라멘)","🍣(초밥)"};
		int[] priceList = {100,200,300,400};
		
		//주문 리스트 선언 및 생성 : 3개까지 주문
		System.out.println("주문 리스트 크기> ");
		final int MAX_SIZE = scan.nextInt();
		String orderMenuList[] = new String[MAX_SIZE];
		int orderPriceList[] = new int [MAX_SIZE];
		int count = 0;
		
		//결제 리스트
		//메뉴명, 결제금액, 입금액, 잔돈	
		String paymentMenuList[] = new String[MAX_SIZE];
		int totalAmountList[] = new int[MAX_SIZE];
		int paidAmountList[] = new int[MAX_SIZE];
		int chageList[] = new int[MAX_SIZE];
		int paymentCount = 0;
				
//		String orderPayList[] = new String[MAX_SIZE];
//		int pay_count = 0;
		
		while(menuFlag) { //메뉴 선택	
			System.out.println("***********************");
			System.out.println("\t Welcome to Food Mart");
			System.out.println("***********************");
			System.out.println("1.주문");
			System.out.println("2.주문 리스트 출력");
			System.out.println("3.결제");
			System.out.println("4.결제 리스트 출력");
			System.out.println("9.프로그램 종료");
			System.out.println("***********************");
			
			System.out.print("메뉴 선택> ");
			int menu = scan.nextInt();
			
			switch(menu) {
				case 1:
//					System.out.println("주문");
					boolean orderFlag = true;
					while(orderFlag) {
						System.out.println("***********************");
						System.out.println("\t 1.🍕:100원 \t 2.🍔:200원 \t 3.🍜:300원 \t 4.🍣:400원");
						System.out.println("***********************");
						System.out.println("주문 메뉴 선택 > ");
						if(scan.hasNextInt()) {
							int menu_num = scan.nextInt();				
//							String menuName = null;
//							int menuPrice = 0;
							
							if(1<=menu_num && menu_num<=4) {
								orderMenuList[count] = menuList[menu_num-1];
								orderPriceList[count] = priceList[menu_num-1];
								System.out.println(menuList[menu_num-1] + "주문완료");
								count++;
							}else {
								System.out.println("메뉴 준비중 입니다.");
							}				

							//주문 갯수 체크
							if(count == MAX_SIZE) {
								System.out.println("주문은 최대 "+MAX_SIZE+"개까지 가능합니다.");
								break; //orderFlag = false;
							}else {
								System.out.println("계속 주문하시겠습니까?(아무키:주문, 종료:n)");
								if(scan.next().equals("n")){
									orderFlag = false;
								}
							}
							
						} else {
							System.out.println("올바르지 않은 입력값입니다.");
							System.out.println("다시 입력해 주세요.");
							scan.next();
						}//if
					}//while
					break;
						
				case 2: //주문 리스트
					if(count !=0) {
						System.out.println("*********************");
						System.out.println("번호\t메뉴\t가격");
						System.out.println("*********************");
						for(int i=0; i<count; i++) {
							System.out.print((i+1)+"\t");
							System.out.print(orderMenuList[i]+"\t");
							System.out.print(orderPriceList[i]+"\t");
							System.out.println();
						}
					}else {
						System.out.println("주문 내역이 없습니다.");
					}
					break;
				case 3: //음식 결제
					if(count !=0) {
						boolean paymentFlag = true;
						int charge = 0;
						int change = 0;
						int totalPayment = 0;
						for(int i=0; i<count; i++) {
							totalPayment += orderPriceList[i];
						}
						while(paymentFlag) { //결제 요금 부족 시 반복 실행					
							System.out.println("결제 예정 금액 : "+totalPayment);
							System.out.println("결제할 요금 입력 > ");
							
							if(scan.hasNextInt()) {
								charge += scan.nextInt();
								System.out.println("총 입력 금액 : " + charge);
								
								if(charge >= totalPayment) {
									change = charge - totalPayment;
									System.out.println("잔돈 : " + change);
									paymentFlag = false;									
								} else {
									System.out.println("요금이 부족합니다. 다시 입력해 주세요.");
								}
								
							} else {
								System.out.println("올바르지 않은 입력값입니다. 다시 입력해 주세요.");
							}
						}//while - payment
						paymentMenuList[paymentCount] = orderMenuList[0]+"등..";
						totalAmountList[paymentCount] = totalPayment;
						paidAmountList[paymentCount] = charge;
						chageList[paymentCount] = change;
						
						System.out.println("*******************");
						System.out.println("결제 완료");
						System.out.println("*******************");
						System.out.println("음식 결제 내역");
						System.out.println("*******************");
						System.out.println("메뉴명\t결제 금액\t총 금액\t잔돈");
						System.out.print(paymentMenuList[paymentCount]+"\t");
						System.out.print(totalAmountList[paymentCount]+"\t");
						System.out.print(paidAmountList[paymentCount]+"\t");
						System.out.print(chageList[paymentCount]+"\n");
						System.out.println("*******************");
								
//						orderPayList[pay_count] = "orderMenuList[0]+ "등..\t"+totalPayment + "\t"+charge+"\t"+change;
//						pay_count++;
						
						//orderMenuList, orderPriceList 초기화
						for(int i=0; i<count; i++) {
							orderMenuList[i] = null;
							orderPriceList[i] = 0;
						}
//						또는 아래 처럼 초기화
//						orderMenuList = new String[MAX_SIZE];
//						orderPriceList = new int[MAX_SIZE];
						
						count = 0;	
						paymentCount ++;
					}else {
						System.out.println("주문 내역이 없습니다.");
					}
					break;
				case 4:
					System.out.println("*******************");
					System.out.println("메뉴명\t결제 금액\t총 금액\t잔돈");
					System.out.println("*******************");
					for(int i=0; i<paymentCount; i++) {
						System.out.print((i+1)+" ");
						System.out.print(paymentMenuList[i]+"\t");
						System.out.print(totalAmountList[i]+"\t");
						System.out.print(paidAmountList[i]+"\t");
						System.out.print(chageList[i]+"\n");
					}
//					System.out.println("*******************");
//					System.out.println("메뉴명\t결제 금액\t총 금액\t잔돈");
//					System.out.println("*******************");
//					for(String name : orderPayList) { 
//						System.out.println(name);
//					}
					break;
				case 9:
					System.out.println("프로그램 종료");
					System.exit(0);
					break;
				default:
					System.out.println("메뉴 준비중 입니다.");
			}
		}
	}

}
