document.getElementById('submit_RollNo').addEventListener('submit', submitRollNo);
document.getElementById('submit_StudentData').addEventListener('submit', submitStudentData);

function submitRollNo(event) {
	event.preventDefault();

	let formData = {
		rollNo : document.getElementById('rollNo').value
	};

	let jsonString = JSON.stringify(formData);

	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'edit/studentdatabase', true);
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
				document.getElementById("div_RollNo").style.display = "none";
				document.getElementById("div_StudentData").style.display = "block";
				updateStudentData(response.Student);
			}
		}
	}
}
function submitStudentData(event) {
	event.preventDefault();

	let formData = {
		name : document.getElementById('name_StudentData').value,
		dob : document.getElementById('dob_StudentData').value,
		rollNo : document.getElementById('rollNo_StudentData').value,
		address : document.getElementById('address_StudentData').value,
		phone : document.getElementById('phone_StudentData').value,
		department : document.getElementById('department_StudentData').value
	};

	let jsonString = JSON.stringify(formData);

	var xhr = new XMLHttpRequest();
	xhr.open('PUT', 'edit/studentdatabase', true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(jsonString);
	xhr.onload = function() {
		if (this.status == 200) {
			let response = JSON.parse(this.responseText);
			window.location.href = response.url;
		}
	}
}

function updateStudentData(student) {
	document.getElementById("name_StudentData").value = student.name;
	document.getElementById("rollNo_StudentData").value = student.rollno;
	document.getElementById("address_StudentData").value = student.address;
	document.getElementById("phone_StudentData").value = student.phone;
	document.getElementById("department_StudentData").value = student.department;
	document.getElementById("dob_StudentData").value = formatDate(student.dob);
	console.log(formatDate(student.dob));
}

function formatDate(format) {
	let date = new Date(format);
	let year = date.getFullYear();
	let month = (date.getMonth() + 1) >= 10 ? (date.getMonth() + 1)
			: ('0' + (date.getMonth() + 1));
	let day = (date.getDate() + 1) >= 10 ? date.getDate() : ('0' + date
			.getDate());
	return (year + '-' + month + '-' + day);
}