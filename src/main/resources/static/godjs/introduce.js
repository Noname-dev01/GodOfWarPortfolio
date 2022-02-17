// 동영상 클릭시
$(function() {
    const black_bg = $('.black_bg');

    $(".pop").on("click", function(){
        $('.v1').fadeIn();
        // $('.sc01_pop_contents').fadeIn();
    });


});
$(function() {
    const black_bg = $('.black_bg');

    $(".pop2").on("click", function(){
        $('.v2').fadeIn();
        // $('.sc01_pop_contents').fadeIn();
    });


});
$(function() {
    const black_bg = $('.black_bg');

    $(".pop3").on("click", function(){
        $('.v3').fadeIn();
        // $('.sc01_pop_contents').fadeIn();
    });


});



function offClick() {

    var video = $('.sc01_pop_contents');

    document.querySelector('.black_bg').style.display = 'none';
    document.querySelector('.v2').style.display = 'none';
    document.querySelector('.v3').style.display = 'none';
    // video.pause();


}


// parallax
$(function(){
    $('.banner').parallax({
        imageSrc : '../img/introduce/introduce.jpg',
        speed:0,

    });

    $('.banner2').parallax({
        imageSrc : '../img/introduce/god-of-war-bg-image-dark.png',
        speed:0,

    });
});


$(function(){
    const swiper = new Swiper('.swiper', {

        loop: true,
        autoplay: {
            delay: 2500,
            disableOnInteraction: false,
        },

        pagination: {
            el: '.swiper-pagination',
        },

        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },

    });
});