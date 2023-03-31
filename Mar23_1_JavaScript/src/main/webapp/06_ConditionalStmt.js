// 논리 연산자, 비교연산자, 일치 연산자 결과값으로 나온 true, false를 가지고...
// 6. 조건문
//	어떤 조건에 따라서 이후에 실행이 달라지게 하는 !

// if문 (Java와 같다)
//	if절 괄호안에 조건을 따져서 true라면 실행하게끔 !
//		if - else if - else
//			... 예제 생략 ... ㅋ

// switch - case
//	case가 다양할 때, 보다 간결하게 나타낼 수 있는 장점

// 사과 : 100원
// 바나나 : 200원
// 키위 : 300원
// 멜론 : 500원
// 수박 : 500원
// 사고 싶은 과일을 입력!해서 그 가격을 출력(alert)
let input = prompt('먹고 싶은 과일 뭐냐 ?', '사과, 바나나, 키위, 멜론, 수박 중 1개만')
let price = 0;
switch (input) {
	case "사과":
	price = 100;
		break;
	case "바나나":
	price = 200; 
		break;
	case "키위": 
	price = 300; 
		break;
	case "멜론": 
	case "수박": 
	price = 500; 
		break;
	default :
	price = null;
		break;
};

if (price == null) {
	alert('그런거 없어 ~~')
} else {
	alert(`${input} ! 그것은 말이여 ~ 음 보자 ~  ${price} 냥 ~ `);
}














































