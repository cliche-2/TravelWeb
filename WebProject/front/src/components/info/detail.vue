<template>
<div>
  <main>
    <section id="detail">
      <div id="place_banner">
        <div class="place">
          <p>Everything about traveling to Seoul</p>
          <h2>명소</h2>
        </div>
      </div>
      <div id="breadcrumb">
        <a href="index.html">home</a>
        <a href="sights.html">여행지</a>
        <a href="sights.html">명소</a>
      </div>
      <section id="detail_group">
        <div id="intro">
          <p>구분카테고리명</p>
          <p>명소이름</p>
          <img :src="img_path" alt="" style="width: 1260px">
          <div class="btnList">
            <span class="btn1 on">첫번째</span>
            <span class="btn2">두번째</span>
            <span class="btn3">세번째</span>
          </div>
          <div id="content">
            명소 소개 내용 입력란입니다.<br>
            {{info}}
          </div>
        </div>
        <div id="info">
          <h2 class="hidden"><a href="#">정보</a></h2>
          <ul>
            <li>주소 <span>주소주소주소주소</span></li>
            <li>우편번호 <span>00000</span></li>
            <li>전화번호 <span>00-000-0000</span></li>
            <li>홈페이지 <span>https://homepageadress.net/</span></li>
            <li>여분 <span>공 백 공 백</span></li>
          </ul>
        </div>
      </section>

    </section>
  </main>

</div>
</template>


<script>
export default {
  name: 'InfoDetail',
  props: {
    contentid: {
      type: String,
      default: ''
    },
    typeid: {
      type: String,
      default:''
    }
  },
  data() {
    return {
      info: null,
      img_path: "http://tong.visitkorea.or.kr/cms/resource/85/2031885_image2_1.jpg",
      now_contentid: this.$route.params.contentid
    };
  },
  created: function() {
    alert('created');
    const self = this;
    var cid = self.now_contentid;
    this.$axios.get('/travel/detail/' + cid)
      .then(function(res) {
        if (res.data.result) {
          alert(res.data.result); // 여기까지 됨
          var temp = res.data.jsonResult.body.pageNo;
          alert(temp);

        } // if
      }); // GET
  }
}
</script>


<style>

</style>
