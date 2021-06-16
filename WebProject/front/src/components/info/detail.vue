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
          <p>{{site.title}}</p>
          <img :src="site.firstimage" alt="" style="width: 1260px">
          <div class="btnList">
            <span class="btn1 on">첫번째</span>
            <span class="btn2">두번째</span>
            <span class="btn3">세번째</span>
          </div>
          <div id="content">
            {{site.overview}}<br>
          </div>
        </div>
        <div id="info">
          <h2 class="hidden"><a href="#">정보</a></h2>
          <ul>
            <li>주소 <span>{{site.addr1}}</span></li>
            <!-- 파싱해야함
            <li>홈페이지 <span>{{site.homepage}}</span></li>
          -->
            <li>우편번호 <span>{{site.zipcode}}</span></li>
            <!-- map -->
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
    }
  },
  data() {
    return {
      site: [],
      cid: ''
    };
  },
  created: function() {
    const self = this;
    self.cid = this.$route.params.contentid;
    this.$axios.get('/travel/detail/' + self.cid)
      .then(function(res) {
        if (res.data.result) {
          var temp = JSON.parse(res.data.jsonResult);
          self.site = temp.response.body.items.item;
        } // if
      }); // GET
  }
}
</script>


<style>

</style>
