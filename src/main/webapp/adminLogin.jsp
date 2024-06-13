<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon"
        href="https://static.vecteezy.com/system/resources/thumbnails/000/632/016/small/illust58-2414.jpg"
        type="image/x-icon">
    <link rel="stylesheet" href="adminLogin.css">
    <title>Login</title>
</head>

<body>
    <div class="login-container">
        <h2>Đăng nhập</h2>
        <form action="adminLogin" method="post">
        	<p class="text-danger">${mess}</p>
            <div class="form-group">
                <label for="admin-username">Tên đăng nhập:</label>
                <input type="text" id="admin-username" name="admin-username" placeholder="Tên đăng nhập" required>
            </div>
            <div class="form-group">
                <label for="admin-password">Mật khẩu:</label>
                <input type="password" id="admin-password" name="admin-password" placeholder="Mật khẩu" required>
            </div>
            <button type="submit" class="btn">Đăng nhập</button>
        </form>
        <div class="v2"></div>
        <form action="login.jsp" id="login-form" style="display: none;">
        </form>
        <button form="login-form" class="btn btn-client">Đăng nhập với tư cách khách hàng</button>
    </div>
</body>

</html>