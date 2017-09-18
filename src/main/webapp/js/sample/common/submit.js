/**
 * submit共通関数。
 * イベント発火要素よりformとactionを取得しsubmitします。
 * あらかじめinput type="button"およびaタグを無効化します。
 *
 * @param $element イベントが発生した要素
 * @returns Request
 */
function submitFunction($element) {
  disableEvents();
  let $form = $element.parents('form');
  $form.attr("action", $element.data("action"));
  $form.submit();
}

/**
 * コールバック関数付きsubmit共通関数。
 * callback関数を実行し、結果がtrueの場合にsubmit共通関数を呼び出します。
 * あらかじめinput type="button"およびaタグを無効化します。
 * 処理終了後input type="button"およびaタグの無効化を解除します。
 *
 * @param $element イベントが発生した要素
 * @param callBackFunction submitの前に行うコールバック関数
 * @returns Request
 */
function submitCallBackFunction($element, callBackFunction) {
  disableEvents();
  let isOk = callBackFunction();
  if (isOk) {
    submitFunction($element);
  }
  enableEvents();
}

/**
 * input type="button"およびaタグを無効化します。
 */
function disableEvents() {
  $("input[type = 'button']").prop('disabled', true);
  $("a").on('click', cancelALink);
}

/**
 * input type="button"およびaタグの無効を解除します。
 */
function enableEvents() {
  $("input[type = 'button']").prop('disabled', false);
  $("a").off('click', cancelALink);
}

/**
 * aタグの無効/有効を切り替えます。
 */
function cancelALink(event) {
  event.preventDefault();
}
