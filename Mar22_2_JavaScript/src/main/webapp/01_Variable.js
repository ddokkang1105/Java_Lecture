// JavaScript
//		���������� ���
//		��Ÿ �ȳ��� ���� !!

// 1. ����
//		: �����͸� ���� �׸�

// ������ �����ϴ� ���
//		- alert()				: ���â�� ����ִ� �Լ�
//		- console.log()			: �α׸� ����ִ� �Լ�
//		- document.write()		: ���������� ������ ���

// name = "Ddokkang";
// age = 1000;			// �̷� ����� ������ ! (���� ������ �����̱� ���� !!)

// �̰� �����ϱ� ���ؼ� ���� ������ ���·� 3���� ����� �ִµ�...
//		var, let, const

// �� var : var(iable)
//		�ߺ��ؼ� ���� + �ʱ�ȭ 
var a = 10;			// ���� ���� + �ʱ�ȭ
console.log(a);		// 10
var a = 20;			// ���� ���� + �ʱ�ȭ
console.log(a);		// 20
var a = 30;			// ���� ���� + �ʱ�ȭ
console.log(a);		// 30
var a;				// ���� ���� : �������� �Ҵ�� ���� �� ������ ����
console.log(a);		// 30
// -> ������ ������ �� ������ ��԰� �ٽ� ���� �Ҵ��ϴ� �Ǽ��� �߻��� �� ���� !!

// �� let : Java ���� ���� ���� ���� ����(������ �ߺ� X !)
// let name = "��Ǳ�";
// console.log(name);
// let name = "���Ǳ�";	// �̹� name�� ��Ǳ����� ����Ǿ��ֱ� ������ ���� �߻� !!
// console.log(name);

// let�� �ѹ� ������ �Ŀ� ���� �ٲ��� �� ���� !!
let grade = "F";
console.log(grade);
grade = "A+";			// ������ = ��; �� ���·� ������ ���� O
console.log(grade);

// �� const : ���� ����� �ٲ��� �ʴ� ���
//		������ �ȵǰ�, �����Ϸ��� �ϸ� ������ �߻���
//		�׷��� ���̰�, �ִ밪/�ּҰ�, ����, ...
//		const �������� �빮�ڷ� ����ϴ� ��ȭ !
const PI = 3.141592;
console.log(PI);
// PI = 1234;
// console.log(PI);

// ���� !
//		JS���� ������ ������ ��
//		���� �� �ִ� ���� var, let
//		������ �ʴ� ���� const�� ����

// JS ������ ���� ���� !! (Java�� ����)
// 1. ������ ���ڿ� ����, $, _ �� ��� O
// 2. ù ���ڷδ� ���� X
// 3. ������ ��� X
// 4. �������� �б� ���� ������ �� �ְ� !
// 5. const ������ ���� �� �������̸� �빮�ڷ� !