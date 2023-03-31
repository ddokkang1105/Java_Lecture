// 9. ȭ��ǥ �Լ� (Arrow Function)

// 8�� ���Ͽ��� �ٷ�� �Լ��� '�Լ� ����' �̶�� ��
/*
function sayHello() {
	console.log('Hello !');
}
sayHello();
*/

// '�Լ� ǥ����' �̶�� ��
/*
let sayHello = function sayHello() {
	console.log('Hello !');
}
sayHello();
console.log(sayHello);
*/

// �������� � ���̰� ������ ?! -> ���� 'ȣ���ϴ� Ÿ�̹� !'
// �Լ� ������ ��𼭵��� ȣ���ؼ� ����� ���� ���� O => ��� ���ɾ� ??

sayHello();
function sayHello() {
	console.log('Hello !');
}

// JS�� ���α׷��� ����Ǳ� ���� ��� '�Լ� ����'�� ã�� ��Ƽ�
// �޸𸮿� �����ϰ� �ִٰ� �ʿ��� �� ���������� ����緯�� ����ϴ� ��
//	����Ǿ��ֱ� ������ -> �Լ��� ���� ȣ���� �Ǿ �������� �� �۵��� O
//	������ �ڵ尡 ����÷����°� �ƴϰ�, ���� �޸𸮻󿡴� ū ��ȭ�� ����
//	�̰��� 'ȣ�̽���(Hoisting)' �̶�� ��

// '�Լ� ǥ����'�� �ڵ忡 �����ϸ� ����
// '�׷��� �� ���� �ǳ��� ?' => ���� ���ٱ� ���ٴ� �׳� ���Ѱ� ������ ~
//	�� �����Ӱ� ���ϰ� �ڵ��ϰ� �ʹ� ?! => �Լ� ����

// 1.
/*
let add = function (num1, num2) {
	return num1 + num2;
}
console.log(add(1, 3));
*/

// 2.
/*
let add = (num1, num2) => {
	return num1 + num2;
} 
*/

// 3. return�� ���� ���� O
/*
let add = (num1, num2) => {
	num1 + num2;
}
*/

// 4. ������ �ڵ尡 �� �� �̶�� => �߰�ȣ ���� ���� O
let add = (num1, num2) => num1 + num2;

// 5. �Ķ���Ͱ� �ϳ���� ... => �Ķ���Ͱ� �� �Ұ�ȣ ���� ���� O ()
let sayHello2 = name => `Hwllo, ${name}`;

// 6. �Ķ���Ͱ� ���� �Լ���� => �Ұ�ȣ�� ���� �Ұ� !!
let add1 = () => 'Hello !';
console.log(add1());

// Function vs Method
let human = {
	name : "��Ǳ�",
	walk : function() {
		console.log("�ѹ��ѹ�");
	} // method : ��ü �Ӽ�(property)���� �Ҵ� �� �Լ�
}




















