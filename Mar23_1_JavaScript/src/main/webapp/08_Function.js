// 8. 함수 (Function)
//	서비스를 만들다보면 같거나, 비슷한 기능을 가지기 마련..
//		팝업창, 결제, ...
//	매번 새롭게 만들지 말고 ! => 자주 사용하는 기능들을 하나로 묶어다 불러다쓰자 !

/* function 함수명 (파라미터) {
	내용
}
*/
// 의 형태고, 함수명(파라미터); 로 호출하면 됨

// 파라미터 없는 함수
function showError() {
	alert('Error !');
}
showError();
// 이 메시지를 하나의 서비스 중 여러군데에 쓰고 있다고 가정하면...
//		ex) 로그인 실패, 결제 실패, ...
// 위에 showError(); 를 불러다가 쓰면 되겠네 ~~

// 파라미터 있는 함수
/*function sayHello(name) {
	let msg = `Hello, ${name}`;
	alert(msg);
}
sayHello("Ddokkang");
// 만약에 이름을 입력하지 않았다면 ... ?
sayHello(); // => undefined
*/ 

/*function sayHello(name) {
	let msg = "Hello";
	if (name) {
		msg += `, ${name}`;
	}
	alert(msg);
}
sayHello();
sayHello("Ddokkang");*/

let msg = "Hello"; // 어디에서나 접근할 수 있는 변수 : 전역 변수 (Global Variable)
console.log("함수 호출 전");
console.log(msg);


function sayHello(name) {
	let msg = "Hello"; // 함수 내부에서 접근할 수 있는 변수 : 지역 변수 (Local Variable)
	if (name) {
		msg += `, ${name}`;
	}
	console.log(msg);
	console.log("함수 내부");
}

sayHello("Ddokkang");
console.log("함수 호출 후");
console.log(msg);
// 지역변수는 함수 내에서 전역변수의 같은 이름으로 지을 수 있고,
//	서로 간섭을 받지 않음

// 전역변수가 많아진다면 관리하기 힘들기 때문에...
//		=> 가능하면 함수에 특화되어있는 지역변수를 사용하자 !!

// OR를 활용해서 기본값 넣기
function sayHello2(name) {
	let newName = name || 'Friend';
	let msg = `Hello, ${newName}`;
	console.log(msg);
}

sayHello2();			// 값을 넣지 않으면 'Friend' (null / undefined)
sayHello2("Ddokkang");	// 값을 넣으면 'Ddokkang'

// 기본값을 설정해서 (default value)
function sayHello3(name = 'Friend') {
	let msg = `Hello, ${name}`;
	console.log(msg);
}

sayHello2();			
sayHello2("Ddokkang");	

// return으로 값 반환하기
function add(num1, num2) {
	return num1 + num2;
}
let result = add(1, 3);
console.log(result);

// return은 반환하는 것과 동시에 함수를 종료하는 기능도 있음 !

// 정리
//	- 함수는 한번에 한 작업만 하는게 좋다!!
//		-> 하나의 함수가 여러 작업을 진행한다면, 여러개 함수로 구현하기 !!
//	- 함수명은 읽기 쉽고, 어떤 기능인지 알 수 있게 네이밍하기 !!




























