function left(no, start) {
	if (no == start) {
		location.href = "BoardPageController?p=" + no;
	} else {
		location.href = "BoardPageController?p=" + (no - 1);
	}
}

function right(no, end) {
	if (no == end) {
		location.href = "BoardPageController?p=" + no;
	} else {
		location.href = "BoardPageController?p=" + (no + 1);
	}
	
}