/**
 * ajaxの戻り値を確認する為のサンプル<br/>
 * ここでどんな返し方をしたら、どのようなデータで返ってくるのかを確認できるようにする。
 */
$(function () {

    //Controllerを使用した例

    //object配列サンプル
    $.ajax({
        type: 'POST',
        url: '/aimsoft-attendance/getDataFortapSuggestLib',
    }).done(function (data) {
        //文字列の連想配列
        console.log(data);

    });

    //json形式サンプル
    $.ajax({
        type: 'POST',
        url: '/aimsoft-attendance/getDataFortapSuggestLib1',
    }).done(function (data) {
        console.log(data);

    });

    //RestControllerを利用した例
    $.ajax({
        type: 'POST',
        url: '/aimsoft-attendance/getDataFortapSuggestLib2',
    }).done(function (data) {
        //文字列の連想配列
        console.log(data);
    });
});
