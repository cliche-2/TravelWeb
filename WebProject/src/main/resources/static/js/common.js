/* nav */
$('#nav > ul > li').hover(function() {
  $(this).find('.sub').stop().slideDown()
}, function() {
  $(this).find('.sub').stop().slideUp()
})


/* mypage */
$("#m_group div a").hover(function(){
  $(this).parent("div").css({ background: "#005c4f" })
  $(this).css({ color: "#fff" })
},function() {
  $(this).parent("div").css({ background: "#fff" })
  $(this).css({ color: "#000" })
})
