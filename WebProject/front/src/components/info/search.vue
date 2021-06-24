<template>

<div>
  <main>
    <section id="search_whole">
      <div id="search_banner">
        <h2>검색</h2>
      </div>
      <div id="breadcrumb_one">
        <a href="index.html">home</a>
        <a href="login.html">검색</a>
      </div>
      <section id="list_group">
        <div id="s_box">
          <input class="s_box" type="text" placeholder="검색어를 입력해주세요." v-model="keyword" />
          <button class="s_btn" v-on:click='search'>검색</button>
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
