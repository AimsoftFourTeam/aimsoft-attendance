$(".searchAjax").click(
  function(event) {
    event.preventDefault();

    // 下記では以下のようなデータ構造となる。
    // "userId=testUser01&userName=&position=&department="
    // let formJson = $(".main-form").serialize();
    // ""userId=testUser01&userName=&position=&department=""
    // var jsonData = JSON.stringify(formJson);

    let formJson = $(".main-form").serializeArray();
    var jsonData = JSON.stringify(formJson);

    $(".userName").val("ロード中");
    $(".position").val("ロード中");
    $(".department").val("ロード中");

    $.ajax({
      url: '/aimsoft-attendance/iwai/ajaxTest/search',
      type: 'POST',
      cache: false,
      data: jsonData,
      scriptCharset: 'utf-8',
      contentType: 'application/json',
      dataType: 'json',
      timeout: 100000
    }).done(function(data) {
      console.log("ajax成功");
    }).fail(function(jqXHR, textStatus, errorThrown) {
      console.log("ajax失敗");
    }).always(function() {
      console.log("always done");
    });
    // $(".userName").value(data[])
  });
