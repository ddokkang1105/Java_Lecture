function goAppleDetail(loc) {
	location.href = "AppleDetailController?a_loc=" + loc;
}

function back() {
	location.href = "M1Controller";
}

function deleteApple(loc) {
	location.href = "AppleDeleteController?a_loc=" + loc;
}