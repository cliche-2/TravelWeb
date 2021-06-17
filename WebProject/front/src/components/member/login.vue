<template>
<div>
  <main>
    <section id="login_whole">
      <div id="member_banner"></div>
      <div id="breadcrumb_one">
        <a href="index.html">home</a>
        <a href="login.html">로그인</a>
      </div>

      <div id="login">
        <h3>로그인</h3>
        <section id="small">
          <div id="s_small">
            <div id="id">
              <label for='email'>이메일</label>
              <input type="text" id='email' v-model='email' />
            </div>
            <div>
              <label for='password'>비밀번호</label>
              <input type="password" id='password' v-model='password' />
            </div>
            <button v-on:click='login'>login</button>
          </div>
          <div id="s_add">
            <p>아이디/비밀번호를 잊어버리셨나요?<a href="">아이디/비밀번호 찾기</a></p>
            <p>아직 회원이 아니신가요?<router-link to ='/register'>회원가입</router-link></p>
          </div>
        </section>
      </div>
    </section>
  </main>
</div>
</template>


<script>
// index.js의 router 설정 참고해서 cookies 임포트 해보기

export default {
  name: 'Login',
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
    login: function() {
      const self = this;
      const form = new URLSearchParams();
      form.append('email', self.email);
      form.append('password', self.password);

      this.$axios.post('/members/login', form)
        .then(function(resource) {
    //      alert(resource.data.result);
          if (resource.data.result) {
            // set token
            var mytoken = resource.data.jwt
            self.$cookies.set('token', mytoken, 60*60*2);
  //          alert(mytoken);
            // set header with token
            self.$axios.defaults.headers['token'] = mytoken;
  //          alert("isKey:"+self.$cookies.isKey('token'));
            self.$router.push('/');
          } else {
            alert('login failed');
          }
        }); // POST
    } // login:

  } // methods:
}
</script>
