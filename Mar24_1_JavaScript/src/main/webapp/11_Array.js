// 11. �迭
//	������ �ִ� ����Ʈ
let students = ["�ռ���", "������", "�����"];
console.log(students[1]); // �ε����� 0���� ���� !!

// �迭�� ���ڻӸ� �ƴ϶�, ����, ��ü, �Լ�, ... ������ �� ����
let arr = [
	"�Ǳ�",
	3,
	true,
	{
		name : "�Ȱ�",
		age : 7,
	},
	function() {
		console.log("Test !");
	}
	
];
console.log(arr);

// length : �迭�� ����
console.log(students.length);

let days = ["��", "ȭ", "��"];
console.log(days);

// push() : �迭 ���� �߰� (������ ��� O)
days.push("��");
console.log(days);

// pop() : �迭 ���� ��Ҹ� ����
days.pop();
console.log(days);

// shift(), unshift() : �迭�� ���� �տ� �ִ� ��� ���� / ���� �տ� ��� �߰�
days.unshift("��");
console.log(days);

days.shift();
console.log(days);

// unshift()�� ��Ҹ� ������ �߰��� �� ���� !!
days.unshift("��", "��", "��");
console.log(days);

// �迭�� ���� ���� ū �����߿� �ϳ��� => �ݺ����� ����ϱ� ���ؼ�...
for (let i = 0; i < days.length; i++) {
	console.log(days[i]);
}
console.log("--------------------------");

// for .. of (Java�� for-each)
for (let day of days) {
	console.log(day);
}
