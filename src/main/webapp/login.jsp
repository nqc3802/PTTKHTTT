<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon"
        href="https://static.vecteezy.com/system/resources/thumbnails/000/632/016/small/illust58-2414.jpg"
        type="image/x-icon">
    <link rel="stylesheet" href="login.css">
    <title>Login</title>
</head>

<body>
    <div class="login-container">
        <h2>Đăng nhập</h2>
        <form action="login" method="post">
        	<p class="text-danger">${mess}</p>
            <div class="form-group">
                <label for="username">Số điện thoại:</label>
                <input type="text" id="username" name="username" placeholder="Số điện thoại" required>
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" placeholder="Mật khẩu" required>
            </div>
            <button type="submit" class="btn">Đăng nhập</button>
        </form>
        <div class="v1"></div>
        <form action="adminLogin.jsp" id="adminLogin-form" style="display: none;">
        </form>
        <button form="adminLogin-form" class="btn btn-staff">Đăng nhập với tư cách nhân viên</button>
        <form action="register.jsp" id="register-form" style="display: none;">
        </form>
        <button form="register-form" class="btn btn-register">Đăng ký thành viên</button>
    </div>
</body>

</html>