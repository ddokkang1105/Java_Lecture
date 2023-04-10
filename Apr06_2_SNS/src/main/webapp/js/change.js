
function goChange() {
	location.href = "ChangeController";
}

function drop(id) {
	let really = confirm("Drop Really ?");
	if (really) {
		location.href = "DropController?m_id=" + id;
	}	
}

function changeValid() {
	let m_id = document.mem.m_id;
	let m_pw = document.mem.m_pw;
	let m_pwck = document.mem.m_pwck;
	let m_name = document.mem.m_name;
	let m_phone = document.mem.m_phone;
	let m_photo = document.mem.m_photo;
	
	if (isEmpty(m_id) || isEmpty(m_pw)
	|| isEmpty(m_pwck) || isEmpty(m_name)
	|| isEmpty(m_phone)) {
		alert('Input More Text !');
		return false;
	}
	
	if (atLeastLetter(m_id, 3) || atLeastLetter(m_pw, 3)
	|| atLeastLetter(m_pwck, 3) || atLeastLetter(m_name, 3)) {
		alert('More Text !');
		return false;
	}
	
	if (atLeastLetter(m_phone, 10)) {
		alert('Input More Text Phone !');
		return false;
	}
	
	if (notEqualPw(m_pw, m_pwck)) {
		alert('Input Same PW !');
		m_pw.value = "";
		m_pwck.value = "";
		m_pw.focus();
	}
	
	if (isNotNumber(m_phone)) {
		alert('Only Number !');
		m_phone = "";
		m_phone.focus();
	}
	
	if (isEmpty(m_photo)) {
		return true;
	}
	
	if (isNotType(m_photo, "jpg") && isNotType(m_photo, "png") && isNotType(m_photo, "gif")) {
		alert('Image is only <jpg, png, gif> types !')
		return false;
	}
	
	return true;
	
}