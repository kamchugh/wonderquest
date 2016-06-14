addEventListener('load', function() {
	console.log('LOADED');

	buildSignIn();
	
});

//sign the user in to the site 
var buildSignIn = (function() {
	var form = document.createElement('form');
	var usernameInput = document.createElement('input');
	var passwordInput = document.createElement('input');
	var submit = document.createElement('button');
	usernameInput.placeholder = "username";
	usernameInput.name = "username";
	passwordInput.placeholder = "password";
	passwordInput.name = "password";
	submit.textContent = "sign in";
	form.appendChild(usernameInput);
	form.appendChild(passwordInput);
	form.appendChild(submit);
	document.body.appendChild(form);
	submit.addEventListener('click', function(e) {
		e.preventDefault();
		console.log("in the sign in submit listener");
		var form = e.target.parentElement;
		console.log(form.username.value);
		console.log(form.password.value);
		var obj = {
				"username" : form.username.value,
				"password" : form.password.value
		};
		var jsonString = JSON.stringify(obj);
		
		var xhr = new XMLHttpRequest();
		xhr.open('GET', 'rest/myAccount', true);
		
		xhr.setRequestHeader('Content-type', 'application/json');

		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4 && xhr.status < 400) {
				console.log(xhr.status);
				console.log(xhr.responseText);
			}
			if (xhr.readyState === 4 && xhr.status >= 400) {
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		};

		xhr.send(jsonString);
	})
})