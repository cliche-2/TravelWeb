<template>
  <div class="hello">
    <main>
    <section id="sliderWrap">
      <h2 class="hidden">DATOO 배너</h2>
      <ul id="sliderList">
        <li class="slider1">
          <dl>
            <dt>서울 여행의 모든 것</dt>
            <dd>D A T O O</dd>
          </dl>
          <a href="#">자세히보기</a>
        </li>
        <li class="slider2">
          <dl>
            <dt>서울 여행의 모든 것</dt>
            <dd>D A T O O</dd>
          </dl>
          <a href="#">자세히보기</a>
        </li>
        <li class="slider3">
          <dl>
            <dt>서울 여행의 모든 것</dt>
            <dd>D A T O O</dd>
          </dl>
          <a href="#">자세히보기</a>
        </li>
      </ul>
      <!-- 배너 컨트롤 -->
      <div class="controls">
        <span class="prev">이전</span>
        <span class="next">다음</span>
      </div>
    </section>
    <section id="hotplace">
      <h2>hot place</h2>
      <ul>

        <li v-for="site in list" v-bind:key='site.contentid'>
          <img :src="site.firstimage" alt="경복궁">
          <p>{{site.title}}</p>
          <router-link :to="{name: 'InfoDetail', params:{'contentid':site.contentid}}">
            자세히보기 →
          </router-link>
        </li>

      </ul>

    </section>
  </main>
  </div>
</template>

<script>

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data(){
    return{
      list:[],
      pic: 3 // 사진 개수.
    };
  },

  created:function(){
    const self = this;
    self.$axios.get('/bookmarks/count/'+self.pic)
    .then(function(res){
      if(res.data.result){
        self.list = res.data.list;
      }
    }); // GET
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
