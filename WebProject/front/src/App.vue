<template>
  <div id="app">
<!-- header -->
<!--  <router-link to ='/info-list'>api 테스트 1</router-link><br />-->

  <header id="mainHeader">
    <h1><router-link to ='/'>DATOO</router-link></h1>
    <nav id="nav">
      <h2 class="hidden">DATOO 이용메뉴</h2>
      <ul>
        <!-- 여행지 링크 없애고 카테고리로 링크 넣을 것-->
        <li><router-link :to ="{name: 'SiteList'}">여행지</router-link>
        </li>
        <li><router-link :to ="{name: 'AreaList'}">지역</router-link>
        </li>
        <li><router-link to ='/'>커뮤니티</router-link></li>
        <li><router-link to ='/'>공지사항</router-link></li>
      </ul>
    </nav>
    <div id="sub_gnb">
      <h2 class="hidden">DATOO 서브메뉴</h2>

      <!-- login시에만 보이는 -->
      <ul v-if="isCookie" v-on:click.prevent="deleteCookie">
        <!-- HTML로 이미지 넣을 경우 public(index.html) 기준으로 경로 설정해야 함 -->
        <li><a href="#"><img src="images/search.png" alt="search"></a></li>
        <!-- if 관리자 토큰이면 회원관리 페이지로, 아니면 일반 사용자 마이페이지로 이동할 것-->
          <li><a href="" v-on:click="mypage"><img src="images/mypage.png" alt="mypage"></a></li>
          <li><a href="/">로그아웃</a></li>
      </ul>

      <!-- 비로그인만 보이는 -->
      <ul v-if="!isCookie">
        <li><a href="#"><img src="images/search.png" alt="search"></a></li>
        <li><router-link to ='/login'>로그인</router-link></li>
        <li><router-link to ='/register'>회원가입</router-link></li>
      </ul>

    </div>
  </header>


<!-- 페이지 표시 area -->
    <router-view>

    </router-view>



<!-- footer -->
<footer>
  <div id="footer">
    <address>
      다투│서울특별시 어딘가<br>대표번호 : 000-000-0000 <br>예약문의 : 000-000-0000
    </address>
    <ul>
      <li><a href="sights.html">여행지</a>
        <ul class="f_sub">
          <li><a href="sights.html">명소</a></li>
          <li><a href="#">카테고리2</a></li>
          <li><a href="#">카테고리3</a></li>
          <li><a href="#">카테고리4</a></li>
        </ul>
      </li>
      <li><a href="#">지역</a>
        <ul class="f_sub">
          <li><a href="#">카테고리1</a></li>
          <li><a href="#">카테고리2</a></li>
          <li><a href="#">카테고리3</a></li>
          <li><a href="#">카테고리4</a></li>
        </ul>
      </li>
      <li><a href="#">커뮤니티</a></li>
      <li><a href="#">공지사항</a></li>
    </ul>
    <small>Copyright ⓒ 2021 DATOO. All rights reserved.</small>
  </div>
</footer>



  </div>
</template>

<script>


export default {
  name: 'App',
  components: {
  },
  data(){
    return{
      isCookie: null
    };
  },
  created:function(){
    const self = this;
//    alert(self.$cookies.get('token'));
    self.isCookie = self.$cookies.isKey('token');
  },
  methods:{
    deleteCookie(){
      const self = this;
      self.$cookies.remove('token');
      self.isCookie = self.$cookies.isKey('token');
      alert( "logout");
    }, // deleteCookie()
    mypage(){
      // 이렇게 가면 페이지 이동하면서 쿠키 delete됨
    //  location.href="admin.html";
    }

  }
}
</script>

<style lang="css">


</style>
