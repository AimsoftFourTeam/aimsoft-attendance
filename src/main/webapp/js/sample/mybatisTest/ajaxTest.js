function callbackReplacer(key, value) {
  var formattedString = key + ", " + value;
  return formattedString;
}

$(".searchAjax").click(
  function(event) {
    event.preventDefault();

    let $form = $(".main-form");
    var param = {};
    // コールバック関数にてiにはハッシュKey、vには値（ここでは要素か）が入ってくる。
    $($form.serializeArray()).each(function(i, v) {
      param[v.name] = v.value;
    });

    var json = JSON.stringify(param);

    $(".userName").val("ロード中");
    $(".position").val("ロード中");
    $(".department").val("ロード中");

    $.ajax({
      url: '/aimsoft-attendance/iwai/ajaxTest/search',
      type: 'POST',
      cache: false,
      data: json,
      scriptCharset: 'utf-8',
      contentType: 'application/json',
      dataType: 'json',
      timeout: 100000
    }).done(function(data) {
      Object.keys(data).forEach(function(key) {
        var target = document.getElementById(key);
        if(target !== null){
          target.value = data[key];
          // document.getElementById(key).value = data[key];
        }
      });
      console.log("ajax成功");
    }).fail(function(jqXHR, textStatus, errorThrown) {
      console.log("ajax失敗");
    }).always(function() {
      console.log("always done");
    });
    // $(".userName").value(data[])
  });
