// intro
$(function(){
  $('#intro').delay(3000).fadeOut(800)
});


// 동영상 클릭시
$(function() {
  const black_bg = $('.black_bg');
  
  $(".pop").on("click", function(){
    $('.black_bg').fadeIn();
    $('.sc01_pop_contents').fadeIn();
  });

  
});


function offClick() {
    
    var video = $('.sc01_pop_contents');
    
    document.querySelector('.black_bg').style.display = 'none';
    video.pause();
    
    
}

// snow effect
$(function(){
  $.letItSnow('.let-it-snow', {
    stickyFlakes: 'lis-flake--js',
    makeFlakes: true,
    sticky: true
  });

  var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-36251023-1']);
    _gaq.push(['_setDomainName', 'jqueryscript.net']);
    _gaq.push(['_trackPageview']);
  
    (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();
});

// tab button menu
$(function(){
  const tabList = document.querySelectorAll('.tab_menu .list li');
    
    for(var i = 0; i < tabList.length; i++){
      tabList[i].querySelector('.btn').addEventListener('click', function(e){
        e.preventDefault();
        for(var j = 0; j < tabList.length; j++){
          tabList[j].classList.remove('is_on');
        }
        this.parentNode.classList.add('is_on');
      });
    }
});

//fullpage
$(function(){
  var myFullpage = new fullpage('#fullpage', {
    verticalCentered: false
});
});

// 모달창
$(function(){
  const modal = document.querySelector(".modal");
  const img = document.querySelector('.imo');
  const modal_img = document.querySelector(".modal_content");
  const span = document.querySelector(".close");

  // img.addEventListener('click', ()=>{
  //   modalDisplay("block");
  //   modal_img.src = img.src;
  // });
  
  $('.m1_box img').click(function() {
    $('.m1_box').each(function(){
      modalDisplay("block");
      modal_img.src = img.src;
    });
  });

  span.addEventListener('click', ()=>{
    modalDisplay("none");
  });
  modal.addEventListener('click', ()=>{
    modalDisplay("none");
  });
  function modalDisplay(text){
    modal.style.display = text;
  }
});

// swiper

$(function(){
  var swiper = new Swiper(".img_gallery", {
    loop: true,
    spaceBetween: 10,
    slidesPerView: 4,
    freeMode: true,
    watchSlidesProgress: true,
    
  });
  var swiper2 = new Swiper(".img_gallery2", {
    loop: true,
    spaceBetween: 10,
    autoplay: {
      delay: 2500,
      disableOnInteraction: false,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
    thumbs: {
      swiper: swiper,
    },
  });
});
 $(function(){
  var swiper3 = new Swiper(".last_swiper", {
    // effect : 'ease', //효과
		
    spaceBetween: 30,
    centeredSlides: true,
    autoplay: {
      delay: 3000,
      disableOnInteraction: false,
    },
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });
 });


//  sound
$(function(){
  $('.sound .icon_sound > div:nth-child(1)').on('click', function () {
    $("#sound").trigger('play');
    $('.sound .icon_sound > div:nth-child(1)').fadeOut(600);
    $('.sound .icon_sound > div:nth-child(2)').fadeIn(600);
  });
  $('.sound .icon_sound > div:nth-child(2)').on('click', function () {
    $("#sound").trigger('pause');
    $('.sound .icon_sound > div:nth-child(2)').fadeOut(600);
    $('.sound .icon_sound > div:nth-child(1)').fadeIn(600);
  });
});


// 마우스 움직임 이미지 효과

$(function(){
  document.querySelector(".moveImage").addEventListener("mousemove", function(e){
    //커서
    gsap.to(".cursor", {duration: .2, left: e.pageX -10, top: e.pageY -10});

    //마우스 좌표 값
    let pageX = e.pageX;
    let pageY = e.pageY;

    //기준점 가운데로 변경
    let standardX = window.innerWidth/2 - pageX;
    let standardY = window.innerHeight/2 - pageY;

    //이미지 움직임
    const move = document.querySelector(".ming1");
    const move2 = document.querySelector(".ming2");
    const move3 = document.querySelector(".ming3");
    move.style.transform = "translate(" + standardX/100 + "px," + standardY/100 + "px)";
    move2.style.transform = "translate(" + standardX/50 + "px," + standardY/50 + "px)";
    move3.style.transform = "translate(" + standardX/30 + "px," + standardY/30 + "px)";

    //출력
    document.querySelector(".pageX").textContent = pageX;
    document.querySelector(".pageY").textContent = pageY;
    document.querySelector(".standardX").textContent = standardX;
    document.querySelector(".standardY").textContent = standardY;
});
});


// 캐릭터 설명 모달
$(function(){
  $('.choice .sonbtn').on('click', function () {
    $('.son_modal').fadeIn();
    
  });
  $('.choice2 .fatherbtn').on('click', function () {
    $('.father_modal').fadeIn();
    
  });

  $('.close').on('click', function(){
    $('.pop_modal').fadeOut();
    
  });
});


