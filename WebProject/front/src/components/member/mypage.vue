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
    // 요청시 아래 헤더 추가해주기  
    self.$axios.defaults.headers.common['Authorization'] = self.$cookies.get('token');
    self.$axios.get('/members/mypage')
      .then(function(resource) {
        alert(resource.data.result);
      }); // GET
  }

}
</script>
