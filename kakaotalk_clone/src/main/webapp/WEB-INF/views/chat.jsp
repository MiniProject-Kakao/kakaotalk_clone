<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

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
	<script>
		var sessionid = "<%=session.getAttribute("my_user_id") %>"
	</script>
  </head>

  <body>
    <div class="container">
      <section class="chatroom">
        <div class="top">
          <div class="crin_topbox">
            <ul id="il" class="ilinfo">
            	<li>
      				<div><img src='${chatlog[0].icon_url}' onerror="this.onerror=null; this.src='../img/profile.svg';"/></div>
      				<div>
         				<p>${chatlog[0].cr_name}</p>
      				</div>
 			 	</li>
            </ul>
          </div>
          <div class="top-icon">
            <img src="/img/exit_icon.svg" alt="exit" id="exit" />
          </div>
        </div>

        <div class="line"></div>

        <div class="chatBox" id="chatdiv">
          <div class="box">
            <ul id="chat" class="chatStyle">
            	<c:forEach items="${chatlog}" var="dto">
            		<c:choose>
            		<c:when test="${dto.user_id == my_user_id}">
            			<li class='chatStyleMe'>
          					<div>
            					<div>
            						<c:choose>
            							<c:when test="${dto.type == 'img'}">
            								<img src="<spring:url value='${dto.content}' />" alt='img' />
            							</c:when>
            							<c:otherwise>
            								<p>${dto.content}</p>
            							</c:otherwise>
            						</c:choose>
              					</div>
            				</div>
            			</li>
            		</c:when>
            		<c:otherwise>
            			<li class='chatStyleli'>
              				<div>
                  				<img src='${dto.profile_image}' onerror="this.onerror=null; this.src='../img/profile.svg';"/>
              				</div>
              				<div>
              					<p>${dto.name}</p>
              					<div>
              						<c:choose>
            							<c:when test="${dto.type == 'img'}">
            								<img src='${dto.content}' alt='img'>
            							</c:when>
            							<c:otherwise>
            								<p>${dto.content}</p>
            							</c:otherwise>
            						</c:choose>
              					</div>
              				</div>
              			</li>
            		</c:otherwise>
            		</c:choose>
            	</c:forEach>
            </ul>
          </div>
        </div>

        <div class="bottom">
            <form action="imgupload" id="imgform" method="post" enctype="multipart/form-data">
              <textarea
                aria-label="chatbox"
                id="chatbox"
                class="chatbox"
                name="chatbox"
              ></textarea>
              <div class="submitchat">
              	
              	<input type="hidden" id="chat_list_id" name="chat_list_id" value="${chatlog[0].chat_list_id}">
              	<input type="hidden" id="user_id" name="user_id">
              	<input type="hidden" id="type" name="type">
              	<input type="hidden" id="content" name="content">
              	<label class="imgfile" for="file1">📎</label>
              	<input type="file" id="file1" name="file1" accept="image/*"/>
             	<button type="button" onclick="send()" id="sendbtn" class="chatsubmit">전송</button>
              </div>
              </form>
        </div>
      </section>
    </div>

    <script src="/js/chat.js"></script>
  </body>
</html>
