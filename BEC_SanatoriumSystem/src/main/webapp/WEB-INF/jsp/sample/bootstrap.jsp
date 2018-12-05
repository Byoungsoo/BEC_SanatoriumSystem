<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Navigation</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" type="text/css" href="/css/sample/bootstrap.css" />
</head>

<body>
	<nav>
		<ul>
			<li><a href="http://localhost:8080/sample/openBootstrap.do">HOME</a></li>
			<li><a href="http://localhost:8080/sample/openSampleBoardList.do">ABOUT</a></li>
			<li><a href="#">WEB</a></li>
			<li><a href="#">DESIGN</a></li>
			<li><a href="#">MAP</a></li>
			<li><a href="#">CONTACT</a></li>
		</ul>
		<a href="#" id="trigger">MENU</a>
	</nav>

	<script src="/js/doit/jquery-2.2.4.min.js"></script>
	<script>
		$(function() {
			var trigger = $('#trigger');
			var menu = $('nav ul');
			$(trigger).on('click', function(e) {
				e.preventDefault();
				menu.slideToggle();
			});
			$(window).resize(function() {
				var w = $(window).width();
				if (w > 320 && menu.is(':hidden')) {
					menu.removeAttr('style');
				}
			});
		});
	</script>
</body>
</html>