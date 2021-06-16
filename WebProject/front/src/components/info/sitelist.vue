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
        <a href="">home</a>
        <a href="">여행지</a>
        <a href="">명소</a>
      </div>
      <section id="list_group">
        <h3 class="hidden">여행지 리스트</h3>
        <div id="tap">
          <ul>
            <li v-on:click='mountains'>산</li>
            <li v-on:click='rivers'>강</li>
            <li v-on:click='parks'>공원</li>
            <li v-on:click='palaces'>고궁</li>
            <li v-on:click='landmarks'>랜드마크</li>
          </ul>
        </div>

        <ul id="place_list">
          <li class="list" v-for="site in sitelist" v-bind:key="site.contentid">
            <router-link :to="{name: 'InfoDetail', params:{'contentid':site.contentid}}">
              <a href="#">
                <div><img :src="site.firstimage2" v-bind:alt="img_path" style="width: 368px"></div>
                <div>{{site.title}}</div>
                <div>{{site.addr1}}</div>
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
  name: 'SiteList',
  data() {
    return {
      img_path: "http://tong.visitkorea.or.kr/cms/resource/85/2031885_image2_1.jpg",
      category: 'mountains',
      sitelist: []
    };
  },
  created: function() {
    //        this.$router.push({
    //          path: '/site-list/sub',
    //          params: {
    //            'category': this.category
    //          }
    //        });
    const self = this;
    var cat = self.category;
    this.$axios.get('/travel/' + cat)
      .then(function(res) {
        if (res.data.result) {
          var temp = JSON.parse(res.data.jsonResult);
          self.sitelist = temp.response.body.items.item;
        } // if
      }); // GET
  },
  methods: {
    // now_category 값 다시 세팅하기
    mountains: function(){
      this.category = 'mountains';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/' + cat)
        .then(function(res) {
          if (res.data.result) {
            var temp = JSON.parse(res.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
          } // if
        }); // GET
    },
    rivers: function(){
      this.category = 'rivers';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/' + cat)
        .then(function(res) {
          if (res.data.result) {
            var temp = JSON.parse(res.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
          } // if
        }); // GET
    },
    parks: function() {
      this.category = 'parks';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/' + cat)
        .then(function(res) {
          if (res.data.result) {
            var temp = JSON.parse(res.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
          } // if
        }); // GET
    },
    palaces: function(){
      this.category = 'palaces';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/' + cat)
        .then(function(res) {
          if (res.data.result) {
            var temp = JSON.parse(res.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
          } // if
        }); // GET
    },
    landmarks: function(){
      this.category = 'landmarks';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/' + cat)
        .then(function(res) {
          if (res.data.result) {
            var temp = JSON.parse(res.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
          } // if
        }); // GET
    }
  } // methods:

}
</script>
