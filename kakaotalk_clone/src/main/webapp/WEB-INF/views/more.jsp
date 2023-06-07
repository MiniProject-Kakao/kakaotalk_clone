<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="icon" href="/img/KakaoTalk_logo.svg" />
  <link rel="apple-touch-icon" href="/img/KakaoTalk_logo.svg" />
  <link rel="stylesheet" href="/css/more.css" />
  <link rel="stylesheet" href="/css/css.css" />

  <title>KakaoTalk</title>
</head>
<body>
  <div class="container">
    <header id="menu"></header>
    <div class="see more">
      <p class="see">더보기</p>
    </div>
<div class="profile">
  <p class="profile-name">${name}</p>
  <p class="profile-id">계정</p>
  <p class="profile-email">${email}</p>
  <p class="profile-contacted">연락처</p>
  <p class="profile-phone">${phone}</p>
</div>

    <hr class="contour" />

    <div class="Personal settings">
      <p class="basic">기본 프로필관리</p>
      <button class="buttonredaction" onclick="openProfileEditor()">
        <span class="redaction"> 편집 </span>
      </button>
    </div>

    <div class="moremodal"></div>
    <div class="modal_profilemodal">
      <a class="arrow" onclick="closeProfileEditor()">&larr;</a>

      <p class="basic2">기본 프로필관리</p>

      <form id="profile-form" method="POST" enctype="multipart/form-data">
          <img
              id="profile-image"
              src="https://t1.kakaocdn.net/friends/new_store/prod/character/character_20230502134308_2e69548418dd497a81dc68175eb02aac.png"
              class="profilecharracter"
          />
          <input type="file" id="image" name="image" style="display: none;" onchange="previewProfileImage()" />
      </form>

      <div>
        <label for="username" class="sr-only"></label>
<input
  type="text"
  id="username"
  name="updatedUsername"
  class="profilename2"
  placeholder="사용자 이름을 입력하세요"
  value="${B_MoreDTO.getUpdatedUsername()}"
/>
        <hr class="profilehr" />
        <label for="status-message" class="sr-only"></label>
        <input
          type="text"
          id="status-message"
          name="status-message"
          class="message"
          placeholder="상태메시지를 입력하세요"
          value="${B_MoreDTO.getStatusMessage()}"
        />
        <hr class="messagehr" />
        <button class="inerscheck">확인</button>
      </div>
    </div>

    <div>
      <button class="secession" onclick="openWithdrawalModal()">탈퇴하기</button>
    </div>

    <div class="modal2">
      <div class="secessionmodal">
        <div class="withdrawal">탈퇴하시겠습니까?</div>
        <div>
          <button class="yes" onclick="withdrawal()">네</button>
        </div>
        <div><button class="no" onclick="closeWithdrawalModal()">아니요</button></div>
      </div>
    </div>
  </div>

  <script src="/js/more.js"></script>
  <script src="/js/menu.js"></script>
  <script>
    function openProfileEditor() {
      document.querySelector('.moremodal').style.display = 'block';
      document.querySelector('.modal_profilemodal').style.display = 'block';
    }

    function closeProfileEditor() {
      document.querySelector('.moremodal').style.display = 'none';
      document.querySelector('.modal_profilemodal').style.display = 'none';
    }

    function openWithdrawalModal() {
      document.querySelector('.modal2').style.display = 'block';
      document.querySelector('.secessionmodal').style.display = 'block';
    }

    function closeWithdrawalModal() {
      document.querySelector('.modal2').style.display = 'none';
      document.querySelector('.secessionmodal').style.display = 'none';
    }

    document.querySelector('.inerscheck').addEventListener('click', closeProfileEditor);
document.querySelector('.inerscheck').addEventListener('click', updateProfile);
  </script>
<script>
function updateProfile() {
	  // 프로필 수정 내용을 가져오기
	  var updatedUsername = document.getElementById('username').value;
	  var updatedStatusMessage = document.getElementById('status-message').value;

	  // 사용자 이름과 상태 메시지가 비어있지 않은지 확인
	  if (!updatedUsername.trim()) {
	    alert('사용자 이름을 입력하세요.');
	    return;
	  }

	  if (!updatedStatusMessage.trim()) {
	    alert('상태 메시지를 입력하세요.');
	    return;
	  }
	  // AJAX 요청을 생성하고 데이터 전송
	  var xhr = new XMLHttpRequest();
	  xhr.open('POST', '/more/updateProfile', true);
	  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	  xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4 && xhr.status === 200) {
	    	  var updatedUsername = document.getElementById('username').value;
	    	  var updatedStatusMessage = document.getElementById('status-message').value;
	    	  
	    	  document.querySelector('.profile-name').textContent = updatedUsername;
	    	  document.querySelector('.profile-status-message').textContent = updatedStatusMessage;
	    	}
	  };
	  
	  // 데이터를 URL 인코딩하여 전송
	  var params = 'updatedUsername=' + encodeURIComponent(updatedUsername) + '&updatedStatusMessage=' + encodeURIComponent(updatedStatusMessage);
	  xhr.send(params);
	}
</script>
<script>
function withdrawal() {
	  var phone = "${phone}";
	  
	  // 사용자가 실제로 탈퇴하길 원하는지 확인
	  if (!confirm('정말로 탈퇴하시겠습니까?')) {
	    return;
	  }
	  var xhr = new XMLHttpRequest();
	  xhr.open("POST", "/more/withdrawal?phone=" + phone, true);
	  xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4 && xhr.status === 200) {
	     
	      alert('Successfully withdrawn from the service.');
	      location.href = '/signin';  // 로그인 페이지로 리다이렉트
	    }
	  };
	  xhr.send();
	}
</script>
     <script>
	let my_id = <%=session.getAttribute("my_user_id")%>
				? "<%=session.getAttribute("my_user_id")%>"
				: null;
	
	if(my_id === null){
		alert("로그인해주세요.");
		location.href = "/signin";
	}
	</script>

  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <script>
    document.querySelector('#profile-image').addEventListener('click', function() {
        document.querySelector('#image').click();
    });
    
    function previewProfileImage() {
        var preview = document.querySelector('#profile-image');
        var file = document.querySelector('#image').files[0];
        var reader = new FileReader();

        reader.addEventListener("load", function () {
            preview.src = reader.result;
        }, false);

        if (file) {
            reader.readAsDataURL(file);
        }
    }
  </script>
</body>
</html>