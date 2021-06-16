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
            <label for='password'>PassWord :</label>
            <input type="password" v-model="password" />
          </div>
            <div>
              <label for='name'>Name :</label>
              <input type="text" v-model="name" />
            </div>
          <button v-on:click="join">join</button>
        </div>
       </section>
      </div>
    </section>

</div>
</template>



<script>
export default {

name: 'Register',
data(){
  return{
    email:'',
    password:'',
    name:''
  };
},

methods:{
  join:function(){
    const self = this;
    const form = new URLSearchParams();
    form.append('email', this.email);
    form.append('password', this.password);
    form.append('name', this.name);

    this.$axios.post('/members/register', form)
    .then(function(resource){
      if(resource.data.result){
        self.$router.push('/login');
      }
    });
  }, // join:

  emailcheck:function(){
    // email 유효성 검사
    // 중복 체크

  },

  namecheck:function(){
    // 유효성 검사 2~8글자
    // 중복 체크

  },

  pwcheck:function(){
    // 숫자, 문자, 특수문자 6~24자리

  }

}

}
</script>
