<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" href="/img/KakaoTalk_logo.svg" />
    <link rel="apple-touch-icon" href="/img/KakaoTalk_logo.svg" />
    <link rel="stylesheet" href="/css/css.css" />
    <link rel="stylesheet" href="/css/chatRoom.css" />
    <title>KakaoTalk</title>

    <script src="/js/chatdummy.js"></script>
  </head>
  <body>
    <div class="container">
      <section class="chatroom">
        <div class="top">
          <div class="crin_topbox">
            <ul id="il" class="ilinfo"></ul>
          </div>
          <div class="top-icon">
            <img src="/img/exit_icon.svg" alt="exit" id="exit" />
          </div>
        </div>

        <div class="line"></div>

        <div class="chatBox">
          <div class="box">
            <ul id="chat" class="chatStyle"></ul>
          </div>
        </div>

        <div class="bottom">
          <div>
            <form action="/html/chat.html">
              <textarea
                aria-label="chatbox"
                id="chatbox"
                class="chatbox"
                name="chatbox"
                cols="42"
                rows="4"
              ></textarea>
              <input type="submit" class="chatsubmit" value="전송" />
            </form>
          </div>
        </div>
      </section>
    </div>

    <script src="/js/chatRoom.js"></script>
  </body>
</html>
