// 10. 객체 (Object)

// 강아지 이름 : 뚜비 / 나이는 3살
let dog = {
	name : "뚜비",
	age : 3,
}

// 객체는 중괄호 안에서 구성되며, key와 value값으로 구성된 속성(Property)이 들어감
// 각각 쉼표로 구분하고, 마지막에는 쉼표가 없어도 되지만, 
// 나중에 이것저것 수정할 것을 생각하면 쉼표 적어놓는 것도 괜찮음 !

// 접근
console.log(dog.name);
console.log(dog['age']);

// 추가
dog.gender = "Male";
dog['furColor'] = "White";

// 삭제
delete dog.furColor;
////////////////////////////////////////////////////////////
// 단축 프로퍼티

let name = "Merry";
let age = 7;
// 의 객체 => 이름 / 나이 / 성별

/*
let cat = {
	name : name,
	age : age,
	gender : undefined,
}

cat.gender = "Female";
console.log(cat.gender);
*/

let cat = {
	name,
	age,
	gender : "Female",
} // 이런 형태로도 표현이 가능하다 !! (이 떼, key와 value에서 받아올 변수의 이름이 같아야)

console.log(cat.name);

// 존재하지 않는 속성에 접근하면, 에러가 발생하는게 아닌 undefined값이 나옴
console.log(cat.hairColor);	// undefined

// 이 때, 'in' 연산자를 사용하면 내가 찾는 속성이 있는지 확인할 수 있음
//	in : 어떤 값이 있는지 확인하는 용도로 사용
console.log('birthday' in cat); // false
console.log('age' in cat); // true

for (let key in cat) {
	console.log(key);		// key값
	console.log(cat[key]);	// value값
}

// 함수로 객체 만들기
function makeObject(name, age) {
	return{
		name,
		age,
		hobby: "Golf",
	}
}


let ddokkang = makeObject("Ddokkang", 5);
console.log(ddokkang);























































