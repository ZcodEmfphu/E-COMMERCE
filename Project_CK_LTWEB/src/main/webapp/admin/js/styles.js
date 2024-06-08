$(document).ready(function() {
    $('#myTable').DataTable();
});

function changeStatus(element, eId) {
    element.closest("tr").classList.add("delete");
    $.ajax({
        type: "POST",
        url: "<%=request.getContextPath()%>/TrashUser",
        data: {
            id: eId,
            status: 1,
        },
        success: function(data) {
            var table = $('#myTable').DataTable();
            var current = table.page.info().page;
            var rows = table
                .rows('.delete')
                .remove()
                .page(current)
                .draw('page');
            toast();
        }
    });
}

function toast() {
    const main = document.getElementById('toast_message');
    if (main) {
        const toast = document.createElement('div');
        toast.classList.add('toast-item');
        toast.style.animation = `fadeIn ease 0.3s, fadeOut linear 1s 2s forwards`;
        toast.innerHTML = `
            <div class="toast__icon"><i class="ti-check icon-success"></i></div>
            <div class="toast__body">
                <h3 class="toast__title">Success</h3>
                <p class="toast__msg">Khoá User thành công</p>
            </div>
            <div class="toast__close"><i class="ti-close"></i></div>
        `;
        main.appendChild(toast);
        setTimeout(() => {
            main.removeChild(toast);
        }, 2000);
    }
}

