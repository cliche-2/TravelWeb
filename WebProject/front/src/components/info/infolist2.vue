<template>
  <div>

      {{info}}

  </div>
</template>


<script>
export default {
  name: 'InfoList2',
  data(){
    return{
        info:null
    };
  },
  created:function(){
    const self= this;
      this.$axios.get('/travel/area/gangnam')
      .then(function(res){
        if(res.data.result){
          self.info = res.data.jsonResult;
//          self.info = res.data.result;
        } // if
      }); // GET
  }
}
</script>


<style>

</style>
