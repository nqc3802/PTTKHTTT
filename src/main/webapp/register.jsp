<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon"
        href="https://static.vecteezy.com/system/resources/thumbnails/000/632/016/small/illust58-2414.jpg"
        type="image/x-icon">
    <link rel="stylesheet" href="register.css">
    <title>Đăng ký thành viên</title>
</head>

<body>
    <div class="register-container">
        <h2>Đăng ký thành viên</h2>
        <form action="register" method="post">
        	<p class="text-danger">${mess}</p>
            <div class="form-group">
                <label for="phone">Số điện thoại<span class="required">*</span></label>
                <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại" required>
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu<span class="required">*</span></label>
                <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required>
            </div>
            <div class="form-group">
                <label for="password">Xác nhận mật khẩu<span class="required">*</span></label>
                <input type="password" id="re_password" name="re_password" placeholder="Xác nhận mật khẩu" required>
            </div>
            <div class="form-group">
                <label for="first-name">Họ và đệm<span class="required">*</span></label>
                <input type="text" id="first-name" name="first-name" placeholder="Nhập họ" required>
            </div>
<!--             <div class="form-group">
                <label for="middle-name">Tên đệm</label>
                <input type="text" id="middle-name" name="middle-name" placeholder="Nhập tên đệm">
            </div> -->
            <div class="form-group">
                <label for="last-name">Tên<span class="required">*</span></label>
                <input type="text" id="last-name" name="last-name" placeholder="Nhập tên" required>
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ<span class="required">*</span></label>
                <input type="text" id="address" name="address" placeholder="Nhập địa chỉ" required>
            </div>
            <button type="submit" class="btn">Đăng ký</button>
        </form>
        <div class="v3"></div>
        <a href="login.jsp" class="btn-login">Đã có tài khoản? Đăng nhập ngay</a>
    </div>
</body>

</html>