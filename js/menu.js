let link = document.location.pathname;

document.getElementById('menu').innerHTML += `<ul>
  <li onClick="location.href='home.html'">
    <svg
      width="21"
      height="21"
      viewBox="0 0 21 21"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M10.3333 0.166656C11.7036 0.166656 13.0178 0.711 13.9867 1.67994C14.9557 2.64888 15.5 3.96304 15.5 5.33332C15.5 6.70361 14.9557 8.01777 13.9867 8.98671C13.0178 9.95565 11.7036 10.5 10.3333 10.5C8.96305 10.5 7.64889 9.95565 6.67995 8.98671C5.71101 8.01777 5.16667 6.70361 5.16667 5.33332C5.16667 3.96304 5.71101 2.64888 6.67995 1.67994C7.64889 0.711 8.96305 0.166656 10.3333 0.166656ZM10.3333 13.0833C16.0425 13.0833 20.6667 15.3954 20.6667 18.25V20.8333H0V18.25C0 15.3954 4.62417 13.0833 10.3333 13.0833Z"
        fill="${link === '/html/home.html' ? '#222' : '#A0A1A0'}"
      />
    </svg>
  </li>
  <li onClick="location.href='chatList.html'">
    <svg
      width="21"
      height="23"
      viewBox="0 0 21 23"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        fill-rule="evenodd"
        clip-rule="evenodd"
        d="M10.5 18.8333C16.299 18.8333 21 14.8039 21 9.83331C21 4.86275 16.299 0.833313 10.5 0.833313C4.70101 0.833313 0 4.86275 0 9.83331C0 12.7001 1.56375 15.2538 4 16.902V22.3333L9.47457 18.7909C9.81196 18.819 10.154 18.8333 10.5 18.8333Z"
        fill="${link === '/html/chatList.html' ? '#222' : '#A0A1A0'}"
      />
    </svg>
  </li>
  <li onClick="location.href='more.html'">
    <svg
      width="21"
      height="6"
      viewBox="0 0 21 6"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <circle cx="2.5" cy="2.83331" r="2.5" fill="${
        link === '/html/more.html' ? '#222' : '#A0A1A0'
      }" />
      <circle cx="10.5" cy="2.83331" r="2.5" fill="${
        link === '/html/more.html' ? '#222' : '#A0A1A0'
      }" />
      <circle cx="18.5" cy="2.83331" r="2.5" fill="${
        link === '/html/more.html' ? '#222' : '#A0A1A0'
      }" />
    </svg>
  </li>
</ul>`;
