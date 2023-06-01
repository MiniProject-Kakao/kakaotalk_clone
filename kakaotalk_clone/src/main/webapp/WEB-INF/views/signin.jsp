<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" href="/img/KakaoTalk_logo.svg" />
    <link rel="apple-touch-icon" href="/img/KakaoTalk_logo.svg" />
    <link rel="stylesheet" href="/css/signin.css" />
    <title>KakaoTalk</title>
    <script src="/js/jquery-3.6.4.min.js"></script>
    <script src="/js/signincheck.js"></script>
  </head>
  <body>
    <div class="container">
      <img src="/img/kakaoTalk_logo.svg" alt="카카오톡 로고" class="logo" />
      <form name="loginform" action="/html/home.html" id="login_form">
        <input
          type="text"
          class="id-pw"
          name="id"
          id="id"
          alt="id입력"
          placeholder="카카오계정 (이메일 또는 전화번호)"
          required
        />
        <input
          type="password"
          class="id-pw"
          name="pw"
          id="pw"
          alt="pw입력"
          placeholder="비밀번호"
          required
        />
        <input
          type="submit"
          class="loginbtn"
          value="로그인"
          onclick="return check()"
          disabled
        />
        <label class="auto-login">
          <input
            type="checkbox"
            name="auto-login"
            value="auto"
            alt="자동로그인"
          />자동로그인</label
        >
        <a href="signup" class="id-pass">회원가입</a>
      </form>
    </div>
  </body>
  <script src="/js/loginevent.js"></script>
</html>
