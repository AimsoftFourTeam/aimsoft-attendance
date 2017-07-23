function callbackfunction(){
	let testField = document.getElementById("testField").value;
	
	if(testField === ""){
		$("#testField").val("バリデーションエラー");
		
		return false;
	}
	return true;
}

$(".submitButton").on('click', function(){
  submitCallBackFunction($(this).parents('form'),$(this).data("action"),callbackfunction);
});