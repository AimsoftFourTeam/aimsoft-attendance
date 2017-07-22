$('.submitButton').on('click', function() {
  $(this).parents('form').attr("action",$(this).data("action"));
  $(this).parents('form').submit();
});