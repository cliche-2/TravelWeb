<template>
<div>
  <main>

    <section id="place_whole">
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
      <section id="list_group">
        <h3 class="hidden">여행지 리스트</h3>
        <div id="tap">
          <ul>
            <li><a href="#">산</a></li>
            <li><a href="#">강</a></li>
            <li><a href="#">공원</a></li>
            <li><a href="#">랜드마크</a></li>
          </ul>
        </div>


        <ul id="place_list">
      <!-- v -for 문 위치 -->
          <li class="list">
            <router-link :to ="{name: 'InfoDetail', params:{'contentid':'126481', 'typeid':'12'}}">
            <a href="#">
              <div><img src="images/cat.jpg" alt="" style="width: 368px"></div>
              <div>명소이름</div>
              <div>명소설명명소설명명소설명명소설명명소설명명소설명</div>
            </a>
            </router-link>
          </li>

        </ul>

      </section>

    </section>


  </main>

</div>
</template>


<script>
export default {
  name: 'InfoList',
  props: {
    category: {
      type: String,
      default: 'all'
    }
  },
  data() {
    return {
      info: null,
      img_path: "http://tong.visitkorea.or.kr/cms/resource/85/2031885_image2_1.jpg",
      now_category: this.$route.params.category
    };
  },
  created: function() {
    const self = this;
    var cat = self.now_category;
    this.$axios.get('/travel/'+cat)
      .then(function(res) {
        if (res.data.result) {
          var temp  = JSON.parse(res.data.jsonResult);
          alert(temp.response.header.resultMsg); // okay
          alert(temp.response.body.numOfRows); // okay
          alert(temp.response.body.items.item); // okay

          // !json 객체 data()로 넘기기
          this.info = temp.response.body.items.item; // no
          alert("done");

        } // if
      }); // GET
  }
}
</script>


<style>

</style>
