/**
 * submit共通関数。
 * ボタンを含むformおよびdata属性に指定されたactionを基にsubmitします。
 *
 * @returns Request
 */
function submitFunction() {
  let $form = $(this).parents('form');
  $form.attr("action", $(this).data("action"));
  $form.submit();
}

/**
 * submit共通関数。
 * callback関数を実行し、結果がtrueの場合にsubmit共通関数を呼び出します。
 *
 * @param callBackFunction submitの前に行うコールバック関数
 * @returns Request
 */
function submitCallBackFunction(callBackFunction) {

  let isOk = callBackFunction();
  if (isOk) {
    // submitFunction();
    let $form = $(this).parents('form');
    $form.attr("action", $(this).data("action"));
    $form.submit();
  }
}
