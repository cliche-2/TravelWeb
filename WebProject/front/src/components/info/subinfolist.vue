<template>
<div>
  <ul id="place_list">
    <!-- v -for 문 위치 -->
    <li class="list" v-for="site in sitelist" v-bind:key="site.contentid">
      <router-link :to="{name: 'InfoDetail', params:{'contentid':site.contentid, 'typeid':'12'}}">
        <a href="#">
          <div><img :src="site.firstimage2" v-bind:alt="img_path" style="width: 368px"></div>
          <div>{{site.title}}</div>
          <div>{{site.addr1}}</div>
        </a>
      </router-link>
    </li>

  </ul>

</div>

</template>


<script>
export default {
  name: 'SubInfoList',
  props: {
    category: {
      type: String,
      default: ''
    }
  },
  data() {
    return {
      sitelist: [],
      img_path: "http://tong.visitkorea.or.kr/cms/resource/85/2031885_image2_1.jpg",
      now_category: this.$route.params.category
    };
  },
  mounted: function() {
    alert(this.now_category)
    const self = this;
    var cat = self.now_category;
    this.$axios.get('/travel/' + cat)
      .then(function(res) {
        if (res.data.result) {
          var temp = JSON.parse(res.data.jsonResult);
          self.sitelist = temp.response.body.items.item;
        } // if
      }); // GET
  }

}

</script>
