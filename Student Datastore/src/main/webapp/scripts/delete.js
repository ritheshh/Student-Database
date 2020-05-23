document.getElementById('submitForm').addEventListener('submit', submitForm);

function submitForm(event) {
	event.preventDefault();
	let formData = {
		rollNo : document.getElementById('rollNo').value
	};
	let jsonString = JSON.stringify(formData);

	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'delete/deletedata/', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(jsonString);
	xhr.onload = function() {
		if (this.status == 200) {
			let response = JSON.parse(this.responseText);
			console.log(response);
			if (response.Action != "Success") {
				document.getElementById('errorRollNo').innerHTML = '<strong><i style="color: red;">'
						+ ' ! No such Roll No. is available.</i></strong>';
			} else {
				window.location.href = response.url;
			}
		}
	}
}