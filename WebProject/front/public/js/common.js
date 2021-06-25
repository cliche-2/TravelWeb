/* nav */
$('#nav > ul > li').hover(function() {
  $(this).find('.sub').stop().slideDown()
}, function() {
  $(this).find('.sub').stop().slideUp()
})

// slider
function moveRight() {
  $("#sliderList:not(:animated)").stop().animate({ marginLeft: "-100%" }, function() {
    $(this).append($(">:first", this)).css({ marginLeft: 0 })
  })
}
function moveLeft() {
  $("#sliderList:not(:animated)").prepend($("#sliderList li:last"))
                                 .css({ marginLeft: "-100%"})
                                 .animate({ marginLeft: 0 })
}
$(".next").on('click', function() {
  moveRight();
})
$(".prev").on('click', function() {
  moveLeft();
})

/* slider 자동롤링 */
var timer = setInterval(moveRight, 4000)
$("#menuBtn span").on('click', function() {
  clearInterval(timer)
  timer = setInterval(moveRight, 4000)
})

/* mypage */
$("#m_group div a").hover(function(){
  $(this).parent("div").css({ background: "#005c4f" })
  $(this).css({ color: "#fff" })
},function() {
  $(this).parent("div").css({ background: "#fff" })
  $(this).css({ color: "#000" })
})
