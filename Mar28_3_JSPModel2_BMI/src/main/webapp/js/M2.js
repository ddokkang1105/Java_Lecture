function checkValid() {
	
	let patient = {
		name : document.bmi.name,
		age : document.bmi.age,
		height : document.bmi.height,
		weight : document.bmi.weight,
		image : document.bmi.image,
	}

	if (isEmpty(patient.name) || isEmpty(patient.height) 
	|| isEmpty(patient.weight) || isEmpty(patient.image)) {
		alert('Input More !');
		return false;
	}
	
	if (isNotNumber(patient.height) || isNotNumber(patient.weight)) {
		alert('Age, Height, Weight are Number !');
		return false;
	}
	
	// �ּ� ���� �߰� - atLeastLetter(input, len)
	
	if (isNotType(patient.image, "jpg") && isNotType(patient.image, "png") && isNotType(patient.image, "gif")) {
		alert('Image is only <jpg, png, gif> types !')
		return false;
	}
	
	return true;
}





