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
        <li><router-link :to ="{name: 'InfoList', params:{'category':'mountains'}}">여행지</router-link>
          <ul class="sub">
            <li><router-link to ='/'>카테고리</router-link></li>
            <li><router-link to ='/'>카테고리</router-link></li>
          </ul>
        </li>
        <li><router-link to =''>지역</router-link>
          <ul class="sub">
            <li><router-link to ='/'>카테고리</router-link></li>
            <li><router-link to ='/'>카테고리</router-link></li>
          </ul>
        </li>
        <li><router-link to ='/'>커뮤니티</router-link></li>
        <li><router-link to ='/'>공지사항</router-link></li>
      </ul>
    </nav>
    <div id="sub_gnb">
      <h2 class="hidden">DATOO 서브메뉴</h2>
      <ul>
        <li><a href="#"><img src="images/search.png" alt="search"></a></li>

        <!-- LOG ON 상태에서만 보여주기 -->
        <li><a href="#"><img src="images/mypage.png" alt="mypage"></a></li>

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
      // 왜 인식 못하지?
        img_mypage: '@/assets/mypage.png' ,
        img_search: '@/assets/search.png'
    };
  },
  create:function(){

  },
  methods:{

  }
}
</script>

<style lang="css">


</style>
