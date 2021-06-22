<template>
<div>
  <main>
    <section id="mypage_whole">
      <div id="mypage_banner"></div>
      <div id="mypage2">
        <h3 class="mypage">회원관리</h3>
        <section id="m_2">
          <table>
            <tr class="manage_cap">
              <th>이름</th>
              <th>이메일</th>
              <th>가입일자</th>
              <th>삭제</th>
            </tr>

            <tr v-for="user in userlist" v-bind:key="user.memNum">
              <td>{{user.name}}</td>
              <td>{{user.email}}</td>
              <td>{{user.regDate}}</td>

              <td><button class="d_btn" v-on:click="del(user.memNum)">회원삭제</button></td>
            </tr>

          </table>
          <router-link to="/" class="con2">돌아가기</router-link>

        </section>
      </div>
    </section>
  </main>

</div>
</template>



<script>
export default {
  name: 'Admin',
  data() {
    return {
      userlist: [],
      isChanged: false
    };
  },

  watch: {
    'isChanged': 'remove'
  },

  created: function() {
    const self = this;
    self.$axios.defaults.headers.common['Authorization'] = self.$cookies.get('token');
    self.$axios.get('members/userlist')
      .then(function(resource) {
        self.userlist = resource.data.memberList;
      }); // GET
  },

  methods: {

    del: function(memNum) {
      var answer = confirm('삭제');
      if (!answer) return;
      const self = this;
      self.$axios.delete('/members/' + memNum)
        .then(function(resource) {
          if (resource.data.result) {
            alert('삭제됨');
            self.isChanged=true;
          }
        }); // DELETE
    }, // del

    remove: function() {
      const self = this;
      self.$axios.defaults.headers.common['Authorization'] = self.$cookies.get('token');
      self.$axios.get('members/userlist')
        .then(function(resource) {
          self.userlist = resource.data.memberList;
          self.isChanged=false;
        }); // GET
    } // remove

  } // methods:
}
</script>
