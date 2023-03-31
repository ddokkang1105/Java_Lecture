// 4. 형 변환

// String()		-> 문자형으로 변환
// Number()		-> 숫자형으로 변환
// Boolean()	-> 논리형으로 변환

// 형 변환은 왜 필요할까 ? 
//	자료형이 다른 두 변수를 계산했을 때, 원하지 않는 결과가 나올 수 있어서...?

// 수학, 영어 점수를 입력받아서 평균 점수를 출력해주는 프로그램
// 출력(document.write)

let mathScore = prompt("수학점수는 ?");
let engScore = prompt("영어점수는 ?");
let avg = (Number(mathScore) + Number(engScore)) / 2;

document.write("평균점수는 " + avg + "점입니다.<br>");

let mathScore2 = 80;
let engScore2 = 90;
let avg2 = (mathScore2 + engScore2) / 2;

document.write("평균점수는 " + avg2 + "점입니다.<br>");

// prompt로 받은 값은 무조건 문자형(String)
// "80" + "90" = 170(X) / "8090" (O)
// "8090" / 2 = 4045	... ?
// "8090"은 분명 문자열인데... 계산이 된다...?
//		숫자형이 아니더라도 표현식(+ - * /)을 활용했을 때 숫자형으로 변환할 수 있다면
//		자동으로 형 변환이 되어서 계산이 됨 !
//		'자동 형 변환' 이라고 함

// 자동 형 변환이 좋아보이지만 
// 원인을 찾기 힘든 에러를 발생시킬 여지가 충분히 있다 ! 독이 될 수 있음 !!
//		=> 항상 의도를 가지고 원하는 타입(자료형)으로 변환을 해서 사용하는 것이 좋다 !!
//			'명시적 형 변환'

// String() : S는 대문자 ! / 괄호 안에 값을 문자형으로 바꿔줌
document.write("---------------------------------------------<br>");
document.write("String() <br>");
document.write(
	String(3) + "<br>",
	String(true) + "<br>",
	String(false) + "<br>",
	String(null) + "<br>",
	// sString(undefined) + "<br>",
);
document.write("---------------------------------------------<br>");

// Number() : N은 대문자 ! / 괄호 안에 값을 숫자형으로 바꿔줌
document.write("Number() <br>");
document.write(
	Number("1234") + "<br>",		// 1234
	Number("asdf") + "<br>",		// NaN
	Number(true) + "<br>",			// 1
	Number(false) + "<br>",			// 0
	// Number(undefined) + "<br>",	// NaN
);
document.write("---------------------------------------------<br>");

// Boolean() : B는 대문자 / 괄호 안의 값을 논리형으로 바꿔줌

// false를 알아두면...
// - 숫자 0
// - 빈 문자열("") / 띄어쓰기 X
// - null
// - undefined
// - NaN
//	이외에는 모두 true가 됨 !

// 주의사항 -> 딱히 설명이 없어서... 인지해두는게 좋다
Number(null);		// 0
Number(undefined);	// NaN

let a = Number(prompt("asdf"));
document.write(a + "<br>"); // prompt에 값을 넣지 않았다면 ?
							// => 값을 넣지 않아서 null
							// Number(null); => 0















