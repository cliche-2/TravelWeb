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
        test: {{temp}}
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
          <li v-for="items in info" v-bind:key="items.item.contentid" class="list">
            {{items.item.title}}

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
      info: [],
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
          alert(res.data.result);
          const temp  = JSON.parse(res.data.jsonResult);
alert(temp.response.header.resultCode);
          self.info = temp;


        } // if
      }); // GET
  }
}
</script>


<style>

</style>
