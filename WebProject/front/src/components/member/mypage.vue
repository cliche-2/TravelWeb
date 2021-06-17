<template>
<div>

  <div>

  </div>

  <div>

  </div>

</div>
</template>



<script>
export default {
  name: 'Mypage',
  data() {
    return {
      member: null
    };
  },

  mounted: function() {
    const self = this;
    self.$axios.get('/members/mypage')
      .then(function(resource) {
        alert(resource.data.result);
      }); // GET
  }

}
</script>
