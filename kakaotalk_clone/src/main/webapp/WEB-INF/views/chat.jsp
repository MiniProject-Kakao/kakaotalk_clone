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
    <link rel="stylesheet" href="/css/css.css" />
    <link rel="stylesheet" href="/css/chat.css" />
    <title>KakaoTalk</title>
	<script src="/js/jquery-3.6.4.min.js"></script>
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

        <div class="chatBox" id="chatdiv">
          <div class="box">
            <ul id="chat" class="chatStyle">
            	<li class='chatStyleli'>
              		<div>
                  		<img src='../img/user-circle.svg' alt='usericon'/>
              		</div>
              		<div>
              			<p>너입니다</p>
              			<div><p>안녕하세요</p></div>
              		</div>
              	</li>
              	<li class='chatStyleMe'>
          			<div>
            			<div>
              				<p>안녕하세요?</p>
              			</div>
            		</div>
            	</li>
            	<li class='chatStyleMe'>
          			<div>
            			<div>
              				<p>안녕하세요?</p>
              			</div>
            		</div>
            	</li>
            	<li class='chatStyleli'>
              		<div>
                  		<img src='../img/user-circle.svg' alt='usericon'/>
              		</div>
              		<div>
              			<p>너입니다</p>
              			<div><p>안녕하세요</p></div>
              		</div>
              	</li>
              	<li class='chatStyleli'>
              		<div>
                  		<img src='../img/user-circle.svg' alt='usericon'/>
              		</div>
              		<div>
              			<p>너입니다</p>
              			<div><img src='https://image.utoimage.com/preview/cp872722/2022/12/202212008462_206.jpg' alt='aas' /></div>
              		</div>
              	</li>
              	<li class='chatStyleMe'>
          			<div>
            			<div>
              				<img src='https://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg' alt='aas' />
              			</div>
            		</div>
            	</li>
            </ul>
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
              <button type="button" onclick="send()" id="sendbtn" class="chatsubmit">전송</button>
            </form>
          </div>
        </div>
      </section>
    </div>

    <script src="/js/chat.js"></script>
  </body>
</html>
