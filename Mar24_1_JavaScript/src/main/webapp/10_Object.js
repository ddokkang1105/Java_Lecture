// 10. ��ü (Object)

// ������ �̸� : �Ѻ� / ���̴� 3��
let dog = {
	name : "�Ѻ�",
	age : 3,
}

// ��ü�� �߰�ȣ �ȿ��� �����Ǹ�, key�� value������ ������ �Ӽ�(Property)�� ��
// ���� ��ǥ�� �����ϰ�, ���������� ��ǥ�� ��� ������, 
// ���߿� �̰����� ������ ���� �����ϸ� ��ǥ ������� �͵� ������ !

// ����
console.log(dog.name);
console.log(dog['age']);

// �߰�
dog.gender = "Male";
dog['furColor'] = "White";

// ����
delete dog.furColor;
////////////////////////////////////////////////////////////
// ���� ������Ƽ

let name = "Merry";
let age = 7;
// �� ��ü => �̸� / ���� / ����

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
} // �̷� ���·ε� ǥ���� �����ϴ� !! (�� ��, key�� value���� �޾ƿ� ������ �̸��� ���ƾ�)

console.log(cat.name);

// �������� �ʴ� �Ӽ��� �����ϸ�, ������ �߻��ϴ°� �ƴ� undefined���� ����
console.log(cat.hairColor);	// undefined

// �� ��, 'in' �����ڸ� ����ϸ� ���� ã�� �Ӽ��� �ִ��� Ȯ���� �� ����
//	in : � ���� �ִ��� Ȯ���ϴ� �뵵�� ���
console.log('birthday' in cat); // false
console.log('age' in cat); // true

for (let key in cat) {
	console.log(key);		// key��
	console.log(cat[key]);	// value��
}

// �Լ��� ��ü �����
function makeObject(name, age) {
	return{
		name,
		age,
		hobby: "Golf",
	}
}


let ddokkang = makeObject("Ddokkang", 5);
console.log(ddokkang);























































