function confirmDelete() {
    return confirm("Are you sure you want to delete this note?");
}

document.addEventListener('DOMContentLoaded', function() {

    // Bold, Italic, Underline
    document.querySelector('.ql-bold').addEventListener('click', function() {
        document.execCommand('bold', false, null);
    });
    document.querySelector('.ql-italic').addEventListener('click', function() {
        document.execCommand('italic', false, null);
    });
    document.querySelector('.ql-underline').addEventListener('click', function() {
        document.execCommand('underline', false, null);
    });

    // Изменение размера шрифта
    document.querySelector('.ql-font-size').addEventListener('change', function() {
        var fontSize = this.value;
        document.execCommand('fontSize', false, fontSize);
    });

    // Изменение шрифта
    document.querySelector('.ql-font-family').addEventListener('change', function() {
        var fontFamily = this.value;
        document.execCommand('fontName', false, fontFamily);
    });

    // Сохранение содержимого редактора в скрытое поле перед отправкой формы
    document.querySelector('form').addEventListener('submit', function() {
        var content = document.getElementById('noteContent').innerHTML;
        document.getElementById('hiddenContent').value = content;
    });
});
