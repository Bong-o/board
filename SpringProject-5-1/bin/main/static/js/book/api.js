function listAll() {
	$.ajax({
		type:"GET",
		url: "/api/books",
		contentType: "application/json, charset=UTF-8",
		success: function(res) {
			console.log(res);
		},
		error: function(err) {
			
		}		
	})
}




function selectBook() {
	const selectBook = $("#selectbook").val();
	
	$.ajax({
		type: "GET",
		url: "/api/books/" + selectBook,
		contentType: "application/json, charser=UTF-8",
		success: function(res) {
			console.log(res);	
		},
		error: function(err) {
			console.log(err);
		}
		
	})	
}