function fn_onload() {
	fn_modifyMode('add');
}

function fn_search() {
	document.frm.action = "/xr020000s01controller.do";
	document.frm.submit();
}

function fn_modifyMode(mode) {
	var uploadClass = document.getElementsByClassName('upload');
	var downloadClass = document.getElementsByClassName('download');

	if ('modify' == mode) {

		document.getElementById('btnAdd').style.display = "none";
		document.getElementById('btnErase').style.display = "none";
		document.getElementById('btnModify').style.display = "";
		document.getElementById('btnDelete').style.display = "";

		for (var i = 0; i < downloadClass.length; i++) {
			var downloadItem = downloadClass.item(i);
			downloadItem.style.display = "";
		}

//		for (var i = 0; i < uploadClass.length; i++) {
//			var uploadItem = uploadClass.item(i);
//			uploadItem.style.display = "none";
//		}

	} else {
		document.getElementById('btnAdd').style.display = "";
		document.getElementById('btnErase').style.display = "";
		document.getElementById('btnModify').style.display = "none";
		document.getElementById('btnDelete').style.display = "none";

		for (var i = 0; i < uploadClass.length; i++) {
			var uploadItem = uploadClass.item(i);
			uploadItem.style.display = "";
		}

		for (var i = 0; i < downloadClass.length; i++) {
			var downloadItem = downloadClass.item(i);
			downloadItem.style.display = "none";
		}

	}
}

function fn_selectRow(code, name,duration,ctssrc,pstsrc,drmsrc) {
	$("#PK_CONTENTS_SER").val(code);
	$("#CONTENTS_NM").val(name);
	$("#PLY_DURATION").val(duration);
	$("#CTS_SRC_FILE_NM").val(ctssrc);
	$("#PST_SRC_FILE_NM").val(pstsrc);
	$("#DRM_SRC_FILE_NM").val(drmsrc);


    $.ajax({
      type: "POST",
      url: '/xr020000s02controller.do',
      data: { "PK_CONTENTS_SER": code },
      success : function(data) {
    	  
          console.log("success", data);

      },

      error : function(data) {

          console.log("fail");

      }

      
  });
    
    
	fn_modifyMode('modify');
}

function fn_fileSelect(trgtObj, file) {
	if (file.files && file.files[0]) {
		var fileName = file.files[0].name;
		trgtObj.value = fileName;
	}
}
function fn_download() {

	document.frm.action = "/xr020000s02controller.do";
	document.frm.submit();

}
function fn_add() {
	document.frm.action = "/xr020000i00controller.do";
	document.frm.submit();
}
 
function fn_erase() {

}

function fn_modify() {
	document.frm.action = "/xr020000u00controller.do";
	document.frm.submit();
}

function fn_delete() {
	document.frm.action = "/xr020000d00controller.do";
	document.frm.submit();
}
