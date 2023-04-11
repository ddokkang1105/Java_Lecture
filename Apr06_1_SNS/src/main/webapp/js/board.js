function left(no, start) {
	if (no == start) {
		location.href = "BoardPageController?p=" + no;
	} else {
		location.href = "BoardPageController?p=" + (no - 1);
	}
};

function right(no, end) {
	if (no == end) {
		location.href = "BoardPageController?p=" + no;
	} else {
		location.href = "BoardPageController?p=" + (no + 1);
	}
	
}

function edit(b_no) {
	let b_text = prompt('Input Text You Wanna Edit !');
	if (b_text != null) {
		location.href = "BoardEditController?b_no=" + b_no + "&b_text=" + b_text;
	}
}

function deleteB(b_no) {
	let check = confirm('Delete ?');
	if (check) {
		location.href = "BoardDeleteController?b_no=" + b_no;
	}
}