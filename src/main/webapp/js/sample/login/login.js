function callbackfunction() {
  let testField = document.getElementById("userPass").value;

  if (userPass === "") {
    $("#userPass").val("バリデーションエラー");

    return false;
  }
  return true;
}

$(".submitButton").on('click', function() {
  submitCallBackFunction($(this), callbackfunction);
});