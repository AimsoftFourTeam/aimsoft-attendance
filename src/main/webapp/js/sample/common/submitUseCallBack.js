/**
 * submit共通関数。
 * callback関数が指定されている場合実行し、結果がtrueの場合にpost送信を行う。
 * 
 * @param form submitを行う対象form
 * @param action submitに指定するaction
 * @param callBackFunction submitの前に行うコールバック関数
 * @returns Request
 */
function submitCallBackFunction(form,action,callBackFunction) {

  if(typeof(callBackFunction) === "function"){
  
    let isOk = callBackFunction();

    if(!isOk){
      return false;
    }
  }
  
  form.attr("action",action);
  form.submit();
}