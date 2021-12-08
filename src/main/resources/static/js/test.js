function fn_isVisible(){
	jQuery.ajax({
		type : "POST",
		url : 'XrManagerIsVisible.do',
		data : '',
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "text",
		async : false,
		success : function(data) {
			console.log("success");
		},
		error : function(xhr, status, error) {
			console.log(xhr);
			console.log(status);
			console.log(error);
		},
		complete : function(data) {
//			console.log(data);
//			console.log(data.responseText);
			document.frm.status.value = data.responseText;
		}
	});
}

var timerId = undefined;
function fn_statusOn(){
	if(undefined != timerId){
		return;
	}
	
	timerId = setInterval(fn_isVisible, 500);
}

function fn_statusOff(){
	if(undefined == timerId){
		return;
	}
	clearTimeout(timerId);
	document.frm.status.value = '';
	timerId = undefined;
}

function fn_windowOn(){
	jQuery.ajax({
		type: "post",
		url: 'XrManagerSetVisible.do',
		data: 'screen=true',
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text",
		async: false,
		success : function(data) {
			
		},
		error : function(xhr, status, error) {
			console.log(xhr);
			console.log(status);
			console.log(error);
		},
		complete : function(data) {
			
		}
	});
}

function fn_windowOff(){
	jQuery.ajax({
		type : "POST",
		url : 'XrManagerSetVisible.do',
		data : 'screen=false',
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "text",
		async : false,
		success : function(data) {
			
		},
		error : function(xhr, status, error) {
			console.log(xhr);
			console.log(status);
			console.log(error);
		},
		complete : function(data) {
			
		}
	});
}