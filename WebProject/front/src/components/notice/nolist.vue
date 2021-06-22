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
        <section id="m_2">
          <table>
            <tr class="notice_cap">
              <th>No</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일자</th>
              <th>조회수</th>
            </tr>
            <tr v-for="noti in list" v-bind:key="noti.infoNum">
              <td>{{noti.infoNum}}</td>
              <td><a class="click" v-on:click="getone(noti.infoNum)">
                {{noti.infoTitle}}</a></td>
              <td>관리자</td>
              <td>{{getdate(noti.infoDate)}}</td>
              <td>{{noti.viewCount}}</td>
            </tr>
          </table>

          <div v-if="admin">
          <router-link to="/no-write" class="write">새글쓰기</router-link>
          </div>

        </section>
      </div>
    </section>
  </main>

</div>
</template>


<script>
export default {
  name: 'NoList',
  data(){
    return{
      list:[],
      admin:false
    };
  },

  created:function(){
    const self = this;

    var hascookie = self.$cookies.isKey('token');
    if(hascookie){
      if(self.$cookies.get('memnum') == 1)
      self.admin = true;
    }

    self.$axios.get('/notice')
    .then(function(resource){
      if(resource.data.result){
        self.list = resource.data.boardList;
      }
    }); // GET
  },

  methods:{
    getone: function(num){
      this.$router.push({
        name:'NoDetail',
        params:{
          num:num
        }
      });
    }, // getone:

    getdate: function(date){
      // 날짜 포맷 변경
      const self = this;
      return self.$moment(date).format('YYYY년 MM월 DD일');
    }


  }

}

</script>


<style>

</style>
