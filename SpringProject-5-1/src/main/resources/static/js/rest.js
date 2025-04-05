	
	function inputApi() {
		const inputText = $("#input-text").val();
		
		$.ajax({
			type: 'GET',
			url: '/api/test/' + inputText,
			header: {"content-type" : "application/json"},
			data: {},
			success: function(res) {
				console.log(res);
			},
			err: function(err) {
				
			}
		})
	}
