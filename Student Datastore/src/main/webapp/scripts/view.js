let xhr = new XMLHttpRequest()
xhr.open('GET', 'view/studentdatabase', true)
xhr.send();
xhr.onload = function() {
	if (this.status == 200) {
		let response = JSON.parse(this.responseText);
		console.log(response.StudentDatabase);
		if (response.StudentDatabase != null) {
			let tableBody = document.getElementById('tableBody_SD');
			let student = response.StudentDatabase;
			let string = '';
			for ( let i in student) {
				string += '<tr>' + '<td>' + student[i].name + '</td>' + '<td>'
						+ formatDate(student[i].dob) + '</td>' + '<td>'
						+ student[i].rollno + '</td>' + '<td>'
						+ student[i].address + '</td>' + '<td>'
						+ student[i].phone + '</td>' + '<td>'
						+ student[i].department + '</td>' + '</tr>';
			}
			tableBody.innerHTML = string;
		}
	}
}

function formatDate(format) {
	let date = new Date(format);
	return (date.getDate() + '/' + (date.getMonth() + 1) + '/' + date
			.getFullYear());
}