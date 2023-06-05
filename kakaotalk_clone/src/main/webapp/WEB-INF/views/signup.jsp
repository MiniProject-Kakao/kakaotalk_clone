<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>카카오톡 회원가입</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" href="/img/KakaoTalk_logo.svg" />
    <link rel="apple-touch-icon" href="/img/KakaoTalk_logo.svg" />
    <link rel="stylesheet" href="/css/signup.css" />
    <title>KakaoTalk</title>
    <script src="/js/jquery-3.6.4.min.js"></script>
  </head>
  <body>
    <div class="container">
      <a class="comment">이메일과 비밀번호를 입력해주세요</a>
      <form method="post" class="member-join" action="/signup">
        <section>
          <input
            type="text"
            id="name"
            name="name"
            alt="이름입력"
            placeholder="성함"
            required
          />
          <input
            type="text"
            id="phone"
            name="phone"
            alt="연락처 입력"
            placeholder="연락처"
            required
          />
        </section>
        <input
          type="text"
          id="num"
          alt="인증번호 입력"
          placeholder="인증번호 입력"
          required
        />
        <input
          type="button"
          id="num-st"
          value="인증번호 발송"
          onclick="return numCheck1()"
        />
        <div><span id="result"></span><span class="time"></span></div>
        <section class="mail-se">
          <input
            type="text"
            id="mail"
            name="mail"
            alt="이메일 입력"
            placeholder="이메일"
            required
          />
          <input
            type="password"
            class="secret-number"
            id="pw"
            name="password"
            alt="비밀번호 입력"
            placeholder="비밀번호"
            required
          />
          <label class="secret-mark">
            <input
              type="checkbox"
              id="mark"
              name="secret-mark"
              value="mark"
            />비밀번호표시</label
          >
          <input
            type="password"
            class="secret-number"
            id="pw2"
            alt="비밀번호 확인"
            placeholder="비밀번호 확인"
            required
          />
          <label class="secret-mark">
            <input
              type="checkbox"
              id="mark1"
              name="secret-mark1"
              value="mark1"
            />비밀번호확인표시</label
          >
          <input
            type="submit"
            class="join"
            id="join"
            value="회원 가입"
            onclick="return check()"
            disabled
          />
        </section>
      </form>
    </div>
  </body>
  <script src="/js/siguploginevent.js"></script>
  <script src="/js/signupcheck.js"></script>
  <script src="/js/checkbox.js"></script>
  <script src="/js/random.js"></script>
</html>
