$("#query-table tr").click(function(){ 	

			var str = "";
			var tdArr = new Array();	// 배열 선언

			var tr = $(this);
			var td = tr.children();

			td.each(function(i){
				tdArr.push(td.eq(i).text());
			});

			var no = td.eq(0).text();
			var name = td.eq(1).text();
		
			
			str +=	" * 클릭된 Row의 td값 = No. : <font color='red'>" + no + "</font>" +
					", 아이디 : <font color='red'>" + name + "</font>" ;		
			
			$("#select-code").val(no);		
			$("#select-name").val(name);

		   	

		});


$("#query-table-erase").click(function(){ 	

			$("#select-code").val("");		
			$("#select-name").val("");
		});