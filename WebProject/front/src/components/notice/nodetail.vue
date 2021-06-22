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
        <h3 class="notice">공지사항</h3>
        <section id="n_s">
          <p>{{board.infoTitle}}</p>
          <p>작성일자 {{getdate(board.infoDate)}} │ 조회수 {{board.viewCount}}</p>
          <span v-if="admin">

            <button type="button" name="button" class="edit">수정</button>

            <button v-on:click="del(board.infoNum)" type="button" name="button" class="del">삭제</button>

          </span>
          <section>
            <p>
              {{board.infoContent}}
            </p>
          </section>
          <router-link to="/no-list" class="back">목록으로</router-link>
        </section>
      </div>
    </section>
  </main>

</div>
</template>


<script>
export default {
  name: 'NoDetail',
  data() {
    return {
      num: 0,
      board: null,
      admin: false
    };
  },
  created: function() {
    const self = this;

    self.num = this.$route.params.num;

    var hascookie = self.$cookies.isKey('token');
    if (hascookie) {
      if (self.$cookies.get('memnum') == 1)
        self.admin = true;
    }

    self.$axios.get('/notice/' + self.num)
      .then(function(resource) {
        if (resource.data.result) {
          self.board = resource.data.board;
        }
      }); //GET
  },

  methods: {
    del: function(num) {
      const self = this;
      self.$axios.defaults.headers.common['Authorization'] = self.$cookies.get('token');
      self.$axios.delete('/notice/delete/' + num)
        .then(function(resource) {
          if (resource.data.result) {
            self.$router.push('/no-list');
          }
        }); // DELETE
    }, // del:

    getdate: function(date){
      // 날짜 포맷 변경
      const self = this;
      return self.$moment(date).format('YYYY년 MM월 DD일 HH시 mm분');
    } // getdate:

  } // methods{}
}
</script>


<style>

</style>
