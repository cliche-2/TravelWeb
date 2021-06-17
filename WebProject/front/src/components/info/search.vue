<template>

<div>
  <main>
    <section id="place_whole">
      <div id="place_banner">
        <div class="place">
          <p>Everything about traveling to Seoul</p>
          <h2>검색</h2>
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
          <input type="text" v-model="keyword" />
          <button v-on:click='search'>검색</button>
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
  name: 'Search',
  data() {
    return {
      sitelist: [],
      keyword: ''
    };
  },
  methods:{

    search: function(){
      const self = this;
      var keyword = this.keyword;
      this.$axios.get('/travel/search/'+keyword)
      .then(function(resource){
        if(resource.data.result){
          var temp = JSON.parse(resource.data.jsonResult);
            self.sitelist = temp.response.body.items.item;
        }
      }); // GET
    }

  }
}

</script>
