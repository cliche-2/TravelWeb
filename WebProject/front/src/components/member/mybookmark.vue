<template>
<div>
  <main>
    <section id="mypage_whole">
      <div id="mypage_banner"></div>
      <div id="breadcrumb_one">
        <a href="index.html">home</a>
        <a href="mypage.html">마이페이지</a>
      </div>
      <div id="mypage3">
        <h3 class="mypage">마이페이지</h3>
        <section id="m_2">
          <div class="title">
            <span>북마크</span>
          </div>

          <ul id="post_list">

            <li v-for="mark in bookmarks" v-bind:key="mark.bookNum" class="p_list">
              <router-link :to="{name: 'InfoDetail', params:{'contentid':mark.contentid}}">
              <a href="#">
                <div><img :src="mark.firstimage" style="width: 500px; height: 300px"></div>
                <div>{{mark.title}}</div>
              </a>
              </router-link>
            </li>

          </ul>
          <router-link to="/mypage" class="con">마이페이지로</router-link>
        </section>
      </div>
    </section>
  </main>

</div>
</template>


<script>
export default {

  name: 'Mybookmark',
  data() {
    return {
      bookmarks:[],
      isNull:true
    };
  },

  created:function(){
    const self = this;
    if (!self.$cookies.isKey('token')) {
      self.$router.push('/');
      return;
    }

    self.$axios.defaults.headers.common['Authorization'] = self.$cookies.get('token');
    self.$axios.get('/members/bookmarks')
      .then(function(resource) {
        if(resource.data.result){
        self.bookmarks = resource.data.bookmarks;
        self.isNull = false;
      }
      }); // GET
  }



}
</script>
