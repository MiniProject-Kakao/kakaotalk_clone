<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" href="/img/KakaoTalk_logo.svg" />
    <link rel="apple-touch-icon" href="/img/KakaoTalk_logo.svg" />
    <link rel="stylesheet" href="/css/css.css" />
    <link rel="stylesheet" href="/css/chatList.css" />
    <title>KakaoTalk</title>
	<script src="/js/jquery-3.6.4.min.js"></script>
    <script src="/js/croomdummy.js"></script>
    <script src="/js/chatList.js"></script>
  </head>
  <body>
    <div class="container">
      <header id="menu"></header>

      <section class="chatroomList">
        <div class="top">
          <p>채팅</p>
          <div class="top-icon">
            <img src="/img/search_icon.svg" alt="search" id="searchChatList" />
            <img src="/img/plus_icon.svg" alt="plusIcon" />
          </div>
        </div>

        <div id="search" style="display: none">
          <div class="reading_glasses">
            <span class="circle"></span>
            <span class="line"></span>
          </div>
          <input type="text" id="searchInput" placeholder="검색" />
        </div>

        <div class="listBox">
          <div class="box">
            <ul id="list" class="listStyle">
				<c:forEach items="${chatlist}" var="dto">	
            		<li class='croomList'>
        			<div><img src="${dto.icon_url}" /></div>
        			<div>
          				<p>${dto.cr_name}</p>
         				<p>${dto.last_content}</p>
        			</div>
        			<div>
            			<p>${dto.updated_at }</p>
        			</div>
      			</li>
      		</c:forEach>
            </ul>
          </div>
        </div>
      </section>
    </div>

    <script src="/js/chatListSearch.js"></script>
    <script src="/js/menu.js"></script>
  </body>
</html>
