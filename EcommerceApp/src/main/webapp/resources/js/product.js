/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function deleteProduct(endpoint, id) {

    let s = document.getElementById(`spinner${id}`)
    s.style.display = "block";

    if (confirm("Bạn có muốn xoá sản phẩm này không!") === true) {
        fetch(endpoint, {
            method: 'delete'
        }).then(res => {
            s.style.display = "none";
            if (res.status === 204) {
                document.getElementById(`product${id}`).style.display = "none";
            } else
                alert("Hệ thống lỗi!!!");
        });
    }
}