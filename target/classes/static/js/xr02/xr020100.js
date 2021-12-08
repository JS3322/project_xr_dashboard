$("#query-table tr").click(function(){ 	

			var str = "";
			var tdArr = new Array();	// 배열 선언
			
			// 현재 클릭된 Row(<tr>)
			var tr = $(this);
			var td = tr.children();
			
			// tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
			
			// 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
			td.each(function(i){
				tdArr.push(td.eq(i).text());
			});
			
			
			// td.eq(index)를 통해 값을 가져올 수도 있다.
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