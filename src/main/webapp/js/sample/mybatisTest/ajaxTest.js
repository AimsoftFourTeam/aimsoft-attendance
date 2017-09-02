$(".searchAjax").click(
    function() {
      $(".ajaxLoading").value("ロード中");

      $.ajax({
        url: '/iwai/ajaxTest/search',
        type: 'POST',
        data: $(".main-form").serialize(),
        dataType: json,
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
