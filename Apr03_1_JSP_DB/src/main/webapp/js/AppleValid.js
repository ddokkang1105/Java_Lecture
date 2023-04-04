function appleValid() {
	let a_loc = document.apple.a_loc;
	let a_price = document.apple.a_price;
	let a_intro = document.apple.a_intro;
	
	if (isEmpty(a_loc) || isEmpty(a_price) || isEmpty(a_intro)) {
		alert('Input More !');
		return false;
	}
	
	if (containsAnother(a_loc)) {
		alert('No Symbol (Except "@", "_", ".") !');
		a_loc.value = "";
		a_loc.focus();
		return false;
	}
	
	if (isNotNumber(a_price)) {
		alert('Only Number !');
		a_price.value = "";
		a_price.focus();
		return false;
	}
	
	if (atLeastLetter(a_loc, 4) || atLeastLetter(a_price, 4)
	|| atLeastLetter(a_intro, 4)) {
		alert('More than 4 Letters !');
		return false;
	}
	
	return true;
}

