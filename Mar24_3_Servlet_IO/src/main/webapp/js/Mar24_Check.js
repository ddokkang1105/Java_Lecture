function bmiTest() {
	let nameInput = document.bmi.name;
	let heightInput = document.bmi.height;
	let weightInput = document.bmi.weight;
	let imgInput = document.bmi.image;
	
	if (isEmpty(nameInput)) {
		alert('No Name');
		nameInput.focus();
		return false;
	} else if (containsAnother(nameInput)) {
		alert('Insert only English');
		nameInput.focus();
		nameInput.value="";
		return false;
	} else if (atLeastLetter(nameInput, 3)) {
		alert('Input More Letters');
		nameInput.focus();
		nameInput.value="";
		return false;
	}
	
	if (isEmpty(heightInput)) {
		alert('No Height');
		heightInput.focus();
		return false;
	} else if (atLeastLetter(heightInput, 3)) {
		alert('The Form is XXX.XCM');
		heightInput.focus();
		heightInput.value="";
		return false;
	} else if (isNotNumber(heightInput)) {
		alert('Input Only Number');
		heightInput.focus();
		heightInput.value="";
		return false;
	} else if (Number(heightInput.value) >= 200) {
		alert('No way ~');
		weightInput.focus();
		weightInput.value="";
		return false;
	}
	
	if (isEmpty(weightInput)) {
		alert('No Weight');
		weightInput.focus();
		return false;
	} else if (atLeastLetter(weightInput, 2)) {
		alert('The Form is XXX.XKG');
		weightInput.focus();
		weightInput.value="";
		return false;
	} else if (isNotNumber(weightInput)) {
		alert('Input Only Number');
		weightInput.focus();
		weightInput.value="";
		return false;
	} else if (Number(weightInput.value) >= 200) {
		alert('No way ~');
		weightInput.focus();
		weightInput.value="";
		return false;
	}
	
	if (isEmpty(imgInput)) {
		alert('No Image');
		return false;
	}
	if (!(isNotType(imgInput, 'png'))) {
		return true;
	} else if (!(isNotType(imgInput, 'jpg'))) {
		return true;
	} else if (!(isNotType(imgInput, 'gif'))) {
		return true;
	} else {
		alert('The Form ins`t (png or jpg or gif)');
		return false;
	}
}



























