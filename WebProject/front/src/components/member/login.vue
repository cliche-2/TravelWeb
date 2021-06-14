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
      test:{{token.data}}
    </div>
  <button v-on:click='login'>login</button>

</div>
</template>


<script>
export default {
  name: 'Login',
  data() {
    return {
      email: '',
      password: '',
      token: ''
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
          if (resource.data.result) {
            alert(resource.data.jwt);
            this.token = resource.data.jwt;
          }
        });
    } // login:

  } // methods:
}
</script>
