$(function() {
	$("#u1").blur(function() {
		
		// 获得文本框的值
		var name = $(this).val();
		
		// 演示load方法
//		$("#s1").load("/InterestingJavaEE/CheckUserNameServletJquery",{"name":name});
	
		// 演示get/post方法
//		$.get("/InterestingJavaEE/CheckUserNameServletJquery",{"name":name}, function(data) {
//			if (data == 1) {
//				$("#s1").html("<font color='green'>可以用</font>");
//				$("#sub1").attr("disabled",false);
//			} else if(data == 2) {
//				$("#s1").html("<font color='red'>不不不不可以用</font>");
//				$("#sub1").attr("disabled",true);
//			}
//		});
		
		
		$.ajax({
//		   type: "GET",
		   type: "POST",
		   url: "/InterestingJavaEE/CheckUserNameServletJquery",
		   data: "name="+name,
		   success: function(data){
			   if (data == 1) {
					$("#s1").html("<font color='green'>可以用</font>");
					$("#sub1").attr("disabled",false);
				} else if(data == 2) {
					$("#s1").html("<font color='red'>不不不可以用</font>");
					$("#sub1").attr("disabled",true);
				}
		   }
		});
	});
	
});


//省市联动
$(function() {
	// 为省份下拉列表绑定事件
	$("#province").change(function() {
		// 获得选中的省份的id
		var pid = $(this).val();
		
		/*  使用XML
		$.post("/InterestingJavaEE/ProvinceAndCityGetCityServlet",{"pid":pid},function(data){
			//alert(data);
			
			var $city = $("#city");
			$city.html("<option>--请选择--</option>");
			
			
			$(data).find("city").each(function() {
				var cid = $(this).children("cid").text();
				var cname = $(this).children("cname").text();
				
				$city.append("<option value='"+cid+"'>"+cname+"</option>");
			});
			
		});
		*/
		
		// 使用JSON
		$.post("/InterestingJavaEE/ProvinceAndCityGetCityServlet",{"pid":pid},function(data){
			//alert(data);
			
			// JS识别JSON:
			// var json = eval(data);
			
			var $city = $("#city");
			$city.html("<option>--请选择--</option>");
			
			$(data).each(function(i,n) {
				$city.append("<option value='"+n.cid+"'>"+n.cname+"</option>");
			});
			
		}, "json");
	});
});