<template>
<div>

  <section id="login_whole">
    <div id="member_banner"></div>
    <div id="breadcrumb_one">
      <a href="index.html">home</a>
      <a href="register.html">회원가입</a>
    </div>
    <div id="register">
      <h3>회원가입</h3>
      <section id="small">
        <div id="r_small">
          <div>
            <label for='email'>EMAIL :</label>
            <input type="text" v-model="email" />
        
          </div>
          <div>
            <label for='password'>password :</label>
            <input type="password" v-model="password" />
          </div>
          <div>
            <label for='name'>Name :</label>
            <input type="text" v-model="name" />
          </div>

          <button class="over" v-on:click="check">중복체크</button>
          <button class="join" v-on:click="join">join</button>


        </div>
      </section>
    </div>
  </section>

</div>
</template>



<script>
export default {

  name: 'Register',
  data() {
    return {
      email: '',
      password: '',
      name: '',
      // 위 값이 바뀌면 아래도 모두 초기화해야하긴 함
      demailchk: false,
      emailchk: false,
      pwdchk: false,
      emailmsg: 'aa'
    };
  },

  methods: {

    join: function() {
      const self = this;

      // 빈 칸 체크
      if (this.email == '' || this.password == '' || this.name == '') {
        alert('모두 기입해야 함');
        return;
      }

      // 이메일, 비밀번호 유효성 체크
      var e = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      var p = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;

      if (e.test(this.email)) {
        this.emailchk = true;
      } else {
        alert("이메일 형식");
        this.emailchk = false;
        return;
      }

      if (p.test(this.password)) {
        this.pwdchk = true;
      } else {
        alert("비밀번호는 8자이상 숫자+문자");
        this.pwdchk = false;
        return;
      }

      if (!this.demailchk){
        alert("이메일 중복체크");
         return;
      }


      // 로그인 정보 전송
      const form = new URLSearchParams();
      form.append('email', this.email);
      form.append('password', this.password);
      form.append('name', this.name);

      this.$axios.post('/members/register', form)
        .then(function(resource) {
          if (resource.data.result) {
            alert('가입완료');
            self.$router.push('/login');
          }
        });

    }, // join:

    check: function() {
      // 중복 체크
      const self = this;
      const form = new URLSearchParams();
      if (this.email == '') {
        alert('이메일을 입력');
        return;
      }
      form.append('email', this.email);
      self.$axios.post('/members/check', form)
        .then(function(resource) {
          if (resource.data.result) {
            self.emailmsg = resource.data.message;
            alert(self.emailmsg);
            if (resource.data.available) {
              self.demailchk = true;
            }
          }
        }); // POST

      // 숫자, 문자, 특수문자 6~24자리
      self.pwdchk = true;
    }

  }

}
</script>
