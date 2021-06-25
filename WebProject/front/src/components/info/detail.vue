<template>
<div>
  <main>
    <section id="detail">
      <div id="place_banner">
        <div class="place">
          <p>Everything about traveling to Seoul</p>
          <h2>명소</h2>
        </div>
      </div>
      <div id="breadcrumb">
        <a href="index.html">home</a>
        <a href="sights.html">여행지</a>
        <a href="sights.html">명소</a>
      </div>
      <section id="detail_group">
        <div id="intro">
          <p>구분카테고리명</p>
          <p>{{site.title}}</p>


          <span v-if="!check" v-on:click='bookmark' class="bookmark off"></span>
          <span v-if="check"  v-on:click='bookmark' class="bookmark"></span>


          <img :src="site.firstimage" alt="" style="width: 1260px">

          <div id="content">
            {{site.overview}}<br>
          </div>
        </div>
        <div id="info">
          <h2 class="hidden"><a href="#">정보</a></h2>
          <ul>
            <li>주소 <span>{{site.addr1}}</span></li>
            <!-- 파싱해야함
            <li>홈페이지 <span>{{site.homepage}}</span></li>
          -->
            <li>우편번호 <span>{{site.zipcode}}</span></li>

          </ul>
        </div>
      </section>

    </section>
  </main>

</div>
</template>


<script>

export default {
  name: 'InfoDetail',
  props: {
    contentid: {
      type: String,
      default: ''
    }
  },
  data() {
    return {
      site: [],
      cid: '',
      check: false,
      bookid: 0,
      mapx:0
    };
  },
  created: function() {
    const self = this;
    self.cid = this.$route.params.contentid;
    this.$axios.get('/travel/detail/' + self.cid)
      .then(function(res) {
        if (res.data.result) {
          var temp = JSON.parse(res.data.jsonResult);
          self.site = temp.response.body.items.item;
          self.mapx = self.site.mapx;
          // 만약 로그인했고, memnum에 해당하는 bookmark객체에
          // cid가 있다면
          // self.check = true;
          if(self.$cookies.isKey('token')){
        //    alert('/find/'+self.cid+'/'+self.$cookies.get('memnum'));
            var cid = self.cid;
            var memNum = self.$cookies.get('memnum');
            self.$axios.get('/bookmarks/find/'+cid+'/'+memNum)
            .then(function(res){
              if(res.data.result){
                if(res.data.booknum != 0){
                  self.check = true;
                  self.bookid = res.data.booknum;
                }
              }
            }); // GET
          }

        } // if
      }); // GET
  },

  methods:{
    bookmark: function(){
        const self = this;

        if(!self.$cookies.isKey('token')){
          alert('로그인 시 사용 가능합니다.');
          return;
        }

        self.$axios.defaults.headers.common['Authorization'] = self.$cookies.get('token');

        if(self.check){
          // 북마크 제거 DELETE 요청
          self.$axios.delete('/bookmarks/'+self.bookid)
          .then(function(res){
            if(res.data.result){
              alert('북마크에서 삭제되었습니다.');
              self.check = false;
            }
          }); // DELETE
        } else{
          // 북마크 추가 POST 요청
          const form = new URLSearchParams();
          form.append('member', self.$cookies.get('memnum'));
          form.append('contentid', self.cid);
          form.append('title', self.site.title);
          form.append('firstimage', self.site.firstimage);
          form.append('contentTypeId', self.site.contenttypeid);
          form.append('sigungucode', self.site.sigungucode);

          self.$axios.post('/bookmarks', form)
          .then(function(resource){
            if(resource.data.result){
              self.check = true;
              alert('북마크에 등록되었습니다.');

              // 메소드 추출하기
              self.$axios.get('/bookmarks/find/'+self.cid+'/'+self.$cookies.get('memnum'))
              .then(function(res){
                if(res.data.result){
                  if(res.data.booknum != 0){
                    self.check = true;
                    self.bookid = res.data.booknum;
                  }
                }
              }); // GET
            }
          }); // POST
        }


    } // bookmark:
  }
}
</script>


<style>

</style>
