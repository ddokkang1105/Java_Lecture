// M
//		front-end������B (��ȿ���˻� ������ front-end������ A�� �������)
function check() {
	let x = document.f.x;
	let y = document.f.y;
	
	if(isEmpty(x) || isEmpty(y)
	|| isNotNumber(x) || isNotNumber(y)) {
		alert('Ouch !');
		return false;
	}	
	return true;
}



























