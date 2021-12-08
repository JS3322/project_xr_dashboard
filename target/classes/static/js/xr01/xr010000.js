function toggle_hmd(toggle){

	var table_hmd=toggle.checked;
	if(table_hmd){
		$("#hmdcontents_block").css({
			"display":"none"
		});
		$("#hmdcontents_table").css({
			"display":"block"
		});
	}else{
				$("#hmdcontents_block").css({
			"display":"block"
		});
		$("#hmdcontents_table").css({
			"display":"none"
		});
	}
}
