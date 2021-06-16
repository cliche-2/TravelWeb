<template>
<div>
  <h3>login form</h3>
  <div>
    <label for='email'>ID</label>
    <input type="text" id='email' v-model='email' />
  </div>
  <div>
    <label for='password'>PWD</label>
    <input type="password" id='password' v-model='password' />
  </div>
    <div>
      test:{{this.msg}}
    </div>
  <button v-on:click='login'>login</button>
</div>
</template>


<script>
// index.js의 router 설정 참고해서 cookies 임포트 해보기

export default {
  name: 'Login',
  data() {
    return {
      email: '',
      password: '',
      mytoken:'',
      msg:'yet'
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
          alert(resource.data.result);
          if (resource.data.result) {
            // set token
            // $cookies 전역변수를 인식 못함..?
            this.$cookies.set('token', resource.data.jwt, 60*60*2);
            alert('set cookie');
            // set header with token
//            this.axios.defaults.headers['token'] = this.$cookies.get('token');
//            alert('set header');
            this.mytoken = this.$cookies.get('token');
            alert(this.mytoken);
            this.msg = this.mytoken;
//            router.push('/');
          }
        }); // POST
    } // login:

  } // methods:
}
</script>
