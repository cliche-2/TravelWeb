<template>
  <div>
    <main>
      <section id="mypage_whole">
        <div id="mypage_banner"></div>
        <div id="breadcrumb_one">
          <a href="index.html">home</a>
          <a href="mypage.html">마이페이지</a>
        </div>
        <div id="mypage1">
          <h3 class="mypage">{{member.name}}님의 마이페이지</h3>
          <section id="m_1">
            <div class="title1">
              <span>내정보</span>
            </div>
            <table>
              <tr>
                <td class="t_name">이메일</td>
                <td>{{member.email}}</td>
              </tr>
              <tr>
                <td class="t_name">비밀번호</td>
                <td><input type="password" v-model="password" placeholder=" 8자 이상의 숫자,문자"></td>
              </tr>
              <tr>
                <td class="t_name">이름</td>
                <td><input type="text" v-model="name"></td>
              </tr>
              <tr>
                <td class="t_name">가입일자</td>
                <td>{{getdate(member.regDate)}}</td>
              </tr>
            </table>
            <div id="m_1_group">
              <a href="" class="modify" v-on:click="update">수정</a>
              <router-link to="/mypage" class="con1">마이페이지로</router-link>
            </div>
            <a href="" class="sece" v-on:click="del">탈퇴하기</a>
          </section>
        </div>
      </section>
    </main>

  </div>
</template>



<script>
export default {
  name: 'Myinfo',
  data() {
    return {
      member: null,
      name:'',
      password:'',
      isDel:''
    };
  },

  created: function() {
    const self = this;
    if (!self.$cookies.isKey('token')) {
      self.$router.push('/');
      return;
    }

    self.$axios.defaults.headers.common['Authorization'] = self.$cookies.get('token');
    self.$axios.get('/members/mypage')
      .then(function(resource) {
        self.member = resource.data.m;
        self.name = self.member.name;
      }); // GET
  },

  methods:{
    update: function(){
      const self = this;

      // check blank
      if(self.name=='' || self.password==''){
        alert('이름과 비밀번호를 입력하세요.');
        return;
      }

      // check password
      var p = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
      if(!p.test(self.password)){
        alert("비밀번호는 8자이상 숫자+문자");
        return;
      }

      // send update
      const form = new URLSearchParams();
      form.append('email', self.member.email);
      form.append('password', self.password);
      form.append('name', self.name);
      form.append('memNum', self.member.memNum);
      self.$axios.put('/members/'+self.member.memNum, form)
      .then(function(resource){
        if(resource.data.result){
          alert('수정완료');
        //  self.$router.push('/mypage');
        } else {
          alert('수정실패');
        }
      }); // PUT
    }, // update:

    del: function(){
      var answer =confirm('탈퇴');
      if (!answer) return;
      const self = this;
      self.$cookies.remove('token');
      self.$axios.delete('/members/'+self.member.memNum)
//      .then(function(resource){
//        if(resource.data.result){
//          alert('탈퇴');
//          self.$cookies.remove('token');
//          self.$router.push('/');
//        }
//      })
      ; // DELETE
    }, // delete:


    getdate: function(date){
      // 날짜 포맷 변경
      const self = this;
      return self.$moment(date).format('YYYY년 MM월 DD일 HH시');
    }

  }

}
</script>
