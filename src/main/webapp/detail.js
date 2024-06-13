/**
 * 
 */
function save(event) {
    var sl = document.getElementById('sl').value;
    var gia = document.getElementById('gia').value;
    console.log(sl);
    console.log(gia);
    if (sl <= 0 || gia <= 0) {
        alert('Số lượng và đơn giá phải lớn hơn 0. Vui lòng nhập lại!');
        event.preventDefault();
        return false;
    }
    if (!confirm('Bạn chắc chắn đã nhập đúng thông tin?')) {
        event.preventDefault();
        return false;
    }
    alert("Lưu thành công!");
    return true;
}

function sub(event) {
    var tong = document.getElementById('tong').value;
    if (tong <= 0) {
        alert('Bạn chưa nhập hóa đơn');
        event.preventDefault();
        return false;
    }
    if (!confirm('Bạn chắc chắn muốn in hóa đơn?')) {
        event.preventDefault();
        return false;
    }
    return true;
}

function con() {
    var id_ncc = document.getElementById('id_ncc').value;
    window.location.href = 'MH.jsp?id_ncc=' + id_ncc;
    return false;
}



