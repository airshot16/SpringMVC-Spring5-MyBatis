(function () {
    $(function () {
        $("#password_text").bind("click", function () {
            $(this).css("display", 'none');
            $('#password').css("display", 'block').focus().select();
        });
        $("#password").bind("blur", function () {
            if (this.value === '') {
                $('#password_text').css("display", 'block');
                $(this).css("display", 'none');
            }
        });
        $('#userName').bind("focus", function () {
            this.value = ''
        }).bind("blur", function () {
            if (this.value === '') {
                this.value = '用户名'
            }
        });

    })
})();