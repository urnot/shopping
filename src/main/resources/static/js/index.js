$(document).ready(
		function() {
			$("#btn").click(
					function() {
						var htmlobj;
						var dear;
						if ($("#name").val().trim().length == 0
								|| $("#msg").val().trim().length == 0) {
							alert("请检查输入");
							return false;
						}
						var params = $('#msgform').serialize();
						$.ajax({
							url : getPath() + "/board/save",
							type : "POST",
							data : params,
							dataType : "text",
							async : false,
							success : function(msg) {
								alert("留言成功！返回首页！");

								window.location.href =getPath() + "/index";
							},
							error : function() {
								alert( "请求错误");
							}
						});

						$("#myDiv").html("<h4>" + dear + htmlobj + "</h4>");
					});

		});
function dateFormatUtil(longTypeDate) {
	var dateTypeDate = "";
	var date = new Date();
	date.setTime(longTypeDate);
	dateTypeDate += date.getFullYear(); // 年
	dateTypeDate += "-" + getMonth(date); // 月
	dateTypeDate += "-" + getDay(date); // 日
	return dateTypeDate;
}

// 返回 01-12 的月份值
function getMonth(date) {
	var month = "";
	month = date.getMonth() + 1; // getMonth()得到的月份是0-11
	if (month < 10) {
		month = "0" + month;
	}
	return month;
}

// 返回01-30的日期
function getDay(date) {
	var day = "";
	day = date.getDate();
	if (day < 10) {
		day = "0" + day;
	}
	return day;
}
function getPath() {

	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;

}
