<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ru">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
<!--	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" /> -->
	<link href="css/main.css" rel="stylesheet" />

	<link href="https://bsuir.by/online/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
	<link href="https://bsuir.by/online/bootstrap/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" >
	<link href="https://bsuir.by/online/layouts/58/style/style.css" rel="stylesheet" type="text/css">
	<link href="css/header.css" rel="stylesheet" type="text/css" charset="utf-8">
	<link href="https://bsuir.by/online/layouts/58/style/footer.css" rel="stylesheet" type="text/css" charset="utf-8">
	<link href="https://bsuir.by/online/layouts/58/style/font.css" rel="stylesheet" type="text/css">

	<script type="text/javascript" src="https://bsuir.by/online/layouts/493/js/jssor.slider.mini.js"></script>

	<script src="webjars/jquery/3.2.1/jquery.min.js"></script>

	<script type="text/javascript">
		$(function () {
			var tabContainers = $('div.news_tabs>div');
			var archiveContainers = $('div.news_archive');
			/*tabContainers.hide().filter(':first').show();*/
			$('div.news_title>span').click(function () {
				tabContainers.hide();
				tabContainers.filter('#content_' + this.id).show();
				archiveContainers.hide().filter('#archive_' + this.id).show();
				$('div.news_title').removeClass('selected_rub');
				$(this).parent().addClass('selected_rub');
				return false;
			}).filter(':first').click();
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function(){

			$(window).scroll(function(){
				if ($(this).scrollTop() > 100) {
					$('.scrollup').fadeIn();
				} else {
					$('.scrollup').fadeOut();
				}
			});

			$('.scrollup').click(function(){
				$("html, body").animate({ scrollTop: 0 }, 600);
				return false;
			});

		});
	</script>

</head>
<body>
<!--
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Spring Boot</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="addUser">Add user</a></li>
				<li><a href="#about">About</a></li>
			</ul>
		</div>
	</div>
</nav>
-->
<header>
	<div class="container">
		<div class="headlogo row-fluid show-grid" align="center">
			<div class="span6">
				<a href="http://www.bsuir.by/musey/" title="На главную">   <img src="https://bsuir.by/m/12_113415_1_105358.png"  alt="Виртуальный музей БГУИР" border="0" vspace="0" hspace="0" ></a>
				<div class="logoimg">
					<div class="header-title-1"><a href="https://www.bsuir.by/musey/" title="На главную">урсовой</a></div>
					<div class="header-title-2"><a href="https://www.bsuir.by/musey/" title="На главную">роект</a></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="span3 offset3">

				<div class="contact">
					<p><a href="">Логин</a></p>
					<p><a href="">Регистрация</a></p></div>
			</div>
		</div>
	</div>
	<div class="nav-bar">
		<div class="container">

			<ul class="nav nav-pills">
				<li id="m1">
					<a href="" target="_self">Просмотр объявлений</a>
				</li>
				<li id="m2" class="active">
					<a href="" target="_self">Подобрать вариант</a>
				</li>
				<li id="m3">
					<a href="" target="_self">Добавить объявление</a>
				</li>
				<li id="m4">
					<a href="" target="_self">Редактировать объявления</a>
				</li>
				<li id="m5">
					<a href="" target="_self">Рассчитать стоимость</a>
				</li>
			</ul>
		</div>
	</div>
</header>
<div id ="content">
<div class="container">

	<div class="starter-template">
		<h1>Spring Boot Web JSP Example</h1>
		<h2>Message: ${message} at ${time}</h2>
	</div>



	<div class="gallery">
		<div class="m_gallery">
			<div class="photo_show">
				<script language="JavaScript1.2"  type="text/javascript">


					function setParameter(str, parameter, value) {
						i = str.indexOf(parameter);
						tmp = '';
						if (i >=0) {
							tmp = str.replace()
						}
					}

					function getNextPage(i) {
						var param = /(pagenum=)\d*/;
						var newparam = 0;
						if (i > 0) {
							newparam = 1;
						}
						else {
							newparam = -1;
						}
						var tmp = new String(document.location);
						var loc = tmp.replace(param, "pagenum="+newparam);
						if (loc == tmp) {
							loc += "&pagenum="+newparam;
						}
						document.location = loc;
						return false;
					}

				</script>


				<link href="css/slider.css" rel="stylesheet" type="text/css">
				<!-- ggggh -->
				<script type="text/javascript">
					jssor_slider1_starter = function (containerId) {
						//Reference http://www.jssor.com/development/slider-with-slideshow-no-jquery.html
						//Reference http://www.jssor.com/development/tool-slideshow-transition-viewer.html

						//var startIndex = Math.floor(Math.random() * 6);
						var startIndex = 0;

						var _SlideshowTransitions = [
							//Extrude Replace
							{ $Duration: 1600, x: -0.2, $Delay: 40, $Cols: 12, $During: { $Left: [0.4, 0.6] }, $SlideOut: true, $Formation: $JssorSlideshowFormations$.$FormationStraight, $Assembly: 260, $Easing: { $Left: $JssorEasing$.$EaseInOutExpo, $Opacity: $JssorEasing$.$EaseInOutQuad }, $Opacity: 2, $Outside: true, $Round: { $Top: 0.5 }, $Brother: { $Duration: 1000, x: 0.2, $Delay: 40, $Cols: 12, $Formation: $JssorSlideshowFormations$.$FormationStraight, $Assembly: 1028, $Easing: { $Left: $JssorEasing$.$EaseInOutExpo, $Opacity: $JssorEasing$.$EaseInOutQuad }, $Opacity: 2, $Round: { $Top: 0.5 } } }
						];

						var _CaptionTransitions = [
							//CLIP|LR
							{$Duration: 900, $Clip: 3, $Easing: $JssorEasing$.$EaseInOutCubic },
							//CLIP|TB
							{$Duration: 900, $Clip: 12, $Easing: $JssorEasing$.$EaseInOutCubic },
						];

						var options = {

							$StartIndex: startIndex,

							$AutoPlay: true,                                    //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
							$AutoPlaySteps: 1,                                  //[Optional] Steps to go for each navigation request (this options applys only when slideshow disabled), the default value is 1
							$AutoPlayInterval: 4000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
							$PauseOnHover: 1,                               //[Optional] Whether to pause when mouse over if a slider is auto playing, 0 no pause, 1 pause for desktop, 2 pause for touch device, 3 pause for desktop and touch device, 4 freeze for desktop, 8 freeze for touch device, 12 freeze for desktop and touch device, default value is 1

							$ArrowKeyNavigation: true,   			            //[Optional] Allows keyboard (arrow key) navigation or not, default value is false
							$SlideDuration: 500,                                //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
							$MinDragOffsetToSlide: 20,                          //[Optional] Minimum drag offset to trigger slide , default value is 20
							//$SlideWidth: 600,                                 //[Optional] Width of every slide in pixels, default value is width of 'slides' container
							//$SlideHeight: 300,                                //[Optional] Height of every slide in pixels, default value is height of 'slides' container
							$SlideSpacing: 0, 					                //[Optional] Space between each slide in pixels, default value is 0
							$DisplayPieces: 1,                                  //[Optional] Number of pieces to display (the slideshow would be disabled if the value is set to greater than 1), the default value is 1
							$ParkingPosition: 0,                                //[Optional] The offset position to park slide (this options applys only when slideshow disabled), default value is 0.
							$UISearchMode: 1,                                   //[Optional] The way (0 parellel, 1 recursive, default value is 1) to search UI components (slides container, loading screen, navigator container, arrow navigator container, thumbnail navigator container etc).
							$PlayOrientation: 1,                                //[Optional] Orientation to play slide (for auto play, navigation), 1 horizental, 2 vertical, 5 horizental reverse, 6 vertical reverse, default value is 1
							$DragOrientation: 3,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

							$SlideshowOptions: {                                //[Optional] Options to specify and enable slideshow or not
								$Class: $JssorSlideshowRunner$,                 //[Required] Class to create instance of slideshow
								$Transitions: _SlideshowTransitions,            //[Required] An array of slideshow transitions to play slideshow
								$TransitionsOrder: 1,                           //[Optional] The way to choose transition to play slide, 1 Sequence, 0 Random
								$ShowLink: true                                    //[Optional] Whether to bring slide link on top of the slider when slideshow is running, default value is false
							},

							$CaptionSliderOptions: {                            //[Optional] Options which specifies how to animate caption
								$Class: $JssorCaptionSlider$,                   //[Required] Class to create instance to animate caption
								$CaptionTransitions: _CaptionTransitions,       //[Required] An array of caption transitions to play caption, see caption transition section at jssor slideshow transition builder
								$PlayInMode: 1,                                 //[Optional] 0 None (no play), 1 Chain (goes after main slide), 3 Chain Flatten (goes after main slide and flatten all caption animations), default value is 1
								$PlayOutMode: 3                                 //[Optional] 0 None (no play), 1 Chain (goes before main slide), 3 Chain Flatten (goes before main slide and flatten all caption animations), default value is 1
							},

							$BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
								$Class: $JssorBulletNavigator$,                       //[Required] Class to create navigator instance
								$ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
								$AutoCenter: 1,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
								$Steps: 1,                                      //[Optional] Steps to go for each navigation request, default value is 1
								$Lanes: 1,                                      //[Optional] Specify lanes to arrange items, default value is 1
								$SpacingX: 10,                                   //[Optional] Horizontal space between each item in pixel, default value is 0
								$SpacingY: 10,                                   //[Optional] Vertical space between each item in pixel, default value is 0
								$Orientation: 1                                 //[Optional] The orientation of the navigator, 1 horizontal, 2 vertical, default value is 1
							},

							$ArrowNavigatorOptions: {
								$Class: $JssorArrowNavigator$,              //[Requried] Class to create arrow navigator instance
								$ChanceToShow: 2                                //[Required] 0 Never, 1 Mouse Over, 2 Always
							}
						};

						var jssor_slider1 = new $JssorSlider$(containerId, options);
						/*//responsive code begin
						//you can remove responsive code if you don't want the slider scales while window resizes
						function ScaleSlider() {
							var parentWidth = jssor_slider1.$Elmt.parentNode.clientWidth;
							if (parentWidth)
								jssor_slider1.$SetScaleWidth(Math.min(parentWidth, 1235));
							else
								$JssorUtils$.$Delay(ScaleSlider, 30);
						}

						ScaleSlider();
						$JssorUtils$.$AddEvent(window, "load", ScaleSlider);


						if (!navigator.userAgent.match(/(iPhone|iPod|iPad|BlackBerry|IEMobile)/)) {
							$JssorUtils$.$OnWindowResize(window, ScaleSlider);
						}

						//if (navigator.userAgent.match(/(iPhone|iPod|iPad)/)) {
						//    $JssorUtils$.$AddEvent(window, "orientationchange", ScaleSlider);
						//}
						//responsive code end*/
					};
				</script>

				<!-- Jssor Slider Begin -->
				<!-- You can move inline styles to css file or css block. -->
				<div id="slider1_container" class="m_g_container">

					<!-- Loading Screen -->
					<div u="loading" class="m_g_loading">
						<div class="m_g_loading_bg">
						</div>
						<div class="m_g_loading_roam">
						</div>
					</div>

					<!-- Slides Container -->
					<div u="slides" class="m_g_slides">

						<div>
							<!-- <a u=image href="#"><img src="/m/12_100229_1_114496.jpg" ></a> -->
							<!-- gdp 16.09.15 <a href="https://www.youtube.com/user/videostudiabsuir" target="_blank"><img src="/m/12_100229_1_114496.jpg" u=image></a> -->
							<!-- tzv 10.12.15 url = &nbsp; -->
							<img src="https://bsuir.by/m/12_100229_1_114496.jpg" u=image></div>
						<div>
							<!-- <a u=image href="#"><img src="/m/12_100229_1_120117.jpg" ></a> -->
							<!-- gdp 16.09.15 <a href="https://www.youtube.com/user/videostudiabsuir" target="_blank"><img src="/m/12_100229_1_120117.jpg" u=image></a> -->
							<!-- tzv 10.12.15 url = <a href="/ru/proekt-bguir-znaniya-i-stil-zhizni"  >общая страница зож2017</a> -->
							<a href="https://bsuir.by/ru/proekt-bguir-znaniya-i-stil-zhizni"><img src="https://bsuir.by/m/12_100229_1_120117.jpg" u=image></a>
						</div>
						<div>
							<!-- <a u=image href="#"><img src="/m/12_100229_1_118968.jpg" ></a> -->
							<!-- gdp 16.09.15 <a href="https://www.youtube.com/user/videostudiabsuir" target="_blank"><img src="/m/12_100229_1_118968.jpg" u=image></a> -->
							<!-- tzv 10.12.15 url = <a href="https://bi.bsuir.by/"  >https://bi.bsuir.by/</a> -->
							<a href="https://bi.bsuir.by/"><img src="https://bsuir.by/m/12_100229_1_118968.jpg" u=image></a>
						</div>
						<div>
							<!-- <a u=image href="#"><img src="/m/12_100229_1_117004.jpg" ></a> -->
							<!-- gdp 16.09.15 <a href="https://www.youtube.com/user/videostudiabsuir" target="_blank"><img src="/m/12_100229_1_117004.jpg" u=image></a> -->
							<!-- tzv 10.12.15 url = <a href="https://www.bsuir.by/ru/news/99679-obnovlennaya-respublikanskaya-doska-pocheta-otkrylas-v-minske--bguir-snova-sredi-pobediteley"  >https://www.bsuir.by/ru/news/99679-obnovlennaya-respublikanskaya-doska-pocheta-otkrylas-v-minske--bguir-snova-sredi-pobediteley</a> -->
							<a href="https://www.bsuir.by/ru/news/99679-obnovlennaya-respublikanskaya-doska-pocheta-otkrylas-v-minske--bguir-snova-sredi-pobediteley"><img src="https://bsuir.by/m/12_100229_1_117004.jpg" u=image></a>
						</div>
						<div>
							<!-- <a u=image href="#"><img src="/m/12_100229_1_114724.jpg" ></a> -->
							<!-- gdp 16.09.15 <a href="https://www.youtube.com/user/videostudiabsuir" target="_blank"><img src="/m/12_100229_1_114724.jpg" u=image></a> -->
							<!-- tzv 10.12.15 url = <a href="https://www.bsuir.by/ru/news/99439-bguir-vruchili-nagradu-za-dostizheniya-v-oblasti-kachestva"  >https://www.bsuir.by/ru/news/99439-bguir-vruchili-nagradu-za-dostizheniya-v-oblasti-kachestva</a> -->
							<a href="https://www.bsuir.by/ru/news/99439-bguir-vruchili-nagradu-za-dostizheniya-v-oblasti-kachestva"><img src="https://bsuir.by/m/12_100229_1_114724.jpg" u=image></a>
						</div>
						<div>
							<!-- <a u=image href="#"><img src="/m/12_100229_1_110666.jpg" ></a> -->
							<!-- gdp 16.09.15 <a href="https://www.youtube.com/user/videostudiabsuir" target="_blank"><img src="/m/12_100229_1_110666.jpg" u=image></a> -->
							<!-- tzv 10.12.15 url = <a href="http://distant.bsuir.by/dot/"  >http://distant.bsuir.by/dot/</a> -->
							<a href="http://distant.bsuir.by/dot/"><img src="https://bsuir.by/m/12_100229_1_110666.jpg" u=image></a>
						</div>
						<div>
							<!-- <a u=image href="#"><img src="/m/12_100229_1_110250.jpg" ></a> -->
							<!-- gdp 16.09.15 <a href="https://www.youtube.com/user/videostudiabsuir" target="_blank"><img src="/m/12_100229_1_110250.jpg" u=image></a> -->
							<!-- tzv 10.12.15 url = <a href="http://ias.bsuir.by"  >http://ias.bsuir.by </a> -->
							<a href="http://ias.bsuir.by"><img src="https://bsuir.by/m/12_100229_1_110250.jpg" u=image></a>
						</div>
						<div>
							<!-- <a u=image href="#"><img src="/m/12_100229_1_119614.png" ></a> -->
							<!-- gdp 16.09.15 <a href="https://www.youtube.com/user/videostudiabsuir" target="_blank"><img src="/m/12_100229_1_119614.png" u=image></a> -->
							<!-- tzv 10.12.15 url = <a href="http://bit-cup.bsuir.by/"  >http://bit-cup.bsuir.by/</a> -->
							<a href="http://bit-cup.bsuir.by/"><img src="https://bsuir.by/m/12_100229_1_119614.png" u=image></a>
						</div>
					</div>

					<div u="navigator" class="jssorb21 m_g_navigator">
						<!-- bullet navigator item prototype -->
						<div u="prototype" class="m_g_bullets"></div>
					</div>
					<!-- Arrow Left -->
					<span u="arrowleft" class="jssora05l">
		</span>
					<!-- Arrow Right -->
					<span u="arrowright" class="jssora05r">
		</span>
				</div>
			</div>
			<script type="text/javascript">
				jssor_slider1_starter('slider1_container');
			</script>	</div>
	</div>

	<a href="#" class="scrollup">Scroll</a>

</div>
</div>
<script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>

</html>