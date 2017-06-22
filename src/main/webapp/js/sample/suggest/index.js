/**
 * suggest.jsのサンプル
 */
$(function () {

    //今回あやり意味がないが、promiseを使用した例を残しておく。


    getSuggestDataList().done(function (data) {
        //dataが取れる  ところまで確認。
        console.log(data);
        JSON.parse(JSON.stringify(data));
        $('.tsArea').TapSuggest({
            tsInputElement: '.tsInput',
            tsArrayList: data,
            tsRegExpAll: true
        });
    }).fail(function (data) {
        // 失敗時.
    }).always(function (data) {
        // 常に（finalyと同様）

    });


    /**
     * Description　tsArrayListに設定するデータをサーバーから取得する。
     * @returns {type} Description
     */
    function getSuggestDataList() {

        let promise = $.ajax({
            type: 'POST',
            url: '/aimsoft-attendance/api/suggest/getDataFortapSuggestLib',
        });

        return promise;
    }
    // TODO 作成したいデータの例
    if (false) {
        //配列の配列を渡さないといけない
        $('.tsArea').TapSuggest({
            tsInputElement: '.tsInput',
            tsArrayList: ['伊藤', ['倉田', 'kurata', 'くらた'], '岩井', '鈴木'],
            tsRegExpAll: true
        });
    }
});
