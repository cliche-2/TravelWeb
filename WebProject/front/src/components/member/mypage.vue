<template>
  <div>
    <main>
      <section id="mypage_whole">
            <div id="mypage_banner"></div>
            <div id="breadcrumb_one">
              <a href="index.html">home</a>
              <a href="mypage.html">마이페이지</a>
            </div>

            <div id="mypage">
              <h3 class="mypage">{{member.name}}님의 마이페이지</h3>
              <section id="m_group">
                <div>
                    <router-link to='/myinfo'>
                      <span>내 정보</span>
                    </router-link>
                </div>
                <div>
                    <router-link to='/mypost'>
                      <span>작성한 글</span>
                    </router-link>
                </div>
                <div>
                    <router-link to='/mybookmark'>
                      <span>북마크</span>
                    </router-link>
                </div>
              </section>
            </div>
          </section>
    </main>

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
//        alert(resource.data.result);
        self.member = resource.data.m;
        if(self.member.memNum == 1){
          self.$router.push('/admin');
        }
      }); // GET
  }

}
</script>
