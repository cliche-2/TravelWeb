<template>
<div>

EMAIL:<input type="text" v-model="email"><br />
PassWord:<input type="password" v-model="password"><br />
Name:<input type="text" v-model="name"><br />

  <button v-on:click="join">join</button>

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
    const form = new URLSearchParams();
    form.append('email', this.email);
    form.append('password', this.password);
    form.append('name', this.name);

    this.$axios.post('/members', form)
    .then(function(resource){
      if(resource.data.result){
        location.href='index.html'
      }
    });
  }
}

}
</script>
