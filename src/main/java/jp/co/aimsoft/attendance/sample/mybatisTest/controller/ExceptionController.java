// package jp.co.aimsoft.attendance.sample.mybatisTest.controller;
//
// import org.springframework.boot.autoconfigure.web.ErrorController;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
//
/// **
// * Spring Bootのエラーハンドリング機能。 <br />
// * ErrorControllerを継承し、エラー処理を記載したメソッドを呼び出すことで実現します。<br />
// * もう1つの方法は、/template/error.htmlを作成することで自動マッピングがなされる方法です。<br />
// * error.htmlを作成する方法だと、messageオブジェクトにエラーメッセージが入ってくるような動きとなります。<br />
// *
// */
// @Controller
// public class ExceptionController implements ErrorController {
//
// /**
// * ExceptionHandlerResolverにてキャッチできないエラーをハンドリングします。
// *
// * @return response
// */
// @RequestMapping(value = "/error", method = RequestMethod.POST)
// public String secondPageNext() {
//
// return "/sample/exception";
// }
//
// @Override
// public String getErrorPath() {
// return "/error";
// }
// }
