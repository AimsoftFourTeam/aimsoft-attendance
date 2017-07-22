function submitCallBackFunction(form,action,callBackFunction) {

  if(typeof(callBackFunction) === "function"){
    if(!callBackFunction()){
    	return false;
    }
  }
	
  form.attr("action",action);
  form.submit();
}