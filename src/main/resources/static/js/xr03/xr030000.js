$(document).ready(function () {

  var fileTarget = $('.btn_upload .upload-hidden');
  fileTarget.on('change', function () {
    if (window.FileReader) {
      var filename = $(this)[0].files[0].name;

    }
    $(this).siblings('.upload-name').val(filename);
  });
});

