<template>
<div>
  <main>
    <section id="place_whole">
      <div id="place_banner">
        <div class="place">
          <p>Everything about traveling to Seoul</p>
          <h2>지역</h2>
        </div>
      </div>
      <div id="breadcrumb">
        <a href="">home</a>
        <a href="">여행지</a>
        <a href="">지역</a>
      </div>
      <section id="list_group">
        <h3 class="hidden">지역 리스트</h3>
        <div id="tap">
          <ul>
            <li v-on:click='gangnam'>강남</li>
            <li v-on:click='mapo'>마포</li>
            <li v-on:click='dongdaemun'>동대문</li>
            <li v-on:click='yongsan'>용산</li>
            <li v-on:click='jongno'>종로</li>
          </ul>
        </div>

        <ul id="place_list">
          <li class="list" v-for="site in sitelist" v-bind:key="site.contentid">
            <router-link :to="{name: 'InfoDetail', params:{'contentid':site.contentid}}">
              <a href="#">
                <div><img :src="site.firstimage2" style="width: 368px; height:245px;"></div>
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
  name: 'AreaList',
  data() {
    return {
      category: 'gangnam',
      sitelist: []
    };
  },
  created: function() {
    const self = this;
    var cat = self.category;
    this.$axios.get('/travel/area/' + cat)
      .then(function(res) {
        if (res.data.result) {
          var temp = JSON.parse(res.data.jsonResult);
          self.sitelist = temp.response.body.items.item;
        } // if
      }); // GET
  },
  methods: {
    gangnam: function(){
      this.category = 'gangnam';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/area/' + cat)
        .then(function(res) {
          if (res.data.result) {
            var temp = JSON.parse(res.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
            
          } // if
        }); // GET
    },
    mapo: function(){
      this.category = 'mapo';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/area/' + cat)
        .then(function(res) {
          if (res.data.result) {
            var temp = JSON.parse(res.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
          } // if
        }); // GET
    },
    dongdaemun: function() {
      this.category = 'dongdaemun';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/area/' + cat)
        .then(function(res) {
          if (res.data.result) {
            var temp = JSON.parse(res.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
          } // if
        }); // GET
    },
    yongsan: function(){
      this.category = 'yongsan';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/area/' + cat)
        .then(function(res) {
          if (res.data.result) {
            var temp = JSON.parse(res.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
          } // if
        }); // GET
    },
    jongno: function(){
      this.category = 'jongno';
      const self = this;
      var cat = self.category;
      this.$axios.get('/travel/area/' + cat)
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
