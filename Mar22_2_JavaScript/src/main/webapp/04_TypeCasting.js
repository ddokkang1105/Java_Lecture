// 4. �� ��ȯ

// String()		-> ���������� ��ȯ
// Number()		-> ���������� ��ȯ
// Boolean()	-> �������� ��ȯ

// �� ��ȯ�� �� �ʿ��ұ� ? 
//	�ڷ����� �ٸ� �� ������ ������� ��, ������ �ʴ� ����� ���� �� �־...?

// ����, ���� ������ �Է¹޾Ƽ� ��� ������ ������ִ� ���α׷�
// ���(document.write)

let mathScore = prompt("���������� ?");
let engScore = prompt("���������� ?");
let avg = (Number(mathScore) + Number(engScore)) / 2;

document.write("��������� " + avg + "���Դϴ�.<br>");

let mathScore2 = 80;
let engScore2 = 90;
let avg2 = (mathScore2 + engScore2) / 2;

document.write("��������� " + avg2 + "���Դϴ�.<br>");

// prompt�� ���� ���� ������ ������(String)
// "80" + "90" = 170(X) / "8090" (O)
// "8090" / 2 = 4045	... ?
// "8090"�� �и� ���ڿ��ε�... ����� �ȴ�...?
//		�������� �ƴϴ��� ǥ����(+ - * /)�� Ȱ������ �� ���������� ��ȯ�� �� �ִٸ�
//		�ڵ����� �� ��ȯ�� �Ǿ ����� �� !
//		'�ڵ� �� ��ȯ' �̶�� ��

// �ڵ� �� ��ȯ�� ���ƺ������� 
// ������ ã�� ���� ������ �߻���ų ������ ����� �ִ� ! ���� �� �� ���� !!
//		=> �׻� �ǵ��� ������ ���ϴ� Ÿ��(�ڷ���)���� ��ȯ�� �ؼ� ����ϴ� ���� ���� !!
//			'����� �� ��ȯ'

// String() : S�� �빮�� ! / ��ȣ �ȿ� ���� ���������� �ٲ���
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

// Number() : N�� �빮�� ! / ��ȣ �ȿ� ���� ���������� �ٲ���
document.write("Number() <br>");
document.write(
	Number("1234") + "<br>",		// 1234
	Number("asdf") + "<br>",		// NaN
	Number(true) + "<br>",			// 1
	Number(false) + "<br>",			// 0
	// Number(undefined) + "<br>",	// NaN
);
document.write("---------------------------------------------<br>");

// Boolean() : B�� �빮�� / ��ȣ ���� ���� �������� �ٲ���

// false�� �˾Ƶθ�...
// - ���� 0
// - �� ���ڿ�("") / ���� X
// - null
// - undefined
// - NaN
//	�̿ܿ��� ��� true�� �� !

// ���ǻ��� -> ���� ������ ���... �����صδ°� ����
Number(null);		// 0
Number(undefined);	// NaN

let a = Number(prompt("asdf"));
document.write(a + "<br>"); // prompt�� ���� ���� �ʾҴٸ� ?
							// => ���� ���� �ʾƼ� null
							// Number(null); => 0















