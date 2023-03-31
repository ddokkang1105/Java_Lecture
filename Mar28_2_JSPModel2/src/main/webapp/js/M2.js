// M
//		front-end개발자B (유효성검사 보물도 front-end개발자 A가 만들었음)
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



























