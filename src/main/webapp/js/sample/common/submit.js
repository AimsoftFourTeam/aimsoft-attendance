/**
 * submit共通関数。
 * ボタンを含むformおよびdata属性に指定されたactionを基にsubmitします。
 *
 * @param $element イベントが発生した要素
 * @returns Request
 */
function submitFunction($element) {
  let $form = $element.parents('form');
  $form.attr("action", $element.data("action"));
  $form.submit();
}

/**
 * submit共通関数。
 * callback関数を実行し、結果がtrueの場合にsubmit共通関数を呼び出します。
 *
 * @param $element イベントが発生した要素
 * @param callBackFunction submitの前に行うコールバック関数
 * @returns Request
 */
function submitCallBackFunction($element, callBackFunction) {

  let isOk = callBackFunction();
  if (isOk) {
    submitFunction($element);
  }
}
