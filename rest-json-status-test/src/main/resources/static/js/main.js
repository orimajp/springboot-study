$(function () {
	$('#okButton').on('click', function () {
		var csrfToken = $('meta[name="_csrf"]').attr('content');
		var csrfHeader = $('meta[name="_csrf_header"]').attr('content');
		$.ajax({
			url: '/ok',
			type: 'post',
			cache: false,
			beforeSend: function (xhr) {
				xhr.setRequestHeader(csrfHeader, csrfToken);
			}
		}).done(function (data,textStatus,jqXHR) {
			console.log('textStatus=' + textStatus);
			console.log('jsXHR.status=' + jqXHR.status);
			var json = JSON.stringify(data);
			console.log('json=' + json);
			alert('Ok json=' + json);
		}).fail(function (jqXHR, textStatus, errorThrown) {
			var json = JSON.stringify(jqXHR);
			console.log('json=' + json);
			console.log('message=' + jqXHR.responseJSON.message);
			console.log('status=' + jqXHR.status);
			console.log('textStatus=' + textStatus);
			console.log('errorThrown=' + errorThrown);
			alert("Error status=" + jqXHR.status);
		}).always(function () {
			console.log('通信完了');
		});
	});

	$('#getRequiredErrorButton').on('click', function () {
		$.ajax({
			url: '/valid',
			type: 'get',
			cache: false
		}).done(function (data,textStatus,jqXHR) {
			console.log('textStatus=' + textStatus);
			console.log('jsXHR.status=' + jqXHR.status);
			var json = JSON.stringify(data);
			console.log('json=' + json);
			alert('Ok json=' + json);
		}).fail(function (jqXHR, textStatus, errorThrown) {
			var json = JSON.stringify(jqXHR);
			console.log('json=' + json);
			console.log('message=' + jqXHR.responseJSON.message);
			console.log('status=' + jqXHR.status);
			console.log('textStatus=' + textStatus);
			console.log('errorThrown=' + errorThrown);
			alert("Error status=" + jqXHR.status);
		});
	});

	$('#getValidateErrorButton').on('click', function () {
		$.ajax({
			url: '/valid?value=aaaa',
			type: 'get',
			cache: false
		}).done(function (data,textStatus,jqXHR) {
			console.log('textStatus=' + textStatus);
			console.log('jsXHR.status=' + jqXHR.status);
			var json = JSON.stringify(data);
			console.log('json=' + json);
			alert('Ok json=' + json);
		}).fail(function (jqXHR, textStatus, errorThrown) {
			var json = JSON.stringify(jqXHR);
			console.log('json=' + json);
			console.log('message=' + jqXHR.responseJSON.message);
			console.log('status=' + jqXHR.status);
			console.log('textStatus=' + textStatus);
			console.log('errorThrown=' + errorThrown);
			alert("Error status=" + jqXHR.status);
		});
	});

	$('#serverErrorRestButton').on('click', function () {
		$.ajax({
			url: '/servererrorrest',
			type: 'get',
			cache: false
		}).done(function (data,textStatus,jqXHR) {
			console.log('textStatus=' + textStatus);
			console.log('jsXHR.status=' + jqXHR.status);
			var json = JSON.stringify(data);
			console.log('json=' + json);
			alert('Ok json=' + json);
		}).fail(function (jqXHR, textStatus, errorThrown) {
			var json = JSON.stringify(jqXHR);
			console.log('json=' + json);
			console.log('message=' + jqXHR.responseJSON.message);
			console.log('status=' + jqXHR.status);
			console.log('textStatus=' + textStatus);
			console.log('errorThrown=' + errorThrown);
			alert("Error status=" + jqXHR.status);
		});
	});

	$('#adminrest').on('click', function () {
		$.ajax({
			url: '/adminrest',
			type: 'get',
			cache: false
		}).done(function (data,textStatus,jqXHR) {
			console.log('textStatus=' + textStatus);
			console.log('jsXHR.status=' + jqXHR.status);
			var json = JSON.stringify(data);
			console.log('json=' + json);
			alert('Ok json=' + json);
		}).fail(function (jqXHR, textStatus, errorThrown) {
			var json = JSON.stringify(jqXHR);
			console.log('json=' + json);
			console.log('message=' + jqXHR.responseJSON.message);
			console.log('status=' + jqXHR.status);
			console.log('textStatus=' + textStatus);
			console.log('errorThrown=' + errorThrown);
			alert("Error status=" + jqXHR.status);
		});
	});

	$('#notfound').on('click', function () {
		$.ajax({
			url: '/notfound',
			type: 'get',
			cache: false
		}).done(function (data,textStatus,jqXHR) {
			console.log('textStatus=' + textStatus);
			console.log('jsXHR.status=' + jqXHR.status);
			var json = JSON.stringify(data);
			console.log('json=' + json);
			alert('Ok json=' + json);
		}).fail(function (jqXHR, textStatus, errorThrown) {
			var json = JSON.stringify(jqXHR);
			console.log('json=' + json);
			console.log('message=' + jqXHR.responseJSON.message);
			console.log('status=' + jqXHR.status);
			console.log('textStatus=' + textStatus);
			console.log('errorThrown=' + errorThrown);
			alert("Error status=" + jqXHR.status);
		});
	});

});
