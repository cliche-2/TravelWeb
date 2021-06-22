<template>
<div>
  <main>
    <section id="notice_whole">
      <div id="notice_banner"></div>
      <div id="breadcrumb_one">
        <a href="index.html">home</a>
        <a href="">공지사항</a>
      </div>
      <div id="notice">
        <h3 class="notice">글쓰기</h3>
        <section id="w_s">
          <p>제목</p>
          <textarea v-model="title" id="w_t" placeholder="제목을 입력해주세요."></textarea>
          <!-- 공백문자열 html태그로 변환해야 함 -->
          <textarea v-model="content" id="w_c" placeholder="내용을 입력해주세요."></textarea>
          
          <button v-on:click="write" type="button" name="button" class="n_save">작성완료</button>
        </section>
      </div>
    </section>
  </main>

</div>
</template>


<script>
export default{
  name:'NoWrite',
  data(){
    return{
      title:'',
      content:''
    };
  },
  methods:{
    write: function(){
      const self = this;
      // check blank
      if(self.title=='' || self.content==''){
        alert('입력필요');
        return;
      }

      // write
      const form = new URLSearchParams();
      form.append('infoTitle', self.title);
      form.append('infoContent', self.content);
      self.$axios.defaults.headers.common['Authorization'] = self.$cookies.get('token');
      self.$axios.post('/notice/write', form)
      .then(function(resource){
        if(resource.data.result){
          alert('작성 완료');
          self.$router.push('/no-list');
        }
      }); // POST
    } // write:
  }
}
</script>


<style>

</style>
