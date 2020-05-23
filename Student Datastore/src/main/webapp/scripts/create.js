document.getElementById('submitForm').addEventListener('submit', submitForm);
document.getElementById('phone').addEventListener('change', validatePhone)

function submitForm(event) {
	event.preventDefault();
	let formData = {
		name : document.getElementById('name').value,
		dob : document.getElementById('dob').value,
		rollNo : document.getElementById('rollNo').value,
		address : document.getElementById('address').value,
		phone : document.getElementById('phone').value,
		department : document.getElementById('department').value
	};

	let jsonString = JSON.stringify(formData);

	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'create/studentdatabase', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(jsonString);
	xhr.onload = function() {
		if (this.status == 200) {
			let response = JSON.parse(this.responseText);
			console.log(response);
			if (response.Action != "Success") {
				document.getElementById('errorRollNo').innerHTML = '<strong><i style="color: red;">'
						+ ' ! This RollNo. is already present in the database.</i></strong>';
				alert('Roll No.' + formData.rollNo + ' is already present.');
			} else {
				window.location.href = response.url;
			}
		}
	}
}

function validatePhone() {
	var phone = document.getElementById('phone').value;
	if (phone.length != 10) {
		document.getElementById('errorPhone').innerHTML = '<strong><i style="color: red;">'
				+ ' ! Enter a 10 digit phone number.</i></strong>';
	} else {
		var regx = /^[7-9]/;
		if (regx.test(phone)) {
			document.getElementById('errorPhone').innerHTML = "";

		} else {
			document.getElementById('errorPhone').innerHTML = '<strong><i style="color: red;">'
					+ ' ! Enter a valid phone number.</i></strong>';
		}
	}
}