// 11. 배열
//	순서가 있는 리스트
let students = ["손석구", "마동석", "김두한"];
console.log(students[1]); // 인덱스는 0부터 시작 !!

// 배열은 문자뿐만 아니라, 숫자, 객체, 함수, ... 포함할 수 있음
let arr = [
	"또깡",
	3,
	true,
	{
		name : "똑강",
		age : 7,
	},
	function() {
		console.log("Test !");
	}
	
];
console.log(arr);

// length : 배열의 길이
console.log(students.length);

let days = ["월", "화", "수"];
console.log(days);

// push() : 배열 끝에 추가 (여러개 기능 O)
days.push("목");
console.log(days);

// pop() : 배열 끝의 요소를 제거
days.pop();
console.log(days);

// shift(), unshift() : 배열의 제일 앞에 있는 요소 제거 / 제일 앞에 요소 추가
days.unshift("일");
console.log(days);

days.shift();
console.log(days);

// unshift()는 요소를 여러개 추가할 수 있음 !!
days.unshift("목", "금", "토");
console.log(days);

// 배열을 쓰는 가장 큰 이유중에 하나는 => 반복문을 사용하기 위해서...
for (let i = 0; i < days.length; i++) {
	console.log(days[i]);
}
console.log("--------------------------");

// for .. of (Java의 for-each)
for (let day of days) {
	console.log(day);
}
