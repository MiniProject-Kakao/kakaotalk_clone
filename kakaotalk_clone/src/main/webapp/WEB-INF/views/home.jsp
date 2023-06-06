<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" href="/img/KakaoTalk_logo.svg" />
    <link rel="apple-touch-icon" href="/img/KakaoTalk_logo.svg" />
    <script src="/js/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="/css/css.css" />
    <link rel="stylesheet" href="/css/home.css" />
    <script src="/js/updateFollow.js"></script>
    <script src="/js/moveChat.js"></script>
    <title>KakaoTalk</title>
    <% 
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Pragma","no-cache"); 
	response.setDateHeader("Expires",0); 
	if (request.getProtocol().equals("HTTP/1.1"))
	        response.setHeader("Cache-Control", "no-cache");
	%> 
    <script>
      let my_id = "<%=session.getAttribute("my_user_id")%>";
	  
      if(my_id === "null"){
      	alert("로그인해주세요.");
      	location.href = "/signin";
      }
      
	  let friend_arr = new Array();
	  <c:forEach items="${friend_list}" var="list">
		friend_arr.push({
			id : "${list.friend_user_id.user_id}",
			name : "${list.friend_user_id.name}",
			phone : "${list.friend_user_id.phone}",
			profile_image : "${list.friend_user_id.profile_image}",
			profile_back_image : "${list.friend_user_id.profile_back_image}",
			status_message : "${list.friend_user_id.status_message}",
			follow : "${list.follow}"
		});
	  </c:forEach>
    </script>
  </head>
  <body>
    <div class="container">
      <header id="menu"></header>

      <section class="friend_list">
        <div class="top">
          <p>친구</p>
          <div class="top-icon">
            <img src="/img/search_icon.svg" alt="search" id="search_icon" />
            <img src="/img/addUser_icon.svg" alt="addUser" id="addUser_icon" />
          </div>
        </div>

        <div id="search" style="display: none">
          <div class="reading_glasses">
            <span class="circle"></span>
            <span class="line"></span>
          </div>
          <input type="text" id="search_input" placeholder="이름으로 검색" />
        </div>

        <ul id="search_list" style="display: none" class="list_style"></ul>

        <div id="list_box" style="display: block">
          <div id="user">
            <div>
              <img
                src="${my_info.profile_image}"
                onerror="this.onerror=null; this.src='../img/profile.svg';"
              />
            </div>
            <div>
              <p>${my_info.name}</p>
              <p>${my_info.status_message}</p>
            </div>
          </div>

          <div class="box">
            <div class="box_top">
              <p>즐겨찾기 <span id="list_length"></span></p>
              <div
                id="arrowLike"
                class="arrow"
                onclick="toggle(this.id);"
                style="transform: rotate(0deg)"
              >
                <span></span>
                <span></span>
              </div>
            </div>
            <ul id="like" class="list_style">
              <c:forEach items="${friend_list }" var="list">
                <c:set var="follow" value="${list.follow}" />
                <c:if test="${follow}">
                  <li>
                    <div class="profile_img">
                      <img
                        src="${list.friend_user_id.profile_image}"
                        onerror="this.onerror=null; this.src='../img/profile.svg';"
                      />
                    </div>
                    <div class="detail">
                      <p>${list.friend_user_id.name}</p>
                      <p>${list.friend_user_id.status_message}</p>
                    </div>
                    <ul id="bookmark">
                      <li id="${list.id}" class="updateFollow" value="${list.follow ? '1' : '0'}">⭐</li>
                      <li id="${list.friend_user_id.user_id}" class="moveChat">💬</li>
                    </ul>
                  </li>
                </c:if>
              </c:forEach>
            </ul>
          </div>

          <div class="box">
            <div class="box_top">
              <p>친구 <span id="listLength">${fn:length(friend_list) }</span></p>
              <div id="arrowList" class="arrow" onclick="toggle(this.id);" style="transform: rotate(0deg)">
                <span></span>
                <span></span>
              </div>
            </div>
            <ul id="list" class="list_style">
              <c:forEach items="${friend_list }" var="list">
                <li>
                  <div class="profile_img">
                    <img
                      src="${list.friend_user_id.profile_image}"
                      onerror="this.onerror=null; this.src='../img/profile.svg';"
                    />
                  </div>
                  <div class="detail">
                    <p>${list.friend_user_id.name}</p>
                    <p>${list.friend_user_id.status_message}</p>
                  </div>
                  <ul id="bookmark">
                    <li id="${list.id}" class="updateFollow" value="${list.follow ? '1' : '0'}">⭐</li>
                    <li id="${list.friend_user_id.user_id}" class="moveChat">💬</li>
                  </ul>
                </li>
              </c:forEach>
            </ul>
          </div>
        </div>

        <form action="addFriend" method="post" id="addUser_form" style="display: none">
          <div>
            <p class="title">친구추가</p>
            <p class="text1">연락처</p>
            <input type="text" id="inputName" name="name" placeholder="친구 이름"/>
            <input type="text" id="inputPhone" name="phone" placeholder="연락처"/>
            <p class="text2">친구의 이름과 전화번호를 입력해주세요.</p>
          </div>
          <button id="addButton">친구추가</button>
        </form>
      </section>
    </div>

    <script src="/js/home.js"></script>
    <script src="/js/menu.js"></script>
    <script src="/js/addUser.js"></script>
    <script src="/js/searchUser.js"></script>
  </body>
</html>
