// 5. 연산자
//	산술 연산자 : + - * / %

// 거듭제곱
// let num1 = 2 ** 3;
// alert(num1);

// 우선 순위
// (*, /) > (+, -)

// 연산자를 줄여서 쓰는 것도 가능 O
let num1 = 10;
num1 += 5;

// 증감 연산자
let num2 = 20;
num2++;
document.write(num2 + "<br>");		// 21

let result = num2++;		// 후위 연산자
document.write(result + "<br>");		// 21

let result2 = ++num2;		// 전위 연산자
document.write(result2 + "<br>");	// 23
document.write("-------------------------------------------<br>");

// -> ++을 뒤에 적으면 증가시키기 전의 값을 담고,
//			앞에 적으면 증가시킨 값을 담음 !

// 비교연산자 (Java때와 같음 !)
// < > <= >= == !=

document.write((10 > 5) + "<br>");
document.write((10 == 5) + "<br>");
document.write((10 < 5) + "<br>");
document.write("-------------------------------------------<br>");

// "10"과 10이 같은지 비교
document.write("\"10\" == 10 ?? " + "<br>");
document.write((String(10) == 10) + "<br>");
//		=> 자동 형변환 때문에 !
document.write((String(10) === 10) + "<br>");
document.write(typeof((String(10) / 10)) + "<br>");
document.write("-------------------------------------------<br>");
//		=> ===, !== : 일치연산자 / 값뿐만 아니라 자료형까지 비교 / 꽤나 유용하다 ~

// 논리연산자
// || (OR)
// 여러개 중 하나라도 true면 true를 반환
//		-> 모든 값이 false일때만 false를 반환
// => 첫번째 true값을 발견하는 즉시 멈춤

// && (AND)
// 모든 값이 true여야 true를 반환
//		=> 하나라도 false가 나오면 false를 반환
// => 첫번째 false값을 발견하는 즉시 멈춤

// ! (NOT)
// 반대의 값으로 반환
// true -> false / false -> true







































