function getNumber() {
	let x = document.cal.x;
	let y = document.cal.y;
	
	if (isEmpty(x) || isEmpty(y)) {
		alert('Insert More !');
		x.value = "";
		y.value = "";
		x.focus();
		return false;
	}
	
	if (isNotNumver() || isNotNumver()) {
		alert('Not Number !');
		x.value = "";
		y.value = "";
		x.focus();
		return false;
	}
	
	return true;
}






















