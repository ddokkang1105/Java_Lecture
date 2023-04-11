function goSignUp() {
	location.href = "SignUpController";
}

function loginValid() {
	let id = document.login.m_id;
	let pw = document.login.m_pw;
	
	if (isEmpty(id)) {
		alert('Input Id !');
		id.value = "";
		id.focus();
		return false;
	}
	
	if (isEmpty(pw)) {
		alert('Input PW !');
		pw.value = "";
		pw.focus();
		return false;
	}
	return true;
}

function logout() {
	let really = confirm("LogOut ?");
	if (really) {
		location.href = "LoginController";
	}	
}

function goHome() {
	location.href = "HomeController";
}