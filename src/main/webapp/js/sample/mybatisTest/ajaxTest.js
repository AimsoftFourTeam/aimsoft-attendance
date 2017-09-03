$(".searchAjax").click(
  function(event) {
    event.preventDefault();

    $(".userName").val("ロード中");
    $(".position").val("ロード中");
    $(".department").val("ロード中");

    $.ajax({
      url: '/aimsoft-attendance/iwai/ajaxTest/search',
      type: 'POST',
      cache: false,
      data: $(".main-form").serialize(),
      scriptCharset: 'utf-8',
      contentType: 'application/json',
      dataType: 'json',
      timeout: 10000
    }).done(function(data, textStatus, jqXHR) {
      console.log("ajax成功");
    }).fail(function(jqXHR, textStatus, errorThrown) {
      console.log("ajax失敗");
    }).always(function() {
      console.log("always done")
    });
    // $(".userName").value(data[])
  });
