$(() => {

    $("#questionForm").submit(function() {
        const qn = $("#question").val();

        $.post('/add', { "question": qn })
            .done(reqeustDone)
            .fail(reqFailed);

        return false;
    });

    function reqeustDone(data) {
        console.log(data);
        $('#question').val(data);
        $('#question').keypress(function() {
            $(this).val('');
            $('#question').off("keypress");
        });
    }

    function reqFailed(xhr, status, except) {
        console.log(xhr, status, except);
        $('#question').val('Error occured!');
    }
});